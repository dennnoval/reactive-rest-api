package dennnoval.reactiverestapi.handler;

import dennnoval.reactiverestapi.entity.Weather;
import dennnoval.reactiverestapi.service.WeatherS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class WeatherH {

  @Autowired
  private WeatherS ws;

  public Mono<ServerResponse> getStatus(ServerRequest req) {
    String loc = req.pathVariable("location");
    Flux<Weather> fw = Flux.from(ws.getStatus(loc))
        .delayElements(Duration.ofSeconds(1))
        .repeat();
    return ServerResponse.ok()
        .contentType(MediaType.TEXT_EVENT_STREAM)
        .body(BodyInserters.fromProducer(fw, Weather.class));
  }

  public Mono<ServerResponse> updateTemp(ServerRequest req) {
    String loc = req.pathVariable("location");
    Mono<Weather> wm = ws.updateTemp(loc);
    return wm.flatMap(w ->
        ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(w))
    );
  }

  public Mono<ServerResponse> updatePrecipitation(ServerRequest req) {
    String loc = req.pathVariable("location");
    Mono<Weather> wm = ws.updatePrecipitation(loc);
    return wm.flatMap(w ->
        ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(w))
    );
  }

  public Mono<ServerResponse> updateHumidity(ServerRequest req) {
    String loc = req.pathVariable("location");
    Mono<Weather> wm = ws.updateHumidity(loc);
    return wm.flatMap(w ->
        ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(w))
    );
  }

  public Mono<ServerResponse> updateWind(ServerRequest req) {
    String loc = req.pathVariable("location");
    Mono<Weather> wm = ws.updateWind(loc);
    return wm.flatMap(w ->
        ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(w))
    );
  }

}
