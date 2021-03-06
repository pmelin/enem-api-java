package com.github.pmelin.enem.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Field;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pmelin.enem.TestConfiguration;
import com.github.pmelin.enem.model.School;
import com.github.pmelin.enem.repository.SchoolRepository;

/**
 * Test case for {@link SchoolService}.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfiguration.class })
public class SchoolServiceTest {

	@Autowired
	SchoolService service;
	School school1;

	@Before
	public void init() throws Exception {
		school1 = new School(11012684L, "EEEFM RAIMUNDO CANTANHEDE", "RO", "JARU", "Estadual", 489.156);

		SchoolRepository repository = Mockito.mock(SchoolRepository.class);
		Mockito.when(repository.findByCode(1L)).thenReturn(school1);

		Field field = service.getClass().getDeclaredField("schoolRepository");
		field.setAccessible(true);
		FieldUtils.writeField(field, service, repository);
	}

	@Test
	public void schoolShouldBeRetrievedByCode() {
		School school = this.service.findSchoolByCode(1L);
		assertNotNull(school);
		assertEquals(school1.getName(), school.getName());
		assertEquals(school1.getUf(), school.getUf());
		assertEquals(school1.getMunicipality(), school.getMunicipality());
		assertEquals(school1.getAdminDependency(), school.getAdminDependency());
		assertEquals(school1.getAverage(), school.getAverage(), 0);

	}

	@Test
	public void schoolShouldBeNullIfDoesntExists() {
		School school = this.service.findSchoolByCode(13234234234234L);
		assertNull(school);
	}

}
