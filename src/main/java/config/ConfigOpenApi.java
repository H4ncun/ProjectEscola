package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class ConfigOpenApi {

    @Bean
    public OpenAPI ApiEscola() {
        return new OpenAPI()
                .info(new Info().title("API Escola")
                        .description("API desenvolvida para fixação de conhecimento")
                        .version("v1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
