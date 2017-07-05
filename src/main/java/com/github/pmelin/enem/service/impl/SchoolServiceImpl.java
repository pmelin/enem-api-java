package com.github.pmelin.enem.service.impl;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

	private static final Logger LOGGER = Logger.getLogger(SchoolServiceImpl.class.getName());

	@Autowired
	private SchoolRepository schoolRepository;

	@Autowired
	private MongoTemplate template;

	// Max items per page
	private final int PAGE_SIZE = 15;

	@Override
	public School findSchoolByCode(Long code) {
		return this.schoolRepository.findByCode(code);

	}

	@Override
	public List<School> findSchoolsByFilters(Map<String, String[]> filters, int page) {
		Pageable pageable = new PageRequest(page - 1, PAGE_SIZE);
		Query query = new Query();
		query.with(pageable);

		if (filters.containsKey("adm")) {
			switch (filters.get("adm")[0]) {
			case "PRI":
				query.addCriteria(Criteria.where("adminDependency").is("Privada"));
				break;

			case "PUB":
				query.addCriteria(Criteria.where("adminDependency").in("Estadual", "Municipal", "Federal"));
				break;

			}
		}

		if (filters.containsKey("uf")) {
			query.addCriteria(Criteria.where("uf").is(filters.get("uf")[0]));

			if (filters.containsKey("municipality")) {
				query.addCriteria(Criteria.where("municipality").is(filters.get("municipality")[0]));

			}

		}

		if (filters.containsKey("name")) {
			query.addCriteria(Criteria.where("name").regex(filters.get("name")[0]));
		}

		if (filters.containsKey("sortSchl")) {
			switch (filters.get("sortSchl")[0]) {
			case "NAME":
				query.with(new Sort("name"));
				break;

			case "UF":
				query.with(new Sort("uf"));
				break;

			case "AVERAGE":
				query.with(new Sort("average"));
				break;

			case "POSITION":
				query.with(new Sort("position"));
				break;

			default:
				query.with(new Sort("position"));
			}

		}
		
		return this.template.find(query, School.class);

	}

}
