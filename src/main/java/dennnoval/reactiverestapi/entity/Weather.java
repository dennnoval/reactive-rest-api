package dennnoval.reactiverestapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Data
public class Weather implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(length = 3)
  private Integer id;
  @Column(name = "temperature", length = 5)
  private int temperature = 0;
  @Column(name = "precipitation", length = 5)
  private float precipitation = 0.0f;
  @Column(name = "humidity", length = 5)
  private float humidity = 0.0f;
  @Column(name = "wind", length = 5)
  private float wind = 0.0f;
  @Column(name = "location", length = 64)
  private String location;

}
