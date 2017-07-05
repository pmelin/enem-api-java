package com.github.pmelin.enem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.pmelin.enem.model.School;
import com.github.pmelin.enem.repository.SchoolRepository;
import com.github.pmelin.enem.service.SchoolService;

/**
 * Implementation of {@link SchoolService}
 * 
 * @author pmelin
 *
 */
@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;

	// Max items per page
	private final int PAGE_SIZE = 15;

	@Override
	public School findSchoolByCode(Long code) {
		return this.schoolRepository.findByCode(code);

	}

	@Override
	public List<School> findSchoolsByFilters(int page) {
		Pageable request = new PageRequest(page - 1, PAGE_SIZE);

		return this.schoolRepository.findAll(request).getContent();

	}

}
