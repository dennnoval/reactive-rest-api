package dennnoval.reactiverestapi.service;

import dennnoval.reactiverestapi.entity.Weather;
import dennnoval.reactiverestapi.repository.WeatherR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class WeatherS {

  @Autowired
  private WeatherR wr;

  private float rand() {
    int min = 1, max = 100;
    return (float) (min + Math.random() * (max - min));
  }

  public Mono<Weather> getStatus(String location) {
    Mono<Weather> mw = wr.findByLocation(location);
    return mw.flatMap(w -> {
      w.setTemperature((int) rand());
      w.setPrecipitation(rand());
      w.setHumidity(rand());
      w.setWind(rand());
      return wr.save(w);
    }).log();
  }

  public Mono<Weather> updateTemp(String location) {
    int min = 1, max = 100;
    int rand = (int) (min + Math.random() * (max - min));
    return wr.findByLocation(location)
        .flatMap(w -> {
          w.setTemperature(rand);
          return wr.save(w);
        })
        .log();
  }

  public Mono<Weather> updatePrecipitation(String location) {
    int min = 1, max = 100;
    float rand2 = (float) (min + Math.random() * (max - min));
    return wr.findByLocation(location)
        .flatMap(w -> {
          w.setPrecipitation(rand2);
          return wr.save(w);
        })
        .log();
  }

  public Mono<Weather> updateHumidity(String location) {
    int min = 1, max = 100;
    float rand2 = (float) (min + Math.random() * (max - min));
    return wr.findByLocation(location)
        .flatMap(w -> {
          w.setHumidity(rand2);
          return wr.save(w);
        })
        .log();
  }

  public Mono<Weather> updateWind(String location) {
    int min = 1, max = 100;
    float rand2 = (float) (min + Math.random() * (max - min));
    return wr.findByLocation(location)
        .flatMap(w -> {
          w.setWind(rand2);
          return wr.save(w);
        })
        .log();
  }

}
