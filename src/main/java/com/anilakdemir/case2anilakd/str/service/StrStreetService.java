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


    public StrStreetDto save(StrStreetSaveRequestDto strStreetSaveRequestDto){
        StrStreet strStreet = StrStreetMapper.INSTANCE.convertToStrStreet(strStreetSaveRequestDto);
        Long neighborhoodId = strStreetSaveRequestDto.getNeighborhoodId();
        if(controlNeighborhoodtIsExist(neighborhoodId)){
            NhbNeighborhood nhbNeighborhood = nhbNeighborhoodEntityService.findById(neighborhoodId);
            strStreet.setNeighborhood(nhbNeighborhood);
            strStreet = strStreetEntityService.save(strStreet);
            StrStreetDto strStreetDto = StrStreetMapper.INSTANCE.convertToStrStreetDto(strStreet);
            return strStreetDto;
        }else{
            throw new ItemNotFoundException("District can not found");
        }
    }

    public StrStreetDto updateStrStreetName(StrStreetUpdateNameRequestDto strStreetUpdateNameRequestDto){
        Long strStreetId = strStreetUpdateNameRequestDto.getId();
        StrStreet strStreet = strStreetEntityService.findById(strStreetId);
        strStreet.setName(strStreetUpdateNameRequestDto.getName());
        strStreet = strStreetEntityService.save(strStreet);
        StrStreetDto strStreetDto = StrStreetMapper.INSTANCE.convertToStrStreetDto(strStreet);
        return strStreetDto;
    }

    public List<StrStreetDto> findAllByNeighborhoodId(Long neighborhoodId){
        List<StrStreet> strStreetList = strStreetEntityService.findAllByNeighborhoodId(neighborhoodId);
        List<StrStreetDto> strStreetDtoList = StrStreetMapper.INSTANCE.convertToStrStreetDtoList(strStreetList);
        return strStreetDtoList;
    }

    private boolean controlNeighborhoodtIsExist(Long neighborhoodId){
        return nhbNeighborhoodEntityService.existById(neighborhoodId);
    }
}
