package pl.edu.agh.omdmb.scenario;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BenchmarkScenarioTest {

//    @Spy BenchmarkScenario benchmarkScenarioSpy;
//    @Mock EntityManagerRegistry entityManagerRegistry;
//    @Mock BenchmarkConfigurationLoader benchmarkConfigurationLoader;
////    @Mock  benchmarkConfiguration;
//    @Mock EntityManagerBuilder entityManagerBuilder;
//    @Mock HibernateEntityManagerProvider hibernateEntityManagerProvider;
//    @Mock EntityManager entityManager;
//
//    BenchmarkScenario benchmarkScenario;
//
//    @Before
//    public void setUp() {
////        benchmarkScenario = new BenchmarkScenario();
//    }
//
//    @Test
//    public void executeAllStages() {
//        //when
////        benchmarkScenarioSpy.run();
////
////        verify(benchmarkScenarioSpy).loadConfiguration();
////
////        verify(benchmarkScenarioSpy).createEnvironment();
//    }
//
//    @Test
//    public void loadConfiguration() {
//        //given
//        benchmarkScenario.setConfigurationLoader(benchmarkConfigurationLoader);
////        when(benchmarkConfigurationLoader.load()).thenReturn(benchmarkConfiguration);
//
//        //when
//        benchmarkScenario.loadConfiguration();
//
//        //then
//        assertEquals(benchmarkConfiguration, benchmarkScenario.getBenchmarkConfiguration());
//    }
//
//    @Test
//    public void createEnvironment() {
//        //given
//        benchmarkScenario.setConfigurationLoader(benchmarkConfigurationLoader);
//        benchmarkScenario.setEntityManagerRegistry(entityManagerRegistry);
//        benchmarkScenario.setEntityManagerBuilder(entityManagerBuilder);
////        when(benchmarkConfigurationLoader.load()).thenReturn(benchmarkConfiguration);
//        when(benchmarkConfiguration.getPersistenceUnitsConfiguration()).thenReturn(preparePersistenceConfiguration());
//        when(entityManagerBuilder.createEntityManagerProvider(eq(HIBERNATE), any(PersistenceUnitConfiguration.class))).
//                thenReturn(hibernateEntityManagerProvider);
//        when(hibernateEntityManagerProvider.getEntityManager()).thenReturn(entityManager);
//
//        //when
//        benchmarkScenario.loadConfiguration();
//        benchmarkScenario.createEnvironment(entityManagerProviderTypePropertiesMap, scenario.getConfiguredClasses());
//
//        //then
//        verify(hibernateEntityManagerProvider).getEntityManager();
//        verify(entityManagerRegistry).register(HIBERNATE, entityManager);
//    }
//
//    private Map<EntityManagerProviderType, PersistenceUnitConfiguration> preparePersistenceConfiguration() {
//        Properties properties = mock(Properties.class);
//        List<Class<?>> annotatedClasses = new LinkedList<Class<?>>();
//
//        Map<EntityManagerProviderType, PersistenceUnitConfiguration> persistenceConfiguration =
//                new HashMap<EntityManagerProviderType, PersistenceUnitConfiguration>();
//
//        persistenceConfiguration.put(HIBERNATE, new HibernateConfiguration(properties, annotatedClasses));
//
//        return persistenceConfiguration;
//    }
//
}
