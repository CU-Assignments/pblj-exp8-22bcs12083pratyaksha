@Configuration
@ComponentScan(basePackages = "your.package")
@EnableTransactionManagement
public class AppConfig {
    @Bean
    public SessionFactory sessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    @Bean
    public PlatformTransactionManager txManager(SessionFactory factory) {
        return new HibernateTransactionManager(factory);
    }
}

