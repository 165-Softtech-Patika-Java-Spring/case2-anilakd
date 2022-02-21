package com.anilakdemir.case2anilakd.adr.converter;

import com.anilakdemir.case2anilakd.adr.dto.AdrAddressDto;
import com.anilakdemir.case2anilakd.adr.dto.AdrAddressSaveRequestDto;
import com.anilakdemir.case2anilakd.adr.entity.AdrAddress;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author anilakdemir
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdrAddressMapper {

    AdrAddressMapper INSTANCE = Mappers.getMapper(AdrAddressMapper.class);

    AdrAddress convertToAddAddress(AdrAddressSaveRequestDto adrAddressSaveRequestDto);

    AdrAddressDto convertToAdrAddressDto(AdrAddress adrAddress);
}
