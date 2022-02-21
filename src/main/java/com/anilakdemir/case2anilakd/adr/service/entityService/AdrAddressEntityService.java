package com.anilakdemir.case2anilakd.adr.service.entityService;

import com.anilakdemir.case2anilakd.adr.dao.AdrAddressDao;
import com.anilakdemir.case2anilakd.adr.entity.AdrAddress;
import com.anilakdemir.case2anilakd.gen.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author anilakdemir
 */
@Service
@RequiredArgsConstructor
public class AdrAddressEntityService {

    private final AdrAddressDao adrAddressDao;

    public AdrAddress save(AdrAddress adrAddress){
        return adrAddressDao.save(adrAddress);
    }

    public void deleteAdrAddressById (Long id) {
        adrAddressDao.deleteById(id);
    }

    public AdrAddress findById(Long id){
        return adrAddressDao.findById(id).orElseThrow(()->new ItemNotFoundException("Address can not found"));
    }
}
