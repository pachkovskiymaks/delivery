package com.pachkovskiymaks.deliveryfoodbe.mapper;


import com.pachkovskiymaks.deliveryfoodbe.model.OrderDto;
import com.pachkovskiymaks.deliveryfoodbe.model.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderMapper {

    private final FoodMapper foodMapper;


    public OrderDto mapEntityToDto(OrderEntity order) {
        return OrderDto.builder()
                .id(order.getId())
                .foodList(foodMapper.mapEntityToDto(order.getFoodList()))
                .build();
    }

    public OrderEntity mapDtoToEntity(OrderDto order) {
        return OrderEntity.builder()
                .id(order.getId())
                .foodList(foodMapper.mapDtoToEntity(order.getFoodList()))
                .build();
    }

    public List<OrderDto> mapDtoToEntity(List<OrderEntity> orderEntities) {
        return orderEntities.stream().map(this::mapEntityToDto).collect(Collectors.toList());
    }

}
