package com.example.codegenerator.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "code")
public class Code {
    @Id
    private Long id = 0l;
    @Column("code")
    private String code;
    @Version
    private Long version;
}
