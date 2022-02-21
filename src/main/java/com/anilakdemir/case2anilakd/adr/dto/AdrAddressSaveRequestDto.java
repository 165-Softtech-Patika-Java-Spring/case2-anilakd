package com.anilakdemir.case2anilakd.adr.dto;

import lombok.Data;

/**
 * @author anilakdemir
 */
@Data
public class AdrAddressSaveRequestDto {

    private Long countryId;
    private Long cityId;
    private Long districtId;
    private Long neighborhoodId;
    private Long streetId;
    private int doorNumber;
    private int apartmentNumber;
}
