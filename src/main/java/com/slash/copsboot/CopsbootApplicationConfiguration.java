package com.slash.copsboot;

import com.slash.copsboot.orm.jpa.InMemoryUniqueIdGenerator;
import com.slash.copsboot.orm.jpa.UniqueIdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class CopsbootApplicationConfiguration {
    @Bean
    public UniqueIdGenerator<UUID> generator() {
        return new InMemoryUniqueIdGenerator();
    }
}
