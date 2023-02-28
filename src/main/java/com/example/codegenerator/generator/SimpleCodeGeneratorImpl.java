package com.example.codegenerator.generator;

import jakarta.validation.constraints.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import static com.example.codegenerator.config.ValidationConfiguration.initCodeRegexp;

@Component
public class SimpleCodeGeneratorImpl implements CodeGenerator {
    /**
     * Generate next code from input String using alphabet and digits
     * @param initCode current last valid code
     * @return next valid code
     */
    @Override
    public String generateNext(String initCode) {
        char[] chars = initCode.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            char current = chars[i];
            // if current isn't 9 or z increment current
            if (current != '9' && current != 'z') {
                chars[i]++;
                break;
            } else if (Character.isDigit(current)) {
                // if current is '9' set it to '0'
                chars[i] = (char) (chars[i] - 9);
            } else {
                // if current is 'z' and it's first character append "a0" to result
                if (i == 0) sb.append("a0");
                // if current  is 'z' set it to 'a'
                chars[i] = (char) (chars[i] - 25);
            }
        }
        return sb.append(String.valueOf(chars)).toString();
    }
}
