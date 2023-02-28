package com.example.codegenerator.controller;

import com.example.codegenerator.service.CodeService;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.example.codegenerator.config.ValidationConfiguration.initCodeRegexp;

@SpringBootApplication
@RestController
@Validated
@RequiredArgsConstructor
public class UniqueCodeController {
    private final CodeService codeService;

    @GetMapping("/generate")
    public String generate(@RequestParam(required = false) @Pattern(regexp = initCodeRegexp) String initCode) {
        return codeService.generate(initCode);
    }
}
