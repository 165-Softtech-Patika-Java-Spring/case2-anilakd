package com.anilakdemir.case2anilakd.dst.service;

import com.anilakdemir.case2anilakd.cty.entity.CtyCity;
import com.anilakdemir.case2anilakd.cty.service.entityService.CtyCityEntityService;
import com.anilakdemir.case2anilakd.dst.converter.DstDistrictMapper;
import com.anilakdemir.case2anilakd.dst.dto.DstDistrictDto;
import com.anilakdemir.case2anilakd.dst.dto.DstDistrictSaveRequestDto;
import com.anilakdemir.case2anilakd.dst.entity.DstDistrict;
import com.anilakdemir.case2anilakd.dst.service.entityService.DstDistrictEntityService;
import com.anilakdemir.case2anilakd.gen.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author anilakdemir
 */
@Service
@RequiredArgsConstructor
public class DstDistrictService {

    private final DstDistrictEntityService dstDistrictEntityService;
    private final CtyCityEntityService ctyCityEntityService;

    /**
     * if request has valid parameter for cityId
     * this function gets the city object from ctyCityService
     * and sets it to district object
     * saves the district and convert the Dto Object
     */
    public DstDistrictDto save(DstDistrictSaveRequestDto dstDistrictSaveRequestDto){
        DstDistrict dstDistrict = DstDistrictMapper.INSTANCE.convertToDstDistrict(dstDistrictSaveRequestDto);
        Long cityId = dstDistrictSaveRequestDto.getCityId();
        if(controlCtyCityIsExist(cityId)){
            CtyCity ctyCity = ctyCityEntityService.findCityById(cityId);
            dstDistrict.setCity(ctyCity);
            dstDistrict = dstDistrictEntityService.save(dstDistrict);
            DstDistrictDto dstDistrictDto = DstDistrictMapper.INSTANCE.convertToDstDistrictDto(dstDistrict);
            return dstDistrictDto;
        }else{
            throw new ItemNotFoundException("District can not save because City can not found");
        }
    }

    /**
     * it gets all district object from DAO as a List
     * if size of list greater than zero it converts List<Object> to List<ObjectDto>
     * if not it returns empty list
     */
    public List<DstDistrictDto> findAllByCityId(Long cityId){
        List<DstDistrict> districtList = dstDistrictEntityService.findAllByCityId(cityId);
        if(districtList.size()>0){
            List<DstDistrictDto> dstDistrictDtoList = DstDistrictMapper.INSTANCE.convertToDstDistrictList(districtList);
            return dstDistrictDtoList;
        }else{
            return Collections.emptyList();
        }
    }

    /**
     * this function is to check if there is a city object whose parameter is id
     * if the city exists return true
     */
    private boolean controlCtyCityIsExist(Long id){
        return ctyCityEntityService.existById(id);
    }
}
