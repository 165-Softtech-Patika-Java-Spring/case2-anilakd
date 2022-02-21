package com.anilakdemir.case2anilakd.cnt.dao;

import com.anilakdemir.case2anilakd.cnt.entity.CntCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * @author anilakdemir
 */
@Repository
public interface CntCountryDao extends JpaRepository<CntCountry, Long> {
    Optional<CntCountry> findByCode(String code);
}
