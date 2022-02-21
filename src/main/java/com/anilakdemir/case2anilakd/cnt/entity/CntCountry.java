package com.anilakdemir.case2anilakd.cnt.entity;

import com.anilakdemir.case2anilakd.cty.entity.CtyCity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anilakdemir
 */

@Entity
@Table(name = "CNT_COUNTRY")
@Data
public class CntCountry {

    @Id
    @SequenceGenerator(name = "CntCountry", sequenceName = "CNT_COUNTRY_SEQ")
    @GeneratedValue(generator = "CntCountry")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "CODE", length = 10, nullable = false)
    private String code;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "country")
    private List<CtyCity> cities = new ArrayList<>();
    
}
