package com.github.pmelin.enem.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pmelin.enem.model.School;
import com.github.pmelin.enem.repository.SchoolRepository;
import com.github.pmelin.enem.service.SchoolService;

/**
 * Controller responsible for handling school requests.
 * 
 * @author pmelin
 *
 */
@RestController
public class SchoolController {

	private static final Logger LOGGER = Logger.getLogger(SchoolController.class.getName());

	@Autowired
	private SchoolRepository repository;
	
	@Autowired
	private SchoolService service;

	/**
	 * Returns information about a specific school according to it's code
	 */
	@RequestMapping(value = "/school/code/{code}", method = RequestMethod.GET)
	public ResponseEntity<School> getSchoolById(@PathVariable Long code) {
		try {

			School school = service.schoolByCode(code);
			if (school == null) {
				return new ResponseEntity<School>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<School>(repository.findByCode(code), HttpStatus.OK);
			}

		} catch (Exception e) {
			LOGGER.log(Level.INFO, "Error while retrieving school by code", e);
			return new ResponseEntity<School>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
