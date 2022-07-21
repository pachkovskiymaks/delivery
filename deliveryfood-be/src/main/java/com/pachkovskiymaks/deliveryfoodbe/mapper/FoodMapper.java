package com.pachkovskiymaks.deliveryfoodbe.mapper;

import com.pachkovskiymaks.deliveryfoodbe.model.FoodDto;
import com.pachkovskiymaks.deliveryfoodbe.model.FoodEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodMapper {


    public FoodDto mapEntityToDto(FoodEntity food) {
        return FoodDto.builder()
                .id(food.getId())
                .name(food.getName())
                .price(food.getPrice())
                .image(food.getImage())
                .build();
    }
    public FoodEntity mapDtoToEntity(FoodDto food) {
        return FoodEntity.builder()
                .id(food.getId())
                .name(food.getName())
                .price(food.getPrice())
                .image(food.getImage())
                .build();
    }

    public List<FoodDto> mapEntityToDto(List<FoodEntity> foods) {
        return foods.stream().map(this::mapEntityToDto).collect(Collectors.toList());
    }

    public List<FoodEntity> mapDtoToEntity(List<FoodDto> foods) {
        return foods.stream().map(this::mapDtoToEntity).collect(Collectors.toList());
    }
}
