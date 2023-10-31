package com.project.passmanager.main.network.controllers;

import com.project.passmanager.main.domain.models.Secret;
import com.project.passmanager.main.domain.models.SecretSpace;
import com.project.passmanager.main.network.services.SpaceSecretsService;
import com.project.passmanager.main.network.utils.Pages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Comparator;

@Controller
@RequiredArgsConstructor
public class SecretsListController {
    private final SpaceSecretsService spaceSecretsService;

    @GetMapping("/spaceSecret")
    public String getSpaceSecretPage(Model model) {
        var spaces = spaceSecretsService.getSecretSpaces();
        model.addAttribute("spaces", spaces);
        model.addAttribute("secrets", new ArrayList<>());
        return Pages.SECRETS_LIST;
    }

    @GetMapping("/spaceSecret/{spaceId}")
    public String getSpaceSecretPage(@PathVariable String spaceId, Model model) {
        var spaces = spaceSecretsService.getSecretSpaces();
        spaces.sort(Comparator.comparing(SecretSpace::getName));
        var secrets = spaceSecretsService.getSecretSpaceById(spaceId).getSecrets();

        model.addAttribute("spaces", spaces);
        model.addAttribute("secrets", secrets);
        return Pages.SECRETS_LIST;
    }

    @GetMapping("/secret/{id}")
    public String secretDetails(@PathVariable String id, Model model) {
       return openSecretPage(model, spaceSecretsService.getSecretById(id));
    }

    @GetMapping("/spaceSecret/createSecret")
    public String createSecret(Model model) {
        return openSecretPage(model, spaceSecretsService.getEmptySecret());
    }

    private String openSecretPage(Model model, Secret secret) {
        model.addAttribute("secret", secret);
        return Pages.SECRET;
    }
}
