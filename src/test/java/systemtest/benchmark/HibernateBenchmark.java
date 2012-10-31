package systemtest.benchmark;

import systemtest.benchmark.model1.Worker;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernateBenchmark {

    public static void main(String[] args) {
//        EntityManager entityManager = Persistence.createEntityManagerFactory("hibernate").createEntityManager();
        EntityManager entityManager = Persistence.createEntityManagerFactory("objectdb").createEntityManager();

        Worker x = new Worker();
        x.setName("adam");

        entityManager.getTransaction().begin();

        entityManager.persist(x);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
