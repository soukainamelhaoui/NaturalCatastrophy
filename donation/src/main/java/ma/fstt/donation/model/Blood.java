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
@Table(name="blood")
public class Blood {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "blood_type")
    private String bloodType;

    @Column(name = "city")
    private String city;

    @Column(name = "agency")
    private String agency;

    @Column(name = "donation_date")
    private LocalDate donationDate;

    @Column(name = "last_donation_date")
    private LocalDate lastDonationDate;

    @Column(name = "donator_username")
    private String donatorUsername;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "donator_id")
    private Donator donator;

}
