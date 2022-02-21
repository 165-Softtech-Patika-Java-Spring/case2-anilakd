package com.anilakdemir.case2anilakd.adr.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author anilakdemir
 */
@Entity
@Table(name = "ADR_ADDRESS")
@Data
public class AdrAddress {

    @Id
    @SequenceGenerator(name = "AdrAddress", sequenceName = "ADR_ADDRESS_ID_SEQ")
    @GeneratedValue(generator = "AdrAddress")
    private Long id;

    @Column(name = "ID_CNT_COUNTRY", nullable = false)
    private Long countryId;

    @Column(name = "ID_CTY_CITY", nullable = false)
    private Long cityId;

    @Column(name = "ID_DST_DISTRICT", nullable = false)
    private Long districtId;

    @Column(name = "ID_NHB_NEIGHBORHOOD", nullable = false)
    private Long neighborhoodId;

    @Column(name = "ID_STR_STREET", nullable = false)
    private Long streetId;

    @Column(name = "DOOR_NUMBER", nullable = false)
    private int doorNumber;

    @Column(name = "APARTMENT_NUMBER", nullable = false)
    private int apartmentNumber;

}
