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

    public List<DstDistrictDto> findAllByCityId(Long cityId){
        List<DstDistrict> districtList = dstDistrictEntityService.findAllByCityId(cityId);
        if(districtList.size()>0){
            List<DstDistrictDto> dstDistrictDtoList = DstDistrictMapper.INSTANCE.convertToDstDistrictList(districtList);
            return dstDistrictDtoList;
        }else{
            return Collections.emptyList();
        }
    }

    private boolean controlCtyCityIsExist(Long id){
        return ctyCityEntityService.existById(id);
    }
}
