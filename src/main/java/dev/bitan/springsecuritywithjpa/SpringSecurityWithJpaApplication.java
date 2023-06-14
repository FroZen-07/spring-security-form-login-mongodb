package dev.bitan.springsecuritywithjpa;

import dev.bitan.springsecuritywithjpa.model.User;
import dev.bitan.springsecuritywithjpa.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityWithJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityWithJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			userRepository.save(new User("user",
					passwordEncoder.encode("password"), "ROLE_USER"));
			userRepository.save(new User("admin",
					passwordEncoder.encode("password"), "ROLE_ADMIN"));
		};
	}
}
