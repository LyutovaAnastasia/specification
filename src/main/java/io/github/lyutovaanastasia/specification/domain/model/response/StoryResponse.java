package io.github.lyutovaanastasia.specification.domain.model.response;

import io.github.lyutovaanastasia.specification.domain.model.dto.StoryDto;
import io.github.lyutovaanastasia.specification.domain.model.dto.TypeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoryResponse {

    private StoryDto story;
    private TypeDto typeOfStory;
}
