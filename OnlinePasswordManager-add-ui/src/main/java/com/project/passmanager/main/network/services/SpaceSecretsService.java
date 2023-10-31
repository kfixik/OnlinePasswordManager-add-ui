package com.project.passmanager.main.network.services;

import com.project.passmanager.main.database.core.InMemoryCacheSecretSpace;
import com.project.passmanager.main.domain.models.Secret;
import com.project.passmanager.main.domain.models.SecretSpace;
import com.project.passmanager.main.domain.repositories.ISecretRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpaceSecretsService {
    private final ISecretRepository secretRepository;

    public List<SecretSpace> getSecretSpaces() {
        return InMemoryCacheSecretSpace.getSecretSpaces();
    }

    public SecretSpace getSecretSpaceById(String id) {
        return InMemoryCacheSecretSpace.getSecretSpaceById(id);
    }

    public Secret getSecretById(String id) {
        return secretRepository.getSecretById(id);
    }

    public Secret getEmptySecret() {
        return secretRepository.getEmptySecret();
    }

    public void saveSecret(Secret secret) {
        secretRepository.saveSecret(secret);
    }

    public void deleteSecret(String id) {
        secretRepository.deleteSecret(id);
    }
}
