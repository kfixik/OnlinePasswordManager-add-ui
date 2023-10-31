package com.project.passmanager.main.database.repositories;

import com.project.passmanager.main.database.core.InMemoryCacheSecrets;
import com.project.passmanager.main.database.mappers.SecretMapper;
import com.project.passmanager.main.domain.repositories.ISecretRepository;
import com.project.passmanager.main.domain.models.Secret;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SecretRepositoryImpl implements ISecretRepository {
    @Override
    public List<Secret> getSecrets() {
        return SecretMapper.transformToSecrets(new ArrayList<>(InMemoryCacheSecrets.getSecrets()));
    }

    @Override
    public Secret getSecretById(String id) {
        return SecretMapper.transform(InMemoryCacheSecrets.getSecretById(id));
    }

    @Override
    public Secret getEmptySecret() {
        return SecretMapper.transform(InMemoryCacheSecrets.getEmptySecret());
    }

    @Override
    public void saveSecret(Secret secret) {
        InMemoryCacheSecrets.putSecret(SecretMapper.transform(secret));
    }

    @Override
    public void deleteSecret(String id) {
        InMemoryCacheSecrets.deleteSecret(id);
    }
}
