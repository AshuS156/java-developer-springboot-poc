package com.javatechie.batch.config;

import com.javatechie.batch.model.Person;
import com.javatechie.batch.repository.PersonRepository;
import org.slf4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
//@EnableBatchProcessing
public class BatchConfig{

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(BatchConfig.class);
    @Autowired
    private PersonRepository personRepository;

    @Bean
    public Job job(JobRepository jobRepository,Step step){
        logger.info("Creating job with name 'importPersons'");
        return new JobBuilder("importPersons",jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public Step step(JobRepository jobRepository,PlatformTransactionManager transactionManager){
        logger.info("Creating step with name 'csv-import-step'");
        return new StepBuilder("csv-import-step",jobRepository)
                .<Person, Person>chunk(10,transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public FlatFileItemReader<Person> reader(){
        logger.info("Creating FlatFileItemReader for reading CSV file");
        return new FlatFileItemReaderBuilder<Person>()
                .name("personItemReader")
                .resource(new ClassPathResource("people-1000.csv"))
                .linesToSkip(1)
                .lineMapper(lineMapper())
                .targetType(Person.class)
                .build();
    }

    private LineMapper<Person> lineMapper(){
        logger.info("Creating LineMapper for mapping CSV lines to Person objects");
        DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id","userId","firstName","lastName","gender","email","phone","dateOfBirth","jobTitle");

        BeanWrapperFieldSetMapper<Person> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Person.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        logger.info("LineMapper created successfully");
        return lineMapper;
    }

    @Bean
    PersonProcessor processor(){
        logger.info("Creating PersonProcessor for processing Person objects");
        return new PersonProcessor();
    }

    @Bean
    RepositoryItemWriter<Person> writer(){
        logger.info("Creating RepositoryItemWriter for writing Person objects to the database");
        RepositoryItemWriter<Person> writer = new RepositoryItemWriter<>();
        writer.setRepository(personRepository);
        writer.setMethodName("save");
        return writer;
    }



}
