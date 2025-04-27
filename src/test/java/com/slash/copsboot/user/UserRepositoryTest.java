package com.slash.copsboot.user;
import com.slash.copsboot.infraestructure.security.SpringProfiles;
import com.slash.copsboot.orm.jpa.InMemoryUniqueIdGenerator;
import com.slash.copsboot.orm.jpa.UniqueIdGenerator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashSet;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles(SpringProfiles.REPOSITORY_TEST)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;
    @Qualifier("jdbcTemplate")
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testStoreuser() {
        HashSet<UserRole> roles = new HashSet<>();

        roles.add(UserRole.OFFICER);
        User user = repository.save(new User(repository.nextId(),
                                        "slash@shelldon.uv",
                                        new AuthServerId(UUID.randomUUID()),
                            "c41536a5a8b9d3f14a7e5472a5322b5e1f76a6e7a9255c2c2e7e0d3a2c5b9d0"));

        assertThat(user).isNotNull();

        assertThat(repository.count()).isEqualTo(1L);
        entityManager.flush();
        assertThat(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM copsboot_user", Long.class)).isEqualTo(1L);
        assertThat(jdbcTemplate.queryForObject("SELECT email FROM copsboot_user", String.class)).isEqualTo(
                "slash@shelldon.uv");
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public UniqueIdGenerator<UUID> generator() {
            return new InMemoryUniqueIdGenerator();
        }
    }
}
