package com.anilakdemir.case2anilakd.str.entity;

import com.anilakdemir.case2anilakd.cnt.entity.CntCountry;
import com.anilakdemir.case2anilakd.nhb.entity.NhbNeighborhood;
import lombok.Data;

import javax.persistence.*;

/**
 * @author anilakdemir
 */
@Entity
@Table(name = "STR_STREET")
@Data
public class StrStreet {

    @Id
    @SequenceGenerator(name = "StrStreet" , sequenceName = "STREET_ID_SEQ")
    @GeneratedValue(generator = "StrStreet")
    private Long id;

    @Column(name = "NAME",length = 100, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NHB_NEIGHBORHOOD_ID")
    private NhbNeighborhood neighborhood;
}
