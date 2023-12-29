package ma.fstt.volunteering.model;

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

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Necessity> necessityList;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Distribution> distributionList;

}
