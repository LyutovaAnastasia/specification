package io.github.lyutovaanastasia.specification.trace.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.HeaderFilter;
import org.zalando.logbook.HeaderFilters;

@Configuration
public class ZalandoConfig {
    @Bean
    public HeaderFilter headerFilter(@Value("${logbook.headers.enabled}") boolean enabled) {
        return enabled
                ? HeaderFilters.defaultValue()
                : HeaderFilters.removeHeaders(s -> true);
    }
}