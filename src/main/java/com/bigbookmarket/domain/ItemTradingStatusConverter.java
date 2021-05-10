package com.bigbookmarket.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ItemTradingStatusConverter implements AttributeConverter<ItemTradingStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ItemTradingStatus itemTradingStatus) {
        return itemTradingStatus.value;
    }

    @Override
    public ItemTradingStatus convertToEntityAttribute(Integer integer) {
        return Stream.of(ItemTradingStatus.values())
                .filter(c -> c.value == integer)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
