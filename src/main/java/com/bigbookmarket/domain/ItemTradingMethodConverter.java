package com.bigbookmarket.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ItemTradingMethodConverter implements AttributeConverter<ItemTradingMethod, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ItemTradingMethod tradingMethod) {
        return tradingMethod.value;
    }

    @Override
    public ItemTradingMethod convertToEntityAttribute(Integer integer) {
        return Stream.of(ItemTradingMethod.values())
                .filter(c -> c.value == integer)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}