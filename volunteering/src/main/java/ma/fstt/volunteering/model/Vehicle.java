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
@Table(name="vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "size")
    private String size;

    @Column(name = "availability")
    private Boolean availability;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Distribution> distributionList;

}
