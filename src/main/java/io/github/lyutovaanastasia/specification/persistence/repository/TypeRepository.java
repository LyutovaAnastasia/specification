package io.github.lyutovaanastasia.specification.persistence.repository;

import io.github.lyutovaanastasia.specification.persistence.entity.TypeEntity;
import io.github.lyutovaanastasia.specification.persistence.projection.StoryProjection;
import io.github.lyutovaanastasia.specification.persistence.projection.TypeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeRepository extends JpaRepository<TypeEntity, Long> {

    Boolean existsByName(String name);

    @Query(value = "select t.id, t.name, t.color" +
            " from specification.types t" +
            "         inner join specification.stories s on s.type_id = t.id group by t.id order by t.id", nativeQuery = true)
    List<TypeProjection> getsTypes();
}
