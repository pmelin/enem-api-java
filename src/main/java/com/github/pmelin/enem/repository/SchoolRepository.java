package com.github.pmelin.enem.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.github.pmelin.enem.model.School;

/**
 * Spring data repository for schools.
 * 
 * @author pmelin
 *
 */
public interface SchoolRepository extends MongoRepository<School, Long>, QueryByExampleExecutor<School> {

	School findByCode(Long code);

	Page<School> findAll(Pageable pageable);


}
