package com.shipping.freightops.dto;

import com.shipping.freightops.entity.Container;
import com.shipping.freightops.enums.ContainerSize;
import com.shipping.freightops.enums.ContainerType;
import java.time.LocalDateTime;

/** Read-only view of a container returned by the API. */
public class ContainerResponse {

  private Long id;
  private String containerCode;
  private ContainerSize size;
  private ContainerType type;
  private int teu;
  private LocalDateTime createdAt;

  /** Factory method to map entity → response DTO. */
  public static ContainerResponse fromEntity(Container container) {
    ContainerResponse dto = new ContainerResponse();
    dto.id = container.getId();
    dto.containerCode = container.getContainerCode();
    dto.size = container.getSize();
    dto.type = container.getType();
    dto.teu = container.getTeu();
    dto.createdAt = container.getCreatedAt();
    return dto;
  }

  public Long getId() {
    return id;
  }

  public String getContainerCode() {
    return containerCode;
  }

  public ContainerSize getSize() {
    return size;
  }

  public ContainerType getType() {
    return type;
  }

  public int getTeu() {
    return teu;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
}
