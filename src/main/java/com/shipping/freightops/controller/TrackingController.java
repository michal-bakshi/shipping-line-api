package com.shipping.freightops.controller;

import com.shipping.freightops.dto.ContainerTrackingResponse;
import com.shipping.freightops.dto.OrderTrackingResponse;
import com.shipping.freightops.entity.FreightOrder;
import com.shipping.freightops.service.TrackingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/track")
public class TrackingController {

  private TrackingService trackingService;

  public TrackingController(TrackingService trackingService) {
    this.trackingService = trackingService;
  }

  @GetMapping("/order/{orderId}")
  public ResponseEntity<OrderTrackingResponse> trackOrder(@PathVariable Long orderId) {
    FreightOrder order = trackingService.trackOrder(orderId);
    return ResponseEntity.ok(OrderTrackingResponse.fromEntity(order));
  }

  @GetMapping("/container/{containerCode}")
  public ResponseEntity<ContainerTrackingResponse> trackContainer(
      @PathVariable String containerCode) {
    return ResponseEntity.ok(trackingService.trackContainer(containerCode));
  }
}
