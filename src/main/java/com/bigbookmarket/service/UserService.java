package com.bigbookmarket.service;

import com.bigbookmarket.domain.ItemRepository;
import com.bigbookmarket.domain.UserRepository;
import com.bigbookmarket.web.dto.ItemListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public List<ItemListResponseDto> findBySellerId(String id) {
        Long sellerId = userRepository.findById(id).get().getUserId(); // TODO: 에러처리
        return itemRepository.findBySellerId(sellerId).stream()
                .map(ItemListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ItemListResponseDto> findByBuyerId(String id) {
        Long buyerId = userRepository.findById(id).get().getUserId(); // TODO: 에러처리
        return itemRepository.findByBuyerId(buyerId).stream()
                .map(ItemListResponseDto::new)
                .collect(Collectors.toList());
    }
}
