package io.github.lyutovaanastasia.specification.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoryDto {

    private Long id;
    private String name;
    private String brief;
    private String description;
    private Long typeId;
}
