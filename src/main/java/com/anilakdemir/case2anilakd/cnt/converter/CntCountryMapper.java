package com.anilakdemir.case2anilakd.cnt.converter;

import com.anilakdemir.case2anilakd.cnt.dto.CntCountryDto;
import com.anilakdemir.case2anilakd.cnt.dto.CntCountrySaveRequestDto;
import com.anilakdemir.case2anilakd.cnt.entity.CntCountry;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author anilakdemir
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CntCountryMapper {

    CntCountryMapper INSTANCE = Mappers.getMapper(CntCountryMapper.class);

    CntCountry convertToCntCountry(CntCountrySaveRequestDto cntCountrySaveRequestDto);

    CntCountryDto convertToCntCountryDto(CntCountry cntCountry);
}
