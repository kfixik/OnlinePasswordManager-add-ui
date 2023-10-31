package com.project.passmanager.main.database.mappers;

import com.project.passmanager.main.database.models.SecretEntity;
import com.project.passmanager.main.domain.models.Secret;

import java.util.List;

public class SecretMapper {
    public static SecretEntity transform(Secret secret) {
        return new SecretEntity(
                secret.getId(),
                secret.getName()
        );
    }

    public static List<SecretEntity> transformToSecretsEntity(List<Secret> secrets) {
        return secrets
                .stream()
                .map(SecretMapper::transform)
                .toList();
    }

    public static Secret transform(SecretEntity secretEntity) {
        return new Secret(
                secretEntity.getId(),
                secretEntity.getName()
        );
    }

    public static List<Secret> transformToSecrets(List<SecretEntity> secrets) {
        return secrets
                .stream()
                .map(SecretMapper::transform)
                .toList();
    }
}
