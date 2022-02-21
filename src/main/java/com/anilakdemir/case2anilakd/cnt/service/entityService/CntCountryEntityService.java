package com.anilakdemir.case2anilakd.cnt.service.entityService;

import com.anilakdemir.case2anilakd.cnt.dao.CntCountryDao;
import com.anilakdemir.case2anilakd.cnt.entity.CntCountry;
import com.anilakdemir.case2anilakd.gen.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author anilakdemir
 */
@Service
@RequiredArgsConstructor
public class CntCountryEntityService {

    private final CntCountryDao cntCountryDao;

    public CntCountry save(CntCountry cntCountry){
        return cntCountryDao.save(cntCountry);
    }

    public boolean existById(Long id){
        return cntCountryDao.existsById(id);
    }

    public CntCountry findById(Long id){
        return cntCountryDao.findById(id).orElseThrow(()->new ItemNotFoundException("Country can not found"));
    }

    public CntCountry findByCode(String code){
        return cntCountryDao.findByCode(code).orElseThrow(()->new ItemNotFoundException("Country can not found"));
    }

}
