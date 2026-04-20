package com.shipping.freightops.repository;

import com.shipping.freightops.entity.Container;
import com.shipping.freightops.enums.ContainerSize;
import com.shipping.freightops.enums.ContainerType;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContainerRepository extends JpaRepository<Container, Long> {

  Optional<Container> findByContainerCode(String containerCode);

  boolean existsByContainerCode(String containerCode);

  List<Container> findBySize(ContainerSize size);

  List<Container> findByType(ContainerType type);

  List<Container> findBySizeAndType(ContainerSize size, ContainerType type);
}
