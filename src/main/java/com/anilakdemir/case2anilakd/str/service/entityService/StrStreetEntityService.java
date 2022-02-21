package com.anilakdemir.case2anilakd.str.service.entityService;

import com.anilakdemir.case2anilakd.gen.exceptions.ItemNotFoundException;
import com.anilakdemir.case2anilakd.str.dao.StrStreetDao;
import com.anilakdemir.case2anilakd.str.entity.StrStreet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author anilakdemir
 */
@Service
@RequiredArgsConstructor
public class StrStreetEntityService {

    private final StrStreetDao strStreetDao;

    public StrStreet save(StrStreet strStreet){
        return strStreetDao.save(strStreet);
    }

    public StrStreet findById(Long id){
        return strStreetDao.findById(id).orElseThrow(()->new ItemNotFoundException("Street can not found"));
    }

    public List<StrStreet> findAllByNeighborhoodId(Long neighborhoodId){
        return strStreetDao.findAllByNeighborhood_Id(neighborhoodId);
    }

    public boolean existById (Long id) {
        return strStreetDao.existsById(id);
    }
}
