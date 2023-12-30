package ma.fstt.volunteering.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "departure_city")
    private String departureCity;

    @Column(name = "vehicle")
    private String vehicle;

//    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "volunteer_distribution",
            joinColumns = @JoinColumn(name = "distribution_id"),
            inverseJoinColumns = @JoinColumn(name = "volunteer_id")
    )
    private List<Volunteer> volunteers;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ElementCollection
    @CollectionTable(
            name = "distribution_item_ids",
            joinColumns = @JoinColumn(name = "distribution_id")
    )
    @Column(name = "item_id")
    private List<Long> itemIds;

}
