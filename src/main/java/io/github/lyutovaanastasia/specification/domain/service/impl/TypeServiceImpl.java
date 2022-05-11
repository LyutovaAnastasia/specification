package io.github.lyutovaanastasia.specification.domain.service.impl;

import io.github.lyutovaanastasia.specification.domain.model.dto.TypeDto;
import io.github.lyutovaanastasia.specification.domain.model.request.TypeRequest;
import io.github.lyutovaanastasia.specification.domain.model.response.TypeResponse;
import io.github.lyutovaanastasia.specification.domain.service.TypeService;
import io.github.lyutovaanastasia.specification.exeption.EntityAlreadyExistsException;
import io.github.lyutovaanastasia.specification.persistence.entity.TypeEntity;
import io.github.lyutovaanastasia.specification.persistence.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2(topic = "TYPE-SERVICE")
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;
    private final ModelMapper mapper;

    @Override
    public TypeDto getType(Long id) {
        return typeRepository.findById(id)
                .map(e -> mapper.map(e, TypeDto.class))
                .orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    @Override
    public List<TypeDto> getAll() {
        return typeRepository.findAll().stream()
                .map(e -> mapper.map(e, TypeDto.class)).collect(Collectors.toList());
    }

    @Override
    public Long addType(TypeRequest typeRequest) {
        if (typeRepository.existsByName(typeRequest.getName())) {
            log.error("Entity with name " + typeRequest.getName() + " is already exists");
            throw new EntityAlreadyExistsException("name " + typeRequest.getName());
        }
        return typeRepository.save(mapper.map(typeRequest, TypeEntity.class)).getId();
    }

    @Override
    public void updateType(TypeEntity typeEntity) {
        typeRepository.findById(typeEntity.getId())
                .map(e -> mapper.map(e, TypeDto.class))
                .orElseThrow(() -> new EntityNotFoundException(typeEntity.getId().toString()));
        var source = mapper.map(typeEntity, TypeEntity.class);
        typeRepository.save(source);
    }

    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }

    @Override
    public TypeEntity getTypeEntity(Long id) {
        return typeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    @Override
    public TypeResponse getTypeResponse(Long id) {
        return typeRepository.findById(id).map(e -> mapper.map(e, TypeResponse.class))
                .orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    @Override
    public List<TypeDto> getTypesActive() {
        return typeRepository.getsTypes().stream()
                .map(e -> mapper.map(e, TypeDto.class))
                .collect(Collectors.toList());

    }
}