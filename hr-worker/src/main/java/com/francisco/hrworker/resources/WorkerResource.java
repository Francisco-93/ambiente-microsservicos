package com.francisco.hrworker.resources;

import com.francisco.hrworker.entities.Worker;
import com.francisco.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    private WorkerRepository repository;
    private Environment env;

    public WorkerResource(WorkerRepository repository, Environment env) {
        this.repository = repository;
        this.env = env;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        logger.info("PORT = " + env.getProperty("local.server.port"));

        Worker obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }

}
