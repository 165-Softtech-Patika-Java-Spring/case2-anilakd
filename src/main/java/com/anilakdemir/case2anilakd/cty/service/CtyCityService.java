package com.anilakdemir.case2anilakd.cty.service;

import com.anilakdemir.case2anilakd.cnt.entity.CntCountry;
import com.anilakdemir.case2anilakd.cnt.service.entityService.CntCountryEntityService;
import com.anilakdemir.case2anilakd.cty.converter.CtyCityMapper;
import com.anilakdemir.case2anilakd.cty.dto.CtyCityDto;
import com.anilakdemir.case2anilakd.cty.dto.CtyCitySaveRequestDto;
import com.anilakdemir.case2anilakd.cty.entity.CtyCity;
import com.anilakdemir.case2anilakd.cty.service.entityService.CtyCityEntityService;
import com.anilakdemir.case2anilakd.gen.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author anilakdemir
 */
@Service
@RequiredArgsConstructor
public class CtyCityService {

    private final CtyCityEntityService ctyCityEntityService;
    private final CntCountryEntityService cntCountryEntityService;

    public CtyCityDto save(CtyCitySaveRequestDto ctyCitySaveRequestDto){
        CtyCity ctyCity = CtyCityMapper.INSTANCE.convertToCtyCity(ctyCitySaveRequestDto);
        Long cntCountryId = ctyCitySaveRequestDto.getCountryId();
        if(controlCntCountryIsExist(cntCountryId)){
            CntCountry cntCountry = cntCountryEntityService.findById(cntCountryId);
            ctyCity.setCountry(cntCountry);
            ctyCity = ctyCityEntityService.save(ctyCity);
            CtyCityDto ctyCityDto = CtyCityMapper.INSTANCE.convertToCtyCityDto(ctyCity);
            return ctyCityDto;
        }else{
            throw new ItemNotFoundException("City can not save because Country can not found");
        }
    }

    public CtyCityDto findCityByPlateCode (String plateCode, String countryCode){
        CtyCity ctyCity = ctyCityEntityService.findCityByPlateCode(plateCode, countryCode);
        CtyCityDto ctyCityDto = CtyCityMapper.INSTANCE.convertToCtyCityDto(ctyCity);
        return ctyCityDto;
    }

    private boolean controlCntCountryIsExist(Long cntCountryId){
        return cntCountryEntityService.existById(cntCountryId);
    }
}
