package com.anilakdemir.case2anilakd.str.dao;

import com.anilakdemir.case2anilakd.str.entity.StrStreet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author anilakdemir
 */
@Repository
public interface StrStreetDao extends JpaRepository<StrStreet, Long> {
    List<StrStreet> findAllByNeighborhood_Id(Long id);
}
