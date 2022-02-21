package com.anilakdemir.case2anilakd.nhb.dao;

import com.anilakdemir.case2anilakd.nhb.entity.NhbNeighborhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author anilakdemir
 */
@Repository
public interface NhbNeighborhoodDao extends JpaRepository<NhbNeighborhood, Long> {
    List<NhbNeighborhood> findAllByDistrict_Id(Long id);
}
