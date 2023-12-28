package ma.fstt.donation.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "date_of_donation")
    private LocalDate dateOfDonation;

    @Column(name = "city_donated_to")
    private String cityDonatedTo;

    @ManyToOne
    @JoinColumn(name = "donator_id")
    private Donator donator;

}
