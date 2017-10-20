package com.example.myspringreactive;

/**
 * Created by kudaram on 13-10-2017.
 */
@org.springframework.stereotype.Service
public class FluxFlexService {

    private final com.example.myspringreactive.MovieRepository movieRepository;

    public reactor.core.publisher.Flux<com.example.myspringreactive.MovieEvent> streamStreams(Movie movie){


        reactor.core.publisher.Flux<Long> interaval= reactor.core.publisher.Flux.interval(java.time.Duration
                .ofSeconds(1));

        reactor.core.publisher.Flux<MovieEvent> evnts= reactor.core.publisher.Flux
                .fromStream(java.util.stream.Stream.generate(()-> new MovieEvent(movie,randomUser(),new java.util.Date())));

return reactor.core.publisher.Flux.zip(interaval,evnts).map(reactor.util.function.Tuple2::getT2);

        /*return reactor.core.publisher.Flux.<MovieEvent>generate(sink -> sink.next(new MovieEvent(movie,randomUser(), new java.util.Date())))
                .delayElements(java.time.Duration.ofSeconds(1));*/

    }

    public String randomUser(){

        String[] users="Chary, ramaba".split(",");
        return  users[new java.util.Random().nextInt(users.length)];
    }

    public reactor.core.publisher.Mono<com.example.myspringreactive.Movie> byId(String id){

        return movieRepository.findById(id);
    }
    public reactor.core.publisher.Flux<com.example.myspringreactive.Movie> all(){

       return movieRepository.findAll();
    }



    public FluxFlexService(com.example.myspringreactive.MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
}
