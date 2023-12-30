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
@Table(name="money")
public class Money {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "date_of_donation")
    private LocalDate dateOfDonation;

    @ManyToOne
    @JoinColumn(name = "donator_id")
    private Donator donator;

}
