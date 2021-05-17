package com.bigbookmarket.service;

import com.bigbookmarket.domain.ItemRepository;
import com.bigbookmarket.web.dto.ItemListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public List<ItemListResponseDto> findItem(Long userId) {
        return itemRepository.findItem(userId).stream()
                .map(ItemListResponseDto::new)
                .collect(Collectors.toList());
    }
}
