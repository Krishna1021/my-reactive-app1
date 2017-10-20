package com.example.myspringreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringReactiveApplication.class, args);
	}


	@org.springframework.context.annotation.Bean
	org.springframework.boot.CommandLineRunner run(com.example.myspringreactive.MovieRepository mr){

		return movies->{
			java.util.stream.Stream.of("My Reactive on plane", "Attack the flux","Y this kolavari", "back to future").
					map(name->new Movie(java.util.UUID.randomUUID().toString(), name,randomGen())).forEach(movie->mr.save
					(movie).subscribe(System.out::println));

		};
	}

	private  String randomGen(){

		String[] general="horror, comody,drama".split(",");
		return  general[new java.util.Random().nextInt(general.length)];
	}
}
