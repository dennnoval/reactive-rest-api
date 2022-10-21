package dennnoval.reactiverestapi.repository;

import dennnoval.reactiverestapi.entity.Weather;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface WeatherR extends R2dbcRepository<Weather, Integer> {

  Mono<Weather> findByLocation(String location);

}
