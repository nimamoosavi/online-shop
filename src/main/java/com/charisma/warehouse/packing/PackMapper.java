package com.charisma.warehouse.packing;

import com.charisma.common.mapper.Mapper;
import com.charisma.warehouse.packing.web.PackDTO;

@org.mapstruct.Mapper
public abstract class PackMapper extends Mapper<Pack, com.charisma.warehouse.packing.entities.Pack> {

    public abstract PackDTO mapToPackDTO(Pack pack);
}
