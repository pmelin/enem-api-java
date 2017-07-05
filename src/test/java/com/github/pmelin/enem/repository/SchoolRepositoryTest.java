package com.github.pmelin.enem.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pmelin.enem.TestConfiguration;
import com.github.pmelin.enem.model.School;

/**
 * Test case for {@link SchoolRepository}.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfiguration.class })
public class SchoolRepositoryTest {

	@Autowired
	SchoolRepository repository;
	List<School> testSchools;

	@Before
	public void init() {
		repository.deleteAll();
		testSchools = new ArrayList<School>();

		testSchools.add(new School(11012684L, "EEEFM RAIMUNDO CANTANHEDE", "RO", "JARU", "Estadual", 489.156));
		testSchools
				.add(new School(11007656L, "COLEGIO DINAMICO EDUCACAO BASICA", "RO", "ARIQUEMES", "Privada", 573.46));
		testSchools.add(new School(11033797L, "EEEFM ALVARES DE AZEVEDO", "RO", "VILHENA", "Estadual", 499.33));
		testSchools.add(new School(11033797L, "EEEFM ALVARES DE AZEVEDO", "RO", "VILHENA", "Estadual", 499.33));
		testSchools.add(new School(11015608L, "EEEFM ALUIZIO FERREIRA", "RO", "JI-PARANA", "Estadual", 478.002));
		testSchools.add(new School(13098519L, "COLEGIO DOM BOSCO LESTE", "AM", "MANAUS", "Privada", 4957.0));
		testSchools.add(new School(15132412L, "EEEM MACARIO DANTAS SEDE", "PA", "SAO GERALDO DO ARAGUAIA", "Estadual",
				460.004));
		testSchools.add(
				new School(17005337L, "COL EST PROFª SILVANDIRA SOUSA LIMA", "TO", "ARAGUAINA", "Estadual", 464.838));
		for (School school : testSchools) {
			repository.save(school);
		}
	}

	@Test
	public void schoolShouldBeRetrievedByCode() {
		School testSchool = this.testSchools.get(0);
		School school = this.repository.findByCode(testSchool.getCode());
		assertNotNull(school);
		assertEquals(testSchool.getName(), school.getName());
		assertEquals(testSchool.getUf(), school.getUf());
		assertEquals(testSchool.getMunicipality(), school.getMunicipality());
		assertEquals(testSchool.getAdminDependency(), school.getAdminDependency());
		assertEquals(testSchool.getAverage(), school.getAverage(), 0);
	}

	@Test
	public void schoolShouldBeNullIfDoesntExists() {
		School school = this.repository.findByCode(2342423L);
		assertNull(school);
	}

	@Test
	public void listOfPaginatedSchoolsShouldBeRetrieved() {
		//first page, 3 schools per page
		Page<School> firstPage = this.repository.findAll(new PageRequest(0, 3)); 
		List<School> schools = firstPage.getContent();
		assertEquals(schools.size(), 3);
		for (int i = 0; i < schools.size(); i++) {
			assertEquals(schools.get(i).getCode(), testSchools.get(i).getCode());
			assertEquals(schools.get(i).getName(), testSchools.get(i).getName());
			assertEquals(schools.get(i).getUf(), testSchools.get(i).getUf());
			assertEquals(schools.get(i).getMunicipality(), testSchools.get(i).getMunicipality());
			assertEquals(schools.get(i).getAverage(), testSchools.get(i).getAverage(), 0);
		}

	}

}
