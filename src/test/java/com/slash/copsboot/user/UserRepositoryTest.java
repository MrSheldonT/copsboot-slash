package com.slash.copsboot.user;
import com.slash.copsboot.orm.jpa.InMemoryUniqueIdGenerator;
import com.slash.copsboot.orm.jpa.UniqueIdGenerator;
import com.slash.copsboot.orm.jpa.UniqueIdGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    public void testStoreuser() {
        HashSet<UserRole> roles = new HashSet<>();

        roles.add(UserRole.OFFICER);
        User user = repository.save(new User(repository.nextId(),
                                        "slash@shelldon.uv",
                                        new AuthServerId(UUID.randomUUID()),
                            "c41536a5a8b9d3f14a7e5472a5322b5e1f76a6e7a9255c2c2e7e0d3a2c5b9d0"));

        assertThat(user).isNotNull();

        assertThat(user).isNotNull();
        assertThat(repository.count()).isEqualTo(1L);
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public UniqueIdGenerator<UUID> generator() {
            return new InMemoryUniqueIdGenerator();
        }
    }
}
