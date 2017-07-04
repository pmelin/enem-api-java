package com.github.pmelin.enem.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pmelin.enem.TestConfiguration;
import com.github.pmelin.enem.model.School;
import com.github.pmelin.enem.repository.SchoolRepository;

import static org.junit.Assert.*;

/**
 * Test case for {@link SchoolRepository}.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfiguration.class })
public class SchoolRepositoryTest {

	@Autowired
	SchoolRepository repository;

	@Before
	public void init() {
		repository.deleteAll();
		School school1 = new School(11012684L, "EEEFM RAIMUNDO CANTANHEDE", "RO", "JARU", "Estadual", 489.156);
		School school2 = new School(11007656L, "COLEGIO DINAMICO EDUCACAO BASICA", "RO", "ARIQUEMES", "Privada",
				573.46);
		School school3 = new School(11033797L, "EEEFM ALVARES DE AZEVEDO", "RO", "VILHENA", "Estadual", 499.33);
		repository.save(school1);
		repository.save(school2);
		repository.save(school3);
	}

	@Test
	public void schoolShouldBeRetrievedByCode() {
		School school = this.repository.findByCode(11007656L);
		assertNotNull(school);
		assertEquals("COLEGIO DINAMICO EDUCACAO BASICA", school.getName());
		assertEquals("RO", school.getUf());
		assertEquals("ARIQUEMES", school.getMunicipality());
		assertEquals("Privada", school.getAdminDependency());
		assertEquals(573.46, school.getAverage(), 0);
	}
	
	@Test
	public void schoolShouldBeNullIfDoesntExists() {
		School school = this.repository.findByCode(2342423L);
		assertNull(school);
	}

}
