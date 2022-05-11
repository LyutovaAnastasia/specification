package io.github.lyutovaanastasia.specification.persistence.projection;

public interface StoryProjection {

    Long getId();
    String getName();
    String getBrief();
    String getDescription();
    String getTypeId();
    String getType();
    String getColorType();
}

