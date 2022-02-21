package com.anilakdemir.case2anilakd.adr.service;

import com.anilakdemir.case2anilakd.adr.converter.AdrAddressMapper;
import com.anilakdemir.case2anilakd.adr.dto.AdrAddressDto;
import com.anilakdemir.case2anilakd.adr.dto.AdrAddressSaveRequestDto;
import com.anilakdemir.case2anilakd.adr.entity.AdrAddress;
import com.anilakdemir.case2anilakd.adr.service.entityService.AdrAddressEntityService;
import com.anilakdemir.case2anilakd.cnt.service.entityService.CntCountryEntityService;
import com.anilakdemir.case2anilakd.cty.service.entityService.CtyCityEntityService;
import com.anilakdemir.case2anilakd.dst.service.entityService.DstDistrictEntityService;
import com.anilakdemir.case2anilakd.gen.exceptions.BadRequestException;
import com.anilakdemir.case2anilakd.nhb.service.entityService.NhbNeighborhoodEntityService;
import com.anilakdemir.case2anilakd.str.entity.StrStreet;
import com.anilakdemir.case2anilakd.str.service.entityService.StrStreetEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author anilakdemir
 */
@Service
@RequiredArgsConstructor
public class AdrAddressService {

    private final AdrAddressEntityService adrAddressEntityService;
    private final StrStreetEntityService strStreetEntityService;

    public AdrAddressDto save(AdrAddressSaveRequestDto adrAddressSaveRequestDto){

        boolean isValidRequest = validateAdrAddressSaveRequestDto(adrAddressSaveRequestDto);

        if(isValidRequest){
            AdrAddress adrAddress = AdrAddressMapper.INSTANCE.convertToAddAddress(adrAddressSaveRequestDto);
            adrAddress = adrAddressEntityService.save(adrAddress);
            AdrAddressDto adrAddressDto = AdrAddressMapper.INSTANCE.convertToAdrAddressDto(adrAddress);
            return  adrAddressDto;
        }else{
            throw new BadRequestException("Address can not save");
        }
    }

    public void deleteAdrAddressById (Long addressId) {
        adrAddressEntityService.deleteAdrAddressById(addressId);
    }

    public AdrAddressDto findById(Long id){
        AdrAddress adrAddress = adrAddressEntityService.findById(id);
        AdrAddressDto adrAddressDto = AdrAddressMapper.INSTANCE.convertToAdrAddressDto(adrAddress);
        return adrAddressDto;
    }

    private boolean validateAdrAddressSaveRequestDto (AdrAddressSaveRequestDto adrAddressSaveRequestDto) {
        Long countryId = adrAddressSaveRequestDto.getCountryId();
        Long cityId = adrAddressSaveRequestDto.getCityId();
        Long districtId = adrAddressSaveRequestDto.getDistrictId();
        Long neighborhoodId = adrAddressSaveRequestDto.getNeighborhoodId();
        Long streetId = adrAddressSaveRequestDto.getStreetId();

        boolean isValidStrStreet = controlStrStreet(streetId);
        if(isValidStrStreet){
            StrStreet strStreet = strStreetEntityService.findById(streetId);
            boolean isValidNeighborhood  = Objects.equals(neighborhoodId, strStreet.getNeighborhood().getId());
            boolean isValidDistrict = Objects.equals(districtId, strStreet.getNeighborhood().getDistrict().getId());
            boolean isValidCity = Objects.equals(cityId, strStreet.getNeighborhood().getDistrict().getCity().getId());
            boolean isValidCountry = Objects.equals(countryId, strStreet.getNeighborhood().getDistrict().getCity().getId());
            List<Boolean> validatonList = new ArrayList<>();
            validatonList.add(isValidNeighborhood);
            validatonList.add(isValidDistrict);
            validatonList.add(isValidCity);
            validatonList.add(isValidCountry);
            return checkAllListElementsTrue(validatonList);
        }else{
            return false;
        }

    }

    private boolean controlStrStreet (Long streetId) {
        return strStreetEntityService.existById(streetId);
    }

    private boolean checkAllListElementsTrue (List<Boolean> booleanList){
        boolean isValidList = true;
        for (Boolean element : booleanList){
            if (element == false){
                isValidList = false;
            }
        }
        return isValidList;
    }
}
