package com.anilakdemir.case2anilakd.nhb.service.entityService;

import com.anilakdemir.case2anilakd.gen.exceptions.ItemNotFoundException;
import com.anilakdemir.case2anilakd.nhb.dao.NhbNeighborhoodDao;
import com.anilakdemir.case2anilakd.nhb.entity.NhbNeighborhood;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author anilakdemir
 */
@Service
@RequiredArgsConstructor
public class NhbNeighborhoodEntityService {

    private final NhbNeighborhoodDao nhbNeighborhoodDao;

    public NhbNeighborhood save(NhbNeighborhood nhbNeighborhood){
        return nhbNeighborhoodDao.save(nhbNeighborhood);
    }

    public NhbNeighborhood findById(Long id){
        return nhbNeighborhoodDao.findById(id).orElseThrow(()->new ItemNotFoundException("Neighborhood can not found"));
    }

    public List<NhbNeighborhood> findAllByDistrictId(Long districtId){
        return nhbNeighborhoodDao.findAllByDistrict_Id(districtId);
    }

    public boolean existById(Long id){
        return nhbNeighborhoodDao.existsById(id);
    }
}
