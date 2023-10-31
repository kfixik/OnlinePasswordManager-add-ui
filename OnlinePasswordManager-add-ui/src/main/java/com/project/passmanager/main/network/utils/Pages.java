package com.project.passmanager.main.network.utils;

public class Pages {
    public static String SECRETS_LIST = "secretsListPage";
    public static String SECRET = "secretPage";
    public static String PASSWORD_GENERATION = "passwordGenerationPage";

    public static String redirectToSecretsList() {
        return "redirect:/spaceSecret";
    }
}
