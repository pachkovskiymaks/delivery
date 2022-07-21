package com.pachkovskiymaks.deliveryfoodbe.repository;

import com.pachkovskiymaks.deliveryfoodbe.model.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
}
