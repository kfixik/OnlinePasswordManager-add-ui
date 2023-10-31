package com.project.passmanager.main.database.core;

import com.project.passmanager.main.database.mappers.SecretMapper;
import com.project.passmanager.main.domain.models.Secret;
import com.project.passmanager.main.domain.models.SecretSpace;

import java.util.*;

public class InMemoryCacheSecretSpace {

    private static final Map<String, SecretSpace> spaces = new HashMap<>();

    static {
        String id1 = UUID.randomUUID().toString();
        String id2 = UUID.randomUUID().toString();
        String id3 = UUID.randomUUID().toString();

        var secrets = InMemoryCacheSecrets.getSecrets();

        var secrets1 = new ArrayList<Secret>();
        {
            secrets1.add(SecretMapper.transform(secrets.get(0)));
        }
        var secrets2 = new ArrayList<Secret>();
        {
            secrets2.add(SecretMapper.transform(secrets.get(1)));
        }
        var secrets3 = new ArrayList<Secret>();
        {
            secrets3.add(SecretMapper.transform(secrets.get(2)));
        }

        spaces.put(id1, new SecretSpace(id1, "space1", secrets1));
        spaces.put(id2, new SecretSpace(id2, "space2", secrets2));
        spaces.put(id3, new SecretSpace(id3, "space3", secrets3));
    }

    public static List<SecretSpace> getSecretSpaces() {
        return new ArrayList<>(spaces.values());
    }

    public static SecretSpace getSecretSpaceById(String id) {
        return spaces.get(id);
    }
}
