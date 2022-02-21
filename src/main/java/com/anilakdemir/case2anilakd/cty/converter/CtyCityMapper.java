package com.anilakdemir.case2anilakd.cty.converter;

import com.anilakdemir.case2anilakd.cty.dto.CtyCityDto;
import com.anilakdemir.case2anilakd.cty.dto.CtyCitySaveRequestDto;
import com.anilakdemir.case2anilakd.cty.entity.CtyCity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author anilakdemir
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CtyCityMapper {

    CtyCityMapper INSTANCE = Mappers.getMapper(CtyCityMapper.class);

    CtyCity convertToCtyCity(CtyCitySaveRequestDto ctyCitySaveRequestDto);

    CtyCityDto convertToCtyCityDto(CtyCity ctyCity);
}
