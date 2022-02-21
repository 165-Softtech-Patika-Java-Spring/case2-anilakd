package com.anilakdemir.case2anilakd.adr.dao;

import com.anilakdemir.case2anilakd.adr.entity.AdrAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author anilakdemir
 */
@Repository
public interface AdrAddressDao extends JpaRepository<AdrAddress, Long> {
}
