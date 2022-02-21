package com.anilakdemir.case2anilakd.dst.service.entityService;

import com.anilakdemir.case2anilakd.dst.dao.DstDistrictDao;
import com.anilakdemir.case2anilakd.dst.entity.DstDistrict;
import com.anilakdemir.case2anilakd.gen.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author anilakdemir
 */
@Service
@RequiredArgsConstructor
public class DstDistrictEntityService {

    private final DstDistrictDao dstDistrictDao;

    public DstDistrict save(DstDistrict dstDistrict){
        return dstDistrictDao.save(dstDistrict);
    }

    public List<DstDistrict> findAllByCityId(Long cityId){
        return dstDistrictDao.findAllByCity_Id(cityId);
    }

    public boolean existById (Long districtId) {
        return dstDistrictDao.existsById(districtId);
    }

    public DstDistrict findById (Long districtId) {
        return dstDistrictDao.findById(districtId).orElseThrow(()->new ItemNotFoundException("District can not found"));
    }
}
