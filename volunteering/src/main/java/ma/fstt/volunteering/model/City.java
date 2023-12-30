package ma.fstt.volunteering.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Necessity> necessityList;

    @JsonManagedReference
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Distribution> distributionList;

}
