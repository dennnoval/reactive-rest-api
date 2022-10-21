package dennnoval.reactiverestapi;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WeatherTests {

  /*@Test
  void updateTemp_Test() {
    WebClient wc = WebClient.builder()
        .baseUrl("http://localhost:8080/api/v1/Jakarta/updateTemp")
        .build();

    wc.get()
        .retrieve()
        .bodyToFlux(Weather.class)
        .subscribe(System.out::println);
  }*/

}
