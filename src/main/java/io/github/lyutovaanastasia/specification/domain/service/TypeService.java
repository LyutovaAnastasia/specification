package io.github.lyutovaanastasia.specification.domain.service;

import io.github.lyutovaanastasia.specification.domain.model.dto.TypeDto;
import io.github.lyutovaanastasia.specification.domain.model.request.TypeRequest;
import io.github.lyutovaanastasia.specification.domain.model.response.TypeResponse;
import io.github.lyutovaanastasia.specification.persistence.entity.TypeEntity;

import java.util.List;

public interface TypeService {

    TypeDto getType(Long id);
    List<TypeDto> getAll();
    Long addType(TypeRequest typeRequest);
    void updateType(TypeEntity typeEntity);
    void deleteType(Long id);
    TypeEntity getTypeEntity(Long id);
    TypeResponse getTypeResponse(Long id);
    List<TypeDto> getTypesActive();
}
