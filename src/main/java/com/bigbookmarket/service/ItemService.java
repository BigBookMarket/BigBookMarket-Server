package com.bigbookmarket.service;

import com.bigbookmarket.domain.*;
import com.bigbookmarket.web.dto.ItemListResponseDto;
import com.bigbookmarket.web.dto.ItemResponseDto;
import com.bigbookmarket.web.dto.ItemSaveRequestDto;
import com.bigbookmarket.web.dto.ItemUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ItemService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final ItemRepository itemRepository;
    private final MessageRepository messageRepository;

    @Transactional
    public Long save(ItemSaveRequestDto requestDto) {
        // TODO: 있으면 그대로, 없으면 insert 되는지 확인해보기
        bookRepository.save(requestDto.getBook());
        User user = userRepository.findById(requestDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 User가 없습니다. id = " + requestDto.getId()));
        return itemRepository.save(requestDto.toEntity(user)).getItemId();
    }

    @Transactional
    public Long update(Long itemId, ItemUpdateRequestDto requestDto) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Item이 없습니다. itemId = " + itemId));
        item.update(requestDto.getPrice(), requestDto.getMethod(), requestDto.getDetail());
        return itemId;
    }

    @Transactional
    public void delete(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Item이 없습니다. itemId = " + itemId));
        itemRepository.delete(item);
    }

    @Transactional(readOnly = true)
    public ItemResponseDto findByItemId(Long itemId) {
        Item entity = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Item이 없습니다. itemId = " + itemId));
        return new ItemResponseDto(entity);
    }

    @Transactional
    public Long deal(Long itemId, String id) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Item이 없습니다. itemId = " + itemId));
        User buyer = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 User가 없습니다. id = " + id));
        Message message = Message.builder()
                .item(item)
                .sender(buyer)
                .receiver(item.getSeller())
                .content("[대책마켓 발신]\n구매자 " + buyer.getNickname() + "님이 거래를 신청하셨습니다.")
                .build();
        messageRepository.save(message);
        item.deal(buyer);
        return itemId;
    }

    @Transactional
    public Long cancel(Long itemId, String id) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Item이 없습니다. itemId = " + itemId));
        Message message;
        if (id.equals(item.getSeller().getId())) {
            message = Message.builder()
                    .item(item)
                    .sender(item.getSeller())
                    .receiver(item.getBuyer())
                    .content("[대책마켓 발신]\n판매자 " + item.getSeller().getNickname() + "님이 거래를 취소하셨습니다.")
                    .build();
        } else {
            message = Message.builder()
                    .item(item)
                    .sender(item.getBuyer())
                    .receiver(item.getSeller())
                    .content("[대책마켓 발신]\n구매자 " + item.getBuyer().getNickname() + "님이 거래를 취소하셨습니다.")
                    .build();
        }
        messageRepository.save(message);
        item.cancel();
        return itemId;
    }

    @Transactional
    public Long sold(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Item이 없습니다. itemId = " + itemId));
        Message message = Message.builder()
                .item(item)
                .sender(item.getBuyer())
                .receiver(item.getSeller())
                .content("[대책마켓 발신]\n구매자 " + item.getBuyer().getNickname() + "님이 거래를 완료하셨습니다.")
                .build();
        messageRepository.save(message);
        item.sold();
        return itemId;
    }

    @Transactional(readOnly = true)
    public List<ItemListResponseDto> findAll() {
        return itemRepository.findAll().stream()
                .map(ItemListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ItemListResponseDto> findByCategory(String category) {
        return itemRepository.findByCategory(category).stream()
                .map(ItemListResponseDto::new)
                .collect(Collectors.toList());
    }
}
