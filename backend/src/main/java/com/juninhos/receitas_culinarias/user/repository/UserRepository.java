package com.juninhos.receitas_culinarias.user.repository;

import com.juninhos.receitas_culinarias.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID>{
}