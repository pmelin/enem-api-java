package com.github.pmelin.enem.service;

import java.util.List;
import java.util.Map;

import com.github.pmelin.enem.model.School;

/**
 * Interface that defines business methods for schools.
 * 
 * @author pmelin
 *
 */
public interface SchoolService {

	/**
	 * Retrieves a school by its id.
	 * 
	 * @param id
	 *            the id of the school.
	 * @return school with the id or null
	 */
	School findSchoolByCode(Long id);

	/**
	 * Retrieves the list of schools considering multiple optional filters.
	 * 
	 * @param page
	 * @return list of schools
	 * @throws Exception 
	 */
	List<School> findSchoolsByFilters(Map<String, String[]> filters, int page);

}
