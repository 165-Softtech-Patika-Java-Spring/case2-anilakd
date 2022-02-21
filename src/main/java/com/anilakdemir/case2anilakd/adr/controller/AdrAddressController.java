package com.anilakdemir.case2anilakd.adr.controller;

import com.anilakdemir.case2anilakd.adr.dto.AdrAddressDto;
import com.anilakdemir.case2anilakd.adr.dto.AdrAddressSaveRequestDto;
import com.anilakdemir.case2anilakd.adr.service.AdrAddressService;
import com.anilakdemir.case2anilakd.cnt.dto.CntCountryDto;
import com.anilakdemir.case2anilakd.cnt.dto.CntCountrySaveRequestDto;
import com.anilakdemir.case2anilakd.cnt.service.CntCountryService;
import com.anilakdemir.case2anilakd.cty.dto.CtyCityDto;
import com.anilakdemir.case2anilakd.cty.dto.CtyCitySaveRequestDto;
import com.anilakdemir.case2anilakd.cty.service.CtyCityService;
import com.anilakdemir.case2anilakd.dst.dto.DstDistrictDto;
import com.anilakdemir.case2anilakd.dst.dto.DstDistrictSaveRequestDto;
import com.anilakdemir.case2anilakd.dst.service.DstDistrictService;
import com.anilakdemir.case2anilakd.nhb.dto.NhbNeighborhoodDto;
import com.anilakdemir.case2anilakd.nhb.dto.NhbNeighborhoodSaveRequest;
import com.anilakdemir.case2anilakd.nhb.dto.NhbNeighborhoodUpdateNameRequestDto;
import com.anilakdemir.case2anilakd.nhb.service.NhbNeighborhoodService;
import com.anilakdemir.case2anilakd.str.dto.StrStreetDto;
import com.anilakdemir.case2anilakd.str.dto.StrStreetSaveRequestDto;
import com.anilakdemir.case2anilakd.str.dto.StrStreetUpdateNameRequestDto;
import com.anilakdemir.case2anilakd.str.service.StrStreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author anilakdemir
 */
@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class AdrAddressController {
    private final CntCountryService cntCountryService;
    private final CtyCityService ctyCityService;
    private final DstDistrictService dstDistrictService;
    private final NhbNeighborhoodService nhbNeighborhoodService;
    private final StrStreetService strStreetService;
    private final AdrAddressService adrAddressService;

    @PostMapping("/country")
    public ResponseEntity saveCountry(@RequestBody CntCountrySaveRequestDto cntCountrySaveRequestDto){
        CntCountryDto cntCountryDto = cntCountryService.save(cntCountrySaveRequestDto);
        return ResponseEntity.ok(cntCountryDto);
    }

    @GetMapping("/country/{code}")
    public ResponseEntity findCountryByCode(@PathVariable String code){
        CntCountryDto cntCountryDto = cntCountryService.findByCode(code);
        return ResponseEntity.ok(cntCountryDto);
    }

    @PostMapping("/city")
    public ResponseEntity saveCity(@RequestBody CtyCitySaveRequestDto ctyCitySaveRequestDto){
        CtyCityDto ctyCityDto = ctyCityService.save(ctyCitySaveRequestDto);
        return ResponseEntity.ok(ctyCityDto);
    }

    @GetMapping("/city/{countryCode}/{plateCode}")
    public ResponseEntity findCityByPlateCodeAndCountryCode (@PathVariable String plateCode, @PathVariable String countryCode){
        CtyCityDto ctyCityDto = ctyCityService.findCityByPlateCodeAndCountryCode(plateCode, countryCode);
        return ResponseEntity.ok(ctyCityDto);
    }

    @PostMapping("/district")
    public ResponseEntity saveDistrict(@RequestBody DstDistrictSaveRequestDto dstDistrictSaveRequestDto){
        DstDistrictDto dstDistrictDto = dstDistrictService.save(dstDistrictSaveRequestDto);
        return ResponseEntity.ok(dstDistrictDto);
    }

    @GetMapping("/district/{cityId}")
    public ResponseEntity getAllDistrictByCityId(@PathVariable Long cityId){
        List<DstDistrictDto> dstDistrictDtoList = dstDistrictService.findAllByCityId(cityId);
        return ResponseEntity.ok(dstDistrictDtoList);
    }

    @PostMapping("/neighborhood")
    public ResponseEntity saveNeighborhood(@RequestBody NhbNeighborhoodSaveRequest nhbNeighborhoodSaveRequest){
        NhbNeighborhoodDto nhbNeighborhoodDto = nhbNeighborhoodService.save(nhbNeighborhoodSaveRequest);
        return ResponseEntity.ok(nhbNeighborhoodDto);
    }

    @PutMapping("/neighborhood")
    public ResponseEntity updateNeighborhoodName(@RequestBody NhbNeighborhoodUpdateNameRequestDto nhbNeighborhoodUpdateNameRequestDto){
        return ResponseEntity.ok(nhbNeighborhoodService.updateNeighborhoodName(nhbNeighborhoodUpdateNameRequestDto));
    }

    @GetMapping("/neighborhood/{districtId}")
    public ResponseEntity getAllNeighborhoodByDistrictId(@PathVariable Long districtId){
        List<NhbNeighborhoodDto> neighborhoodDtoList = nhbNeighborhoodService.findAllByDistrictId(districtId);
        return ResponseEntity.ok(neighborhoodDtoList);
    }


    @PostMapping("/street")
    public ResponseEntity saveStreet(@RequestBody StrStreetSaveRequestDto strStreetSaveRequestDto){
        StrStreetDto strStreetDto = strStreetService.save(strStreetSaveRequestDto);
        return ResponseEntity.ok(strStreetDto);
    }

    @PutMapping("/street")
    public ResponseEntity updateStreetName(@RequestBody StrStreetUpdateNameRequestDto strStreetUpdateNameRequestDto){
        StrStreetDto strStreetDto = strStreetService.updateStrStreetName(strStreetUpdateNameRequestDto);
        return ResponseEntity.ok(strStreetDto);
    }

    @GetMapping("/street/{neighborhoodId}")
    public ResponseEntity getAllStreetByNeighborhoodId(@PathVariable Long neighborhoodId){
        List<StrStreetDto> strStreetDtoList = strStreetService.findAllByNeighborhoodId(neighborhoodId);
        return ResponseEntity.ok(strStreetDtoList);
    }

    @PostMapping("/address")
    public ResponseEntity saveAddress(@RequestBody AdrAddressSaveRequestDto adrAddressSaveRequestDto){
        AdrAddressDto adrAddressDto = adrAddressService.save(adrAddressSaveRequestDto);
        return ResponseEntity.ok(adrAddressDto);
    }

    @DeleteMapping("/address/{addressId}")
    public ResponseEntity deleteAddress(@PathVariable Long addressId){
        adrAddressService.deleteAdrAddressById(addressId);
        return ResponseEntity.ok(Void.TYPE);
    }

    @GetMapping("/address/{addressId}")
    public ResponseEntity findAddressById(@PathVariable Long addressId){
        AdrAddressDto adrAddressDto = adrAddressService.findById(addressId);
        return ResponseEntity.ok(adrAddressDto);
    }

}