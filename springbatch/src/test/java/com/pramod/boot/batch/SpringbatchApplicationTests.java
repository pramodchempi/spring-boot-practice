package com.pramod.boot.batch;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringbatchApplicationTests {

	@Autowired
	JobLauncher launcher;

	@Autowired
	Job job;

	@Test
	public void testBatch() {
//		JobParameters jobParameters = new JobParametersBuilder().addLong("time",System.currentTimeMillis());
//		launcher.run(job,jobParameters);
	}

}
