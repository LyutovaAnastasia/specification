package io.github.lyutovaanastasia.specification.mapper.config;

import io.github.lyutovaanastasia.specification.domain.model.dto.StoryDto;
import io.github.lyutovaanastasia.specification.domain.model.dto.TypeDto;
import io.github.lyutovaanastasia.specification.domain.model.request.StoryRequest;
import io.github.lyutovaanastasia.specification.domain.model.response.StoryResponse;
import io.github.lyutovaanastasia.specification.domain.model.response.TypeResponse;
import io.github.lyutovaanastasia.specification.persistence.entity.StoryEntity;
import io.github.lyutovaanastasia.specification.persistence.entity.TypeEntity;
import io.github.lyutovaanastasia.specification.persistence.projection.StoryProjection;
import io.github.lyutovaanastasia.specification.persistence.projection.TypeProjection;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MapperConfig {

    @Bean
    public ModelMapper createMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper
            .getConfiguration()
            .setMatchingStrategy(MatchingStrategies.STRICT)
            //           .setAmbiguityIgnored(true)
            .setFieldMatchingEnabled(false)
            .setSkipNullEnabled(true)
            .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        mapper
            .typeMap(TypeEntity.class, TypeDto.class)
            .addMappings(m -> m.map(TypeEntity::getName, TypeDto::setName))
            .addMappings(m -> m.map(TypeEntity::getColor, TypeDto::setColor));

        mapper
            .typeMap(StoryEntity.class, StoryDto.class)
            .addMappings(m -> m.map(StoryEntity::getName, StoryDto::setName))
            .addMappings(m -> m.map(StoryEntity::getBrief, StoryDto::setBrief))
            .addMappings(m -> m.map(StoryEntity::getDescription, StoryDto::setDescription))
            .addMappings(m -> m.map(StoryEntity::getTypeId, StoryDto::setTypeId));

        mapper
            .typeMap(StoryRequest.class, StoryEntity.class)
            .addMappings(m -> m.skip(StoryEntity::setId))
            .addMappings(m -> m.map(StoryRequest::getName, StoryEntity::setName))
            .addMappings(m -> m.map(StoryRequest::getBrief, StoryEntity::setBrief))
            .addMappings(m -> m.map(StoryRequest::getDescription, StoryEntity::setDescription));

        mapper
            .typeMap(StoryProjection.class, StoryResponse.class)
            .addMappings(m -> m.<Long>map(StoryProjection::getId, (target, value) -> target.getStory().setId(value)))
            .addMappings(m -> m.<String>map(StoryProjection::getName, (target, value) -> target.getStory().setName(value)))
            .addMappings(m -> m.<String>map(StoryProjection::getBrief, (target, value) -> target.getStory().setBrief(value)))
            .addMappings(m -> m.<String>map(StoryProjection::getDescription, (target, value) -> target.getStory().setDescription(value)))
            .addMappings(m -> m.<Long>map(StoryProjection::getTypeId, (target, value) -> target.getStory().setTypeId(value)))
            .addMappings(m -> m.<Long>map(StoryProjection::getTypeId, (target, value) -> target.getTypeOfStory().setId(value)))
            .addMappings(m -> m.<String>map(StoryProjection::getType, (target, value) -> target.getTypeOfStory().setName(value)))
            .addMappings(m -> m.<String>map(StoryProjection::getColorType, (target, value) -> target.getTypeOfStory().setColor(value)));

        mapper
            .typeMap(TypeEntity.class, TypeResponse.class)
            .addMappings(m -> m.<Long>map(TypeEntity::getId, (target, value) -> target.getType().setId(value)))
            .addMappings(m -> m.<String>map(TypeEntity::getName, (target, value) -> target.getType().setName(value)))
            .addMappings(m -> m.<String>map(TypeEntity::getColor, (target, value) -> target.getType().setColor(value)))
            .addMappings(m -> m.map(TypeEntity::getStories,  TypeResponse::setStories));

        mapper
            .typeMap(TypeProjection.class, TypeDto.class)
            .addMappings(m -> m.map(TypeProjection::getId, TypeDto::setId))
            .addMappings(m -> m.map(TypeProjection::getName,  TypeDto::setName))
            .addMappings(m -> m.map(TypeProjection::getColor, TypeDto::setColor));

        return mapper;
    }
}

//
//        mapper
//            .typeMap(TypeEntity.class, TypeDto.class)
//            .addMappings(m -> m.<Long>map(SectionEntity::getId, (target, value) -> target.getSection().setId(value)))
//            .addMappings(m -> m.<String>map(SectionEntity::getName, (target, value) -> target.getSection().setName(value)))
//            .addMappings(m -> m.map(SectionEntity::getCategories, SectionResponse::setCategories));
