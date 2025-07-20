package com.cabbage16.fanspot.infrastructure.persistence.auth;

import com.cabbage16.fanspot.domain.auth.domain.Token;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TokenRepository extends CrudRepository<Token, UUID> {
}
