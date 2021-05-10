package com.bigbookmarket.domain;

//@Converter(autoApply = true)
//public class ItemTradingMethodConverter implements AttributeConverter<ItemTradingMethod, Integer> {
//
//    @Override
//    public Integer convertToDatabaseColumn(ItemTradingMethod tradingMethod) {
//        return tradingMethod.value;
//    }
//
//    @Override
//    public ItemTradingMethod convertToEntityAttribute(Integer integer) {
//        return Stream.of(ItemTradingMethod.values())
//                .filter(c -> c.value == integer)
//                .findFirst()
//                .orElseThrow(IllegalArgumentException::new);
//    }
//}