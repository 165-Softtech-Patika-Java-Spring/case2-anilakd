package com.anilakdemir.case2anilakd.nhb.entity;

import com.anilakdemir.case2anilakd.dst.entity.DstDistrict;
import lombok.Data;

import javax.persistence.*;

/**
 * @author anilakdemir
 */
@Entity
@Table(name = "NHB_NEIGHBORHOOD")
@Data
public class NhbNeighborhood {

    @Id
    @SequenceGenerator(name = "NHB_NEIGHBORHOOD", sequenceName = "NHB_NEIGHBORHOOD_SEQ")
    @GeneratedValue(generator = "NHB_NEIGHBORHOOD")
    private Long id;

    @Column(name = "NAME",length = 100,nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DST_DISTRICT_ID")
    private DstDistrict district;
}
