package com.example.codegenerator.generator;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCodeGeneratorImplTest {

    private CodeGenerator codeGenerator = new SimpleCodeGeneratorImpl();

    @Test
    void test_generateNext_ReturnsCorrectValue() {
        String currentCode = "a0";
        String expectedNextCode = "a1";
        assertEquals(expectedNextCode, codeGenerator.generateNext(currentCode));

        currentCode = "b9";
        expectedNextCode = "c0";
        assertEquals(expectedNextCode, codeGenerator.generateNext(currentCode));

        currentCode = "z9z9";
        expectedNextCode = "a0a0a0";
        assertEquals(expectedNextCode, codeGenerator.generateNext(currentCode));

        currentCode = "z9f5z9";
        expectedNextCode = "z9f6a0";
        assertEquals(expectedNextCode, codeGenerator.generateNext(currentCode));
    }
}