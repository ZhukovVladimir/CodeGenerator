package com.example.codegenerator.service;

import com.example.codegenerator.domain.Code;
import com.example.codegenerator.generator.CodeGenerator;
import com.example.codegenerator.repository.CodeRepository;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import static com.example.codegenerator.config.ValidationConfiguration.initCodeRegexp;

@AllArgsConstructor
@Service
@Validated
public class CodeService {
    private final CodeRepository codeRepository;
    private final CodeGenerator codeGenerator;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public String generate(@Pattern(regexp = initCodeRegexp) String initCode) {
        Code defaultCode = new Code();
        // if default Code is present in database, get it (for optimistic locking) or else get default Code with id = 0
        Code currentCode = codeRepository.findById(defaultCode.getId()).orElse(defaultCode);
        if (initCode == null) {
            currentCode.setCode(codeGenerator.generateNext(currentCode.getCode()));
        } else {
            currentCode.setCode(codeGenerator.generateNext(initCode));
        }
        return codeRepository.save(currentCode).getCode();
    }
}
