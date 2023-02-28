package com.example.codegenerator.generator;

import org.springframework.stereotype.Component;

public interface CodeGenerator {
    String generateNext(String currentCode);
}
