package com.example.codegenerator.repository;

import com.example.codegenerator.domain.Code;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends CrudRepository<Code, Long> {

}
