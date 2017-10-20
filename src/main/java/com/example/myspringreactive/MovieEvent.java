package com.example.myspringreactive;

/**
 * Created by kudaram on 12-10-2017.
 */

@lombok.ToString
@lombok.NoArgsConstructor
@lombok.Data
@lombok.AllArgsConstructor
public class MovieEvent {


    private Movie movie;

    private String username;

    private java.util.Date when;

}
