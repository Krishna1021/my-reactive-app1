package com.example.myspringreactive;

/**
 * Created by kudaram on 12-10-2017.
 */

@lombok.ToString
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.Data
@org.springframework.data.mongodb.core.mapping.Document
public class Movie {


    @org.springframework.data.annotation.Id
    private String id;


    private String name, title;
}
