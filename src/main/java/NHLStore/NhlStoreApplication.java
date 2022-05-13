package NHLStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import NHLStore.config.StorageProperties;
import NHLStore.service.StorageService;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class NhlStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(NhlStoreApplication.class, args);
	}
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args->{
			storageService.init();
		});
	}
}
