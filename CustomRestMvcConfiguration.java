import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
class CustomRestMvcConfiguration {

  @Bean
  public RepositoryRestConfigurer repositoryRestConfigurer() {
    return new RepositoryRestConfigurerAdapter() {
      @Override
      public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
          config.setBasePath("/api");
//          config.setDefaultMediaType(MediaType.APPLICATION_JSON_UTF8);
          config.setDefaultPageSize(5);
          config.setPageParamName("pageNo");
          config.setLimitParamName("pageSize");
          config.findRepositoryMappingForPath("com.xiu.decimal.demo.repository");
        }
    };
  }
}