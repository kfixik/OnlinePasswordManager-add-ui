package com.project.passmanager.main.domain.repositories;

import com.project.passmanager.main.domain.models.Secret;

import java.util.List;

public interface ISecretRepository {
    List<Secret> getSecrets();
    Secret getSecretById(String id);
    Secret getEmptySecret();
    void saveSecret(Secret secret);
    void deleteSecret(String id);
}
