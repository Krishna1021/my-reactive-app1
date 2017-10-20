package com.example.myspringreactive;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Created by kudaram on 16-10-2017.
 */

@org.springframework.web.bind.annotation.RestController
public class FluxFlexController {

    public FluxFlexController(com.example.myspringreactive.FluxFlexService fluxFlexService) {
        this.fluxFlexService = fluxFlexService;
    }

    private final com.example.myspringreactive.FluxFlexService fluxFlexService;

@org.springframework.context.annotation.Bean
    org.springframework.web.reactive.function.server.RouterFunction<org.springframework.web.reactive.function.server
            .ServerResponse> charys(com.example.myspringreactive.FluxFlexService fluxFlexService){
    return org.springframework.web.reactive.function.server.RouterFunctions.route(GET("/movies"),
            request-> ok().body(fluxFlexService.all(),Movie.class)).andRoute(GET("/movies/{id}"),request->ok().body
            (fluxFlexService.byId
            (request.pathVariable("id")),Movie.class))
            .andRoute(GET("/movies/{id}/events"), serverRequest ->
                    ok().contentType(org.springframework.http.MediaType.TEXT_EVENT_STREAM)
                    .body(fluxFlexService.byId(serverRequest.pathVariable("id")).flatMapMany(
                            fluxFlexService::streamStreams),MovieEvent.class));

}



    @org.springframework.web.bind.annotation.GetMapping
        public reactor.core.publisher.Flux<com.example.myspringreactive.Movie> all(){
        return fluxFlexService.all();
    }

    @org.springframework.web.bind.annotation.GetMapping("/{id}")
    public reactor.core.publisher.Mono<com.example.myspringreactive.Movie> byId(@org.springframework.web.bind.annotation
            .PathVariable
                                                                                        String id){
        return fluxFlexService.byId(id);
    }

    @org.springframework.web.bind.annotation.GetMapping(value = "/{id}/events", produces = org.springframework.http
            .MediaType.TEXT_EVENT_STREAM_VALUE)
    public reactor.core.publisher.Flux<MovieEvent> events(@org.springframework.web.bind
            .annotation.PathVariable String id){
                return fluxFlexService.byId(id).flatMapMany(fluxFlexService::streamStreams);
    }

}
