package com.anilakdemir.case2anilakd.cty.entity;

import com.anilakdemir.case2anilakd.cnt.entity.CntCountry;
import com.anilakdemir.case2anilakd.dst.entity.DstDistrict;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anilakdemir
 */

@Entity
@Table(name = "CTY_CITY")
@Data
public class CtyCity {

    @Id
    @SequenceGenerator(name = "CtyCity", sequenceName = "CTY_CITY_SEQ")
    @GeneratedValue(generator = "CtyCity")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "PLATE_CODE", length = 50, nullable = false)
    private String plateCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CNT_COUNTRY_ID")
    private CntCountry country;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "city")
    private List<DstDistrict> districtList = new ArrayList<>();
}
