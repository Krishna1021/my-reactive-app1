package com.example.myspringreactive;

/**
 * Created by kudaram on 12-10-2017.
 */
public interface MovieRepository extends org.springframework.data.mongodb.repository.ReactiveMongoRepository<Movie,
String> {


}
