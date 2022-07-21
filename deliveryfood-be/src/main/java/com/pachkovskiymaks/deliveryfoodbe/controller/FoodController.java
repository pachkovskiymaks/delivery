package com.pachkovskiymaks.deliveryfoodbe.controller;

import com.pachkovskiymaks.deliveryfoodbe.model.FoodDto;
import com.pachkovskiymaks.deliveryfoodbe.model.FoodEntity;
import com.pachkovskiymaks.deliveryfoodbe.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @PostMapping
    public FoodDto create(@RequestBody FoodDto foodDto) {
        return foodService.create(foodDto);
    }

    @GetMapping("/{id}")
    public FoodDto getById(@PathVariable Long id) {
        return foodService.getById(id);
    }

    @GetMapping
    public List<FoodDto> getAll() {
        return foodService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        foodService.delete(id);
    }

}
