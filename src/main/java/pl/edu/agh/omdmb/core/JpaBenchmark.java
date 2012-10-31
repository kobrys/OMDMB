package pl.edu.agh.omdmb.core;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.agh.omdmb.configuration.benchmark.model.BenchmarkConfiguration;

import javax.persistence.EntityManager;

public class JpaBenchmark {

    @Autowired private EntityManager entityManager;
    @Autowired private BenchmarkConfiguration benchmarkConfiguration;
}
