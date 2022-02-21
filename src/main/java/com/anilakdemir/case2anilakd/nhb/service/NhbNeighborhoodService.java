package com.anilakdemir.case2anilakd.nhb.service;

import com.anilakdemir.case2anilakd.dst.entity.DstDistrict;
import com.anilakdemir.case2anilakd.dst.service.entityService.DstDistrictEntityService;
import com.anilakdemir.case2anilakd.gen.exceptions.ItemNotFoundException;
import com.anilakdemir.case2anilakd.nhb.converter.NhbNeighborhoodMapper;
import com.anilakdemir.case2anilakd.nhb.dto.NhbNeighborhoodDto;
import com.anilakdemir.case2anilakd.nhb.dto.NhbNeighborhoodSaveRequest;
import com.anilakdemir.case2anilakd.nhb.dto.NhbNeighborhoodUpdateNameRequestDto;
import com.anilakdemir.case2anilakd.nhb.entity.NhbNeighborhood;
import com.anilakdemir.case2anilakd.nhb.service.entityService.NhbNeighborhoodEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author anilakdemir
 */
@Service
@RequiredArgsConstructor
public class NhbNeighborhoodService {

    private final NhbNeighborhoodEntityService nhbNeighborhoodEntityService;
    private final DstDistrictEntityService dstDistrictEntityService;

    /**
     * if request has valid parameter for districtId
     * this function gets the district object from dstDistrictEntityService
     * and sets it to neighborhood object
     * saves the neighborhood and convert the Dto Object
     */
    public NhbNeighborhoodDto save(NhbNeighborhoodSaveRequest nhbNeighborhoodSaveRequest){
        NhbNeighborhood nhbNeighborhood = NhbNeighborhoodMapper.INSTANCE.convertToNhbNeighborhood(nhbNeighborhoodSaveRequest);
        Long districtId = nhbNeighborhoodSaveRequest.getDistrictId();
        if(controlDistrictIsExists(districtId)){
            DstDistrict dstDistrict = dstDistrictEntityService.findById(districtId);
            nhbNeighborhood.setDistrict(dstDistrict);
            nhbNeighborhood = nhbNeighborhoodEntityService.save(nhbNeighborhood);
            NhbNeighborhoodDto nhbNeighborhoodDto = NhbNeighborhoodMapper.INSTANCE.convertToNhbNeighborhoodDto(nhbNeighborhood);
            return  nhbNeighborhoodDto;
        }else{
            throw new ItemNotFoundException("District can not found");
        }
    }


    /**
     * if the request parameter has valid id
     * it sets the name field according to request
     * then saves it, and convert to Dto Object
     */
    public NhbNeighborhoodDto updateNeighborhoodName(NhbNeighborhoodUpdateNameRequestDto nhbNeighborhoodUpdateNameRequestDto){
        Long neighboorhoodId = nhbNeighborhoodUpdateNameRequestDto.getId();
        NhbNeighborhood nhbNeighborhood = nhbNeighborhoodEntityService.findById(neighboorhoodId);
        nhbNeighborhood.setName(nhbNeighborhoodUpdateNameRequestDto.getName());
        nhbNeighborhood = nhbNeighborhoodEntityService.save(nhbNeighborhood);
        NhbNeighborhoodDto nhbNeighborhoodDto = NhbNeighborhoodMapper.INSTANCE.convertToNhbNeighborhoodDto(nhbNeighborhood);
        return nhbNeighborhoodDto;
    }

    /**
     * it gets all neighborhood object from DAO as a List
     * and converts it List<Object> to List<ObjectDto>
     */
    public List<NhbNeighborhoodDto> findAllByDistrictId(Long districtId){
        List<NhbNeighborhood> neighborhoodList = nhbNeighborhoodEntityService.findAllByDistrictId(districtId);
        List<NhbNeighborhoodDto> neighborhoodDtoList = NhbNeighborhoodMapper.INSTANCE.convertToNhbNeighborhoodDtoList(neighborhoodList);
        return neighborhoodDtoList;
    }


    /**
     * this function is to check if there is a district object whose parameter is districtId
     * if the district exists, it returns true
     */
    private boolean controlDistrictIsExists(Long districtId){
        return dstDistrictEntityService.existById(districtId);
    }
}
