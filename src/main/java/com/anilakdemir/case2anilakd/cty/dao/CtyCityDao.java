package com.anilakdemir.case2anilakd.cty.dao;

import com.anilakdemir.case2anilakd.cty.entity.CtyCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author anilakdemir
 */
@Repository
public interface CtyCityDao extends JpaRepository<CtyCity, Long> {

    Optional<CtyCity> findByPlateCodeAndCountry_Code(String plateCode, String countryCode);
}
