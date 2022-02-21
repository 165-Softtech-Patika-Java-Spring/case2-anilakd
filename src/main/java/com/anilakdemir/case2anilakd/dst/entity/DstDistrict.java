package com.anilakdemir.case2anilakd.dst.entity;

import com.anilakdemir.case2anilakd.cty.entity.CtyCity;
import com.anilakdemir.case2anilakd.nhb.entity.NhbNeighborhood;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anilakdemir
 */
@Entity
@Table(name = "DST_DISTRICT")
@Data
public class DstDistrict {

    @Id
    @SequenceGenerator(name = "DST_DISTRICT", sequenceName = "DST_DISTRICT_SEQ")
    @GeneratedValue(generator = "DST_DISTRICT")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CTY_CITY_ID")
    private CtyCity city;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "district")
    @JsonManagedReference
    private List<NhbNeighborhood> neighborhoods = new ArrayList<>();

}
