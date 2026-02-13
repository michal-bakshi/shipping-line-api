package com.shipping.freightops.dto;

import com.shipping.freightops.entity.Vessel;

public class VesselResponse {
  private String name;
  private String imoNumber;
  private int capacityTeu;

  public static VesselResponse fromEntity(Vessel vessel) {
    VesselResponse dto = new VesselResponse();
    dto.name = vessel.getName();
    dto.capacityTeu = vessel.getCapacityTeu();
    dto.imoNumber = vessel.getImoNumber();
    return dto;
  }

  public String getName() {
    return name;
  }

  public String getImoNumber() {
    return imoNumber;
  }

  public int getCapacityTeu() {
    return capacityTeu;
  }
}
