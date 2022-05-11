package io.github.lyutovaanastasia.specification.domain.service.impl;

import io.github.lyutovaanastasia.specification.domain.model.dto.StoryDto;
import io.github.lyutovaanastasia.specification.domain.model.dto.TypeDto;
import io.github.lyutovaanastasia.specification.domain.model.request.StoryRequest;
import io.github.lyutovaanastasia.specification.domain.model.response.StoryResponse;
import io.github.lyutovaanastasia.specification.domain.service.StoryService;
import io.github.lyutovaanastasia.specification.domain.service.TypeService;
import io.github.lyutovaanastasia.specification.exeption.EntityAlreadyExistsException;
import io.github.lyutovaanastasia.specification.persistence.entity.StoryEntity;
import io.github.lyutovaanastasia.specification.persistence.projection.StoryProjection;
import io.github.lyutovaanastasia.specification.persistence.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2(topic = "STORY-SERVICE")
public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;
    private final TypeService typeService;
    private final ModelMapper mapper;

    @Override
    public StoryDto getStory(Long id) {
        return storyRepository.findById(id)
                .map(e -> mapper.map(e, StoryDto.class))
                .orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    @Override
    public List<StoryDto> getAll() {
        return storyRepository.findAll().stream()
                .map(e -> mapper.map(e, StoryDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Long addStory(StoryRequest storyRequest) {
        if (storyRepository.existsByName(storyRequest.getName())) {
            log.error("Entity with name " + storyRequest.getName() + " is already exists");
            throw new EntityAlreadyExistsException("name " + storyRequest.getName());
        }
        typeService.getTypeEntity(storyRequest.getTypeId());
        return storyRepository.save(mapper.map(storyRequest, StoryEntity.class)).getId();
    }

    @Override
    public void updateStory(StoryEntity storyEntity) {
        storyRepository.findById(storyEntity.getId())
                .map(e -> mapper.map(e, TypeDto.class))
                .orElseThrow(() -> new EntityNotFoundException(storyEntity.getId().toString()));
        var source = mapper.map(storyEntity, StoryEntity.class);
        storyRepository.save(source);
    }

    @Override
    public void deleteStory(Long id) {
        storyRepository.deleteById(id);
    }

    @Override
    public List<StoryResponse> getStoryResponse() {
        return storyRepository.getsStories().stream()
                .map(e -> mapper.map(e, StoryResponse.class)).collect(Collectors.toList());
    }
}