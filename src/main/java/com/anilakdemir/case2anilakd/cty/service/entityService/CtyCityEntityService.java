package com.anilakdemir.case2anilakd.cty.service.entityService;

import com.anilakdemir.case2anilakd.cty.dao.CtyCityDao;
import com.anilakdemir.case2anilakd.cty.entity.CtyCity;
import com.anilakdemir.case2anilakd.gen.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author anilakdemir
 */
@Service
@RequiredArgsConstructor
public class CtyCityEntityService {

    private final CtyCityDao ctyCityDao;

    public CtyCity save(CtyCity ctyCity){
        return ctyCityDao.save(ctyCity);
    }

    public CtyCity findCityByPlateCode (String plateCode, String countryCode) {
        return ctyCityDao.findByPlateCodeAndCountry_Code(plateCode,countryCode).orElseThrow(()->new ItemNotFoundException("City can not found"));
    }

    public CtyCity findCityById(Long id){
        return ctyCityDao.findById(id).orElseThrow(()->new ItemNotFoundException("City can not found"));
    }

    public boolean existById(Long id){
        return ctyCityDao.existsById(id);
    }
}
