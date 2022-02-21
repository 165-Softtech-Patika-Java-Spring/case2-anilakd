package com.anilakdemir.case2anilakd.cty.dto;

import lombok.Data;

/**
 * @author anilakdemir
 */
@Data
public class CtyCitySaveRequestDto {

    private String name;
    private String plateCode;
    private Long countryId;
}
