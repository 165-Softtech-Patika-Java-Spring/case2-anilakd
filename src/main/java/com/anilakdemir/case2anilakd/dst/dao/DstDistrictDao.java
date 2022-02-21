package com.anilakdemir.case2anilakd.dst.dao;

import com.anilakdemir.case2anilakd.dst.entity.DstDistrict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author anilakdemir
 */
@Repository
public interface DstDistrictDao extends JpaRepository<DstDistrict, Long> {
    List<DstDistrict> findAllByCity_Id(Long id);
}
