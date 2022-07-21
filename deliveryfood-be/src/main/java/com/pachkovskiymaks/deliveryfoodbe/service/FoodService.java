package com.pachkovskiymaks.deliveryfoodbe.service;

import com.pachkovskiymaks.deliveryfoodbe.mapper.FoodMapper;
import com.pachkovskiymaks.deliveryfoodbe.model.FoodDto;
import com.pachkovskiymaks.deliveryfoodbe.model.FoodEntity;
import com.pachkovskiymaks.deliveryfoodbe.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;


    @Transactional
    public FoodDto create(FoodDto foodDto) {
        FoodEntity foodEntity = foodMapper.mapDtoToEntity(foodDto);
        foodRepository.save(foodEntity);
        return foodMapper.mapEntityToDto(foodEntity);
    }

    public FoodDto getById(Long id) {
        return foodRepository.findById(id).map(foodMapper::mapEntityToDto).orElse(null);
    }

    public List<FoodDto> getAll() {
        return foodMapper.mapEntityToDto(foodRepository.findAll());
    }

    public void delete(Long id) {
        foodRepository.findById(id).ifPresent(foodRepository::delete);
    }
}
