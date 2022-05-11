package io.github.lyutovaanastasia.specification.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@ToString(of = "id")
@Table(name = "stories")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class StoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "storySeqGenerator")
    @SequenceGenerator(name = "storySeqGenerator", sequenceName = "story_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String brief;
    private String description;

    private Long typeId;
}
