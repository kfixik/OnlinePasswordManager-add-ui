package com.project.passmanager.main.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SecretSpace {
    private String id;
    private String name;
    private List<Secret> secrets;
}
