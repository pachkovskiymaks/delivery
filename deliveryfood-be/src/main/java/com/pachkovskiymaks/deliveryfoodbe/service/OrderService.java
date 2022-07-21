package com.pachkovskiymaks.deliveryfoodbe.service;


import com.pachkovskiymaks.deliveryfoodbe.mapper.OrderMapper;
import com.pachkovskiymaks.deliveryfoodbe.model.OrderDto;
import com.pachkovskiymaks.deliveryfoodbe.model.OrderEntity;
import com.pachkovskiymaks.deliveryfoodbe.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;


    @Transactional
    public OrderDto create(OrderDto orderDto) {
        OrderEntity orderEntity = orderMapper.mapDtoToEntity(orderDto);
        orderRepository.save(orderEntity);
        return orderMapper.mapEntityToDto(orderEntity);
    }

    public OrderDto getById(Long id) {
        return orderRepository.findById(id).map(orderMapper::mapEntityToDto).orElse(null);
    }

    public List<OrderDto> getAll() {
        return orderMapper.mapDtoToEntity(orderRepository.findAll());
    }

    public void delete(Long id) {
        orderRepository.findById(id).ifPresent(orderRepository::delete);
    }
}
