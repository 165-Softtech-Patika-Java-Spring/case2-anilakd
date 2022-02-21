package com.anilakdemir.case2anilakd.adr.dto;

import lombok.Data;

import javax.persistence.Column;

/**
 * @author anilakdemir
 */
@Data
public class AdrAddressDto {


    private Long id;
    private Long countryId;
    private Long cityId;
    private Long districtId;
    private Long neighborhoodId;
    private Long streetId;
    private int doorNumber;
    private int apartmentNumber;
}
