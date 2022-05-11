package io.github.lyutovaanastasia.specification.domain.model.response;

import io.github.lyutovaanastasia.specification.domain.model.dto.StoryDto;
import io.github.lyutovaanastasia.specification.domain.model.dto.TypeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypeResponse {

    private TypeDto type;
    private List<StoryDto> stories;
}
