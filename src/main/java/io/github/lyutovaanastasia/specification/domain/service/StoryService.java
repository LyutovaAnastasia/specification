package io.github.lyutovaanastasia.specification.domain.service;

import io.github.lyutovaanastasia.specification.domain.model.dto.StoryDto;
import io.github.lyutovaanastasia.specification.domain.model.request.StoryRequest;
import io.github.lyutovaanastasia.specification.domain.model.response.StoryResponse;
import io.github.lyutovaanastasia.specification.persistence.entity.StoryEntity;
import io.github.lyutovaanastasia.specification.persistence.projection.StoryProjection;

import java.util.List;

public interface StoryService {

    StoryDto getStory(Long id);
    List<StoryDto> getAll();
    Long addStory(StoryRequest storyRequest);
    void updateStory(StoryEntity storyEntity);
    void deleteStory(Long id);

    List<StoryResponse> getStoryResponse();
}
