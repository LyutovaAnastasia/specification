package io.github.lyutovaanastasia.specification.persistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "types")
@ToString(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typeSeqGenerator")
    @SequenceGenerator(name = "typeSeqGenerator", sequenceName = "type_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String color;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeId")
    @OrderBy("id ASC")
    private List<StoryEntity> stories;
}
