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

    @Transactional
    public Long save(ItemSaveRequestDto requestDto) {
        // TODO: 있으면 그대로, 없으면 insert 되는지 확인해보기
        bookRepository.save(requestDto.getBook());
        return itemRepository.save(requestDto.toEntity()).getItemId();
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
        item.deal(buyer);
        return itemId;
    }

    @Transactional
    public Long cancel(Long itemId, String id) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Item이 없습니다. itemId = " + itemId));
        if (id.equals(item.getSeller().getId())) {
            // TODO: 판매자가 취소한 경우 구매자에게 취소쪽지 발송
            log.info("구매자 " + item.getBuyer().getId() + "에게 취소쪽지 발송");
        } else {
            // TODO: 구매자가 취소한 경우 판매자에게 취소쪽지 발송
            log.info("판매자 " + item.getSeller().getId() + "에게 취소쪽지 발송");
        }
        item.cancel();
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
