package com.juninhos.receitas_culinarias.user.repository;

import com.juninhos.receitas_culinarias.user.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
class UserRepositoryTest {
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

    @Autowired
    private UserRepository userRepository;

    @Test
    void deveSalvarEBuscarUsuarioComSucesso() {
        UserEntity user = new UserEntity();
        user.setName("Teste da Silva");
        user.setEmail("teste@comunidade.com");
        user.setPassword("senhaSegura123");

        UserEntity savedUser = userRepository.save(user);
        var foundUser = userRepository.findById(savedUser.getId());

        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getEmail()).isEqualTo("teste@comunidade.com");
        assertThat(foundUser.get().getCreatedAt()).isNotNull();
    }
}