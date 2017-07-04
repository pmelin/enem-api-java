package com.github.pmelin.enem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pmelin.enem.model.School;
import com.github.pmelin.enem.repository.SchoolRepository;
import com.github.pmelin.enem.service.SchoolService;

/**
 * Implementation of {@link SchoolService}
 * @author pmelin
 *
 */
@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;

	@Override
	public School schoolByCode(Long code) {
		return this.schoolRepository.findByCode(code);

	}

}
