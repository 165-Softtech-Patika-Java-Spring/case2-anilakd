package com.anilakdemir.case2anilakd.nhb.converter;

import com.anilakdemir.case2anilakd.nhb.dto.NhbNeighborhoodDto;
import com.anilakdemir.case2anilakd.nhb.dto.NhbNeighborhoodSaveRequest;
import com.anilakdemir.case2anilakd.nhb.entity.NhbNeighborhood;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author anilakdemir
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NhbNeighborhoodMapper {

    NhbNeighborhoodMapper INSTANCE = Mappers.getMapper(NhbNeighborhoodMapper.class);

    NhbNeighborhood convertToNhbNeighborhood(NhbNeighborhoodSaveRequest nhbNeighborhoodSaveRequest);

    NhbNeighborhoodDto convertToNhbNeighborhoodDto(NhbNeighborhood nhbNeighborhood);

    List<NhbNeighborhoodDto> convertToNhbNeighborhoodDtoList(List<NhbNeighborhood> neighborhoodList);
}
