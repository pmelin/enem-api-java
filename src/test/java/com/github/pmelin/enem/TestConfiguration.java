package com.github.pmelin.enem;

import com.github.pmelin.enem.service.SchoolService;
import com.github.pmelin.enem.service.impl.SchoolServiceImpl;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public class TestConfiguration {

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(new MongoClient("localhost"), "schoolTest");
	}
	
	@Bean
	public SchoolService service() throws Exception {
		return new SchoolServiceImpl();
	}

}