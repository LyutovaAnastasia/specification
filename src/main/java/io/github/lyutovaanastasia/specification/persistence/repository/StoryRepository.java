package io.github.lyutovaanastasia.specification.persistence.repository;

import io.github.lyutovaanastasia.specification.persistence.entity.StoryEntity;
import io.github.lyutovaanastasia.specification.persistence.projection.StoryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoryRepository extends JpaRepository<StoryEntity, Long> {

    Boolean existsByName(String name);


    @Query(value = "select s.id, s.name, s.brief, s.description, t.id as typeId, t.name as type, t.color as colorType" +
            "    from specification.stories s" +
            "      left join specification.types t on s.type_id = t.id order by s.id", nativeQuery = true)
    List<StoryProjection> getsStories();
}
