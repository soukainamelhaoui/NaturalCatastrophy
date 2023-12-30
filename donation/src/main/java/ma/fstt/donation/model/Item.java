package ma.fstt.donation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(name = "is_available")
    private Boolean isAvailable = true;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "donator_id")
    private Donator donator;

}
