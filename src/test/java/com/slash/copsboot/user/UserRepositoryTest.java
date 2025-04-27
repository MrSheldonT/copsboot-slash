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
        User user = repository.save(new User(repository.nextId(), "slash@shelldon.uv", "bash -p", roles));

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
