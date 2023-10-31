package com.project.passmanager.main.network.controllers;

import com.project.passmanager.main.domain.models.Secret;
import com.project.passmanager.main.network.utils.Pages;
import com.project.passmanager.main.network.services.SpaceSecretsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SecretController {
    private final SpaceSecretsService spaceSecretsService;

    @PostMapping("/secret/save/{id}")
    public String saveData(@PathVariable String id, Secret secret) {
        secret.setId(id);
        spaceSecretsService.saveSecret(secret);
        return Pages.redirectToSecretsList();
    }

    @PostMapping("/secret/delete/{id}")
    public String deleteSecret(@PathVariable String id) {
        spaceSecretsService.deleteSecret(id);
        return Pages.redirectToSecretsList();
    }

    @PostMapping("/secret/passwordGeneration")
    public String openPageGeneratePassword(String id) {
        return Pages.PASSWORD_GENERATION;
    }
}
