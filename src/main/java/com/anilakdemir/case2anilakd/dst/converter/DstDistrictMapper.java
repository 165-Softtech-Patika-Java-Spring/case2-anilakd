package com.anilakdemir.case2anilakd.dst.converter;

import com.anilakdemir.case2anilakd.dst.dto.DstDistrictDto;
import com.anilakdemir.case2anilakd.dst.dto.DstDistrictSaveRequestDto;
import com.anilakdemir.case2anilakd.dst.entity.DstDistrict;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author anilakdemir
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DstDistrictMapper {

    DstDistrictMapper INSTANCE = Mappers.getMapper(DstDistrictMapper.class);

    DstDistrict convertToDstDistrict(DstDistrictSaveRequestDto dstDistrictSaveRequestDto);

    DstDistrictDto convertToDstDistrictDto(DstDistrict dstDistrict);

    List<DstDistrictDto> convertToDstDistrictList(List<DstDistrict> districtList);
}
