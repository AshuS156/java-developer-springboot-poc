package com.javatechie.batch.controller;

import org.slf4j.Logger;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController{

    Logger logger = org.slf4j.LoggerFactory.getLogger(PersonController.class);

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @GetMapping("/importdata")
    public String uploadDataIntoSQL() {
        logger.info("Received request to start batch job for importing data into SQL");
        final JobParameters jobParameter = new JobParametersBuilder()
                                        .addLong("startAt",System.currentTimeMillis())
                                        .toJobParameters();
        logger.info("Job parameters created with start time: {}", jobParameter.getLong("startAt"));
            JobExecution jobExecution = null;
            try {
                jobExecution = jobLauncher.run(this.job,jobParameter);
            } catch (JobExecutionAlreadyRunningException | JobRestartException |JobInstanceAlreadyCompleteException
                     | JobParametersInvalidException e) {
                logger.error("Error occurred while launching the job: {}", e.getMessage());
            }
               return jobExecution.getStatus().toString();
        }
}
