package ma.fstt.volunteering.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="distribution")
public class Distribution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "departure_city")
    private String departureCity;

    @Column(name = "vehicle")
    private String vehicle;

    @Column(name = "city")
    private String city;

//    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "volunteer_distribution",
            joinColumns = @JoinColumn(name = "distribution_id"),
            inverseJoinColumns = @JoinColumn(name = "volunteer_id")
    )
    private List<Volunteer> volunteers;

    @ElementCollection
    @CollectionTable(
            name = "distribution_item_ids",
            joinColumns = @JoinColumn(name = "distribution_id")
    )
    @Column(name = "item_id")
    private List<Long> itemIds;

}
