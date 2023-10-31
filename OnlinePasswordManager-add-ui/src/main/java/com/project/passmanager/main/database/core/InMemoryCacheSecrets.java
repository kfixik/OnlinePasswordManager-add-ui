package com.project.passmanager.main.database.core;

import com.project.passmanager.main.database.models.SecretEntity;

import java.util.*;

public class InMemoryCacheSecrets {
    private static final Map<String, SecretEntity> secrets = new HashMap<>();
    static {
        String id1 = UUID.randomUUID().toString();
        String id2 = UUID.randomUUID().toString();
        String id3 = UUID.randomUUID().toString();

        secrets.put(id1, new SecretEntity(id1, "password for email"));
        secrets.put(id2, new SecretEntity(id2, "password for games"));
        secrets.put(id3, new SecretEntity(id3, "password for box"));
    }

    public static List<SecretEntity> getSecrets() {
        return new ArrayList<>(secrets.values());
    }

    public static SecretEntity getSecretById(String id) {
        return secrets.get(id);
    }

    public static SecretEntity getEmptySecret() {
        return new SecretEntity(UUID.randomUUID().toString(), "");
    }

    public static void putSecret(SecretEntity secret) { secrets.put(secret.getId(), secret); }

    public static void deleteSecret(String id) { secrets.remove(id); }
}
