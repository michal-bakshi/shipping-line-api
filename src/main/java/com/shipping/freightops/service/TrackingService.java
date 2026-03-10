package com.shipping.freightops.service;

import com.shipping.freightops.dto.ContainerTrackingResponse;
import com.shipping.freightops.entity.Container;
import com.shipping.freightops.entity.FreightOrder;
import com.shipping.freightops.repository.ContainerRepository;
import com.shipping.freightops.repository.FreightOrderRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TrackingService {

  private final FreightOrderRepository orderRepository;
  private final ContainerRepository containerRepository;

  public TrackingService(
      FreightOrderRepository orderRepository, ContainerRepository containerRepository) {
    this.orderRepository = orderRepository;
    this.containerRepository = containerRepository;
  }

  @Transactional(readOnly = true)
  public FreightOrder trackOrder(Long orderId) {
    return orderRepository
        .findById(orderId)
        .orElseThrow(() -> new IllegalArgumentException("Order not found: " + orderId));
  }

  @Transactional(readOnly = true)
  public ContainerTrackingResponse trackContainer(String containerCode) {
    Container container =
        containerRepository
            .findByContainerCode(containerCode)
            .orElseThrow(
                () -> new IllegalArgumentException("Container not found: " + containerCode));

    List<FreightOrder> orders = orderRepository.findByContainerCode(containerCode);
    if (orders.isEmpty()) {
      return ContainerTrackingResponse.fromContainer(container);
    }
    return ContainerTrackingResponse.fromEntities(orders);
  }
}
