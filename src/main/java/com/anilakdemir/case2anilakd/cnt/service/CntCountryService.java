package com.anilakdemir.case2anilakd.cnt.service;

import com.anilakdemir.case2anilakd.cnt.converter.CntCountryMapper;
import com.anilakdemir.case2anilakd.cnt.dto.CntCountryDto;
import com.anilakdemir.case2anilakd.cnt.dto.CntCountrySaveRequestDto;
import com.anilakdemir.case2anilakd.cnt.entity.CntCountry;
import com.anilakdemir.case2anilakd.cnt.service.entityService.CntCountryEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author anilakdemir
 */
@Service
@RequiredArgsConstructor
public class CntCountryService {

    private final CntCountryEntityService cntCountryEntityService;

    /**
     * this function is to save CntCountry Entity
     * after saving it converts the entity to Dto Object
     */
    public CntCountryDto save(CntCountrySaveRequestDto cntCountrySaveRequestDto){
        CntCountry cntCountry = CntCountryMapper.INSTANCE.convertToCntCountry(cntCountrySaveRequestDto);
        cntCountry = cntCountryEntityService.save(cntCountry);
        CntCountryDto cntCountryDto = CntCountryMapper.INSTANCE.convertToCntCountryDto(cntCountry);
        return cntCountryDto;
    }

    /**
     * this function is to find CntCountry Entity by country code (ex : TR, EN)
     * and converts to Dto Object
     */
    public CntCountryDto findByCode(String code){
        CntCountry cntCountry = cntCountryEntityService.findByCode(code);
        CntCountryDto cntCountryDto = CntCountryMapper.INSTANCE.convertToCntCountryDto(cntCountry);
        return cntCountryDto;
    }
}
