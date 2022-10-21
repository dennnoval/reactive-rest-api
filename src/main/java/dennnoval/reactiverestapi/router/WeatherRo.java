package dennnoval.reactiverestapi.router;

import dennnoval.reactiverestapi.handler.WeatherH;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class WeatherRo {

  @Bean
  public RouterFunction<ServerResponse> weatherRoutes(WeatherH wh) {
    return RouterFunctions
        .route(GET("/{location}").and(accept(MediaType.APPLICATION_JSON)), wh::getStatus)
        .andRoute(GET("/{location}/updateTemp").and(accept(MediaType.APPLICATION_JSON)), wh::updateTemp)
        .andRoute(GET("/{location}/updatePrecipitation").and(accept(MediaType.APPLICATION_JSON)), wh::updatePrecipitation)
        .andRoute(GET("/{location}/updateHumidity").and(accept(MediaType.APPLICATION_JSON)), wh::updateHumidity)
        .andRoute(GET("/{location}/updateWind").and(accept(MediaType.APPLICATION_JSON)), wh::updateWind);
  }

}
