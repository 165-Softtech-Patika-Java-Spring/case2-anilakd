package com.anilakdemir.case2anilakd.str.converter;

import com.anilakdemir.case2anilakd.str.dto.StrStreetDto;
import com.anilakdemir.case2anilakd.str.dto.StrStreetSaveRequestDto;
import com.anilakdemir.case2anilakd.str.entity.StrStreet;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author anilakdemir
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StrStreetMapper {

    StrStreetMapper INSTANCE = Mappers.getMapper(StrStreetMapper.class);

    StrStreet convertToStrStreet (StrStreetSaveRequestDto strStreetSaveRequestDto);

    StrStreetDto convertToStrStreetDto(StrStreet strStreet);

    List<StrStreetDto> convertToStrStreetDtoList(List<StrStreet> strStreetList);
}
