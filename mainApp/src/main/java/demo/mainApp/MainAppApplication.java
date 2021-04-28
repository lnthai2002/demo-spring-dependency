package demo.mainApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"demo.lib1", "demo.lib2", "demo.lib3", "demo.mainApp"})
@EnableJpaRepositories(basePackages = {"demo.lib1", "demo.lib2", "demo.lib3", "demo.mainApp"})
@EntityScan(basePackages = {"demo.lib1", "demo.lib2", "demo.lib3", "demo.mainApp"})
public class MainAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainAppApplication.class, args);
	}

}
