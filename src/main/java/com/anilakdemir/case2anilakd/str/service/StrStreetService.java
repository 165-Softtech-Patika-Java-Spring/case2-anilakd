package com.anilakdemir.case2anilakd.str.service;

import com.anilakdemir.case2anilakd.gen.exceptions.ItemNotFoundException;
import com.anilakdemir.case2anilakd.nhb.entity.NhbNeighborhood;
import com.anilakdemir.case2anilakd.nhb.service.entityService.NhbNeighborhoodEntityService;
import com.anilakdemir.case2anilakd.str.converter.StrStreetMapper;
import com.anilakdemir.case2anilakd.str.dto.StrStreetDto;
import com.anilakdemir.case2anilakd.str.dto.StrStreetSaveRequestDto;
import com.anilakdemir.case2anilakd.str.dto.StrStreetUpdateNameRequestDto;
import com.anilakdemir.case2anilakd.str.entity.StrStreet;
import com.anilakdemir.case2anilakd.str.service.entityService.StrStreetEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author anilakdemir
 */
@Service
@RequiredArgsConstructor
public class StrStreetService {

    private final StrStreetEntityService strStreetEntityService;
    private final NhbNeighborhoodEntityService nhbNeighborhoodEntityService;


    /**
     * if request has valid parameter for neighborhoodId
     * this function gets the nhbNeighborhood object from nhbNeighborhoodEntityService
     * and sets it to strStreet object
     * saves the strStreet and convert the Dto Object
     */
    public StrStreetDto save(StrStreetSaveRequestDto strStreetSaveRequestDto){
        StrStreet strStreet = StrStreetMapper.INSTANCE.convertToStrStreet(strStreetSaveRequestDto);
        Long neighborhoodId = strStreetSaveRequestDto.getNeighborhoodId();
        if(controlNeighborhoodIsExist(neighborhoodId)){
            NhbNeighborhood nhbNeighborhood = nhbNeighborhoodEntityService.findById(neighborhoodId);
            strStreet.setNeighborhood(nhbNeighborhood);
            strStreet = strStreetEntityService.save(strStreet);
            StrStreetDto strStreetDto = StrStreetMapper.INSTANCE.convertToStrStreetDto(strStreet);
            return strStreetDto;
        }else{
            throw new ItemNotFoundException("District can not found");
        }
    }

    /**
     * if the request parameter has valid id
     * it sets the name field according to request
     * then saves it, and convert to Dto Object
     */
    public StrStreetDto updateStrStreetName(StrStreetUpdateNameRequestDto strStreetUpdateNameRequestDto){
        Long strStreetId = strStreetUpdateNameRequestDto.getId();
        StrStreet strStreet = strStreetEntityService.findById(strStreetId);
        strStreet.setName(strStreetUpdateNameRequestDto.getName());
        strStreet = strStreetEntityService.save(strStreet);
        StrStreetDto strStreetDto = StrStreetMapper.INSTANCE.convertToStrStreetDto(strStreet);
        return strStreetDto;
    }

    /**
     * it gets all StrStreet objects which has neighborhood's id = neighborhoodId from DAO as a List
     * and converts it List<Object> to List<ObjectDto>
     */
    public List<StrStreetDto> findAllByNeighborhoodId(Long neighborhoodId){
        List<StrStreet> strStreetList = strStreetEntityService.findAllByNeighborhoodId(neighborhoodId);
        List<StrStreetDto> strStreetDtoList = StrStreetMapper.INSTANCE.convertToStrStreetDtoList(strStreetList);
        return strStreetDtoList;
    }


    /**
     * this function is to check if there is a neighborhood object whose parameter is neighborhoodId
     * if the neighborhood exists, it returns true
     */
    private boolean controlNeighborhoodIsExist (Long neighborhoodId){
        return nhbNeighborhoodEntityService.existById(neighborhoodId);
    }
}
