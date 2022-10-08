package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new User("Joe", "NY Mets"));
		repository.save(new User("Kevin", "NY Jets"));
		repository.save(new User("Sarma", "Dallas Cowboys"));
		repository.save(new User("Dylan", "Rocket League"));
		repository.save(new User("Gianna", "Dallas Cowboys"));

		Iterable<User> iterator = repository.findAll();

		System.out.println("All users: ");
		iterator.forEach(user -> System.out.println(user));

		List<User> user = repository.findByTeam("Dallas Cowboys");
		System.out.println("\nWho likes the Cowboys?: ");
		user.forEach(user1 -> System.out.println(user1));

		List<User> allUsers = repository.listUsers();
		System.out.println("\nAll users: ");
		allUsers.forEach(user2 -> System.out.println(user2));
	}
}
