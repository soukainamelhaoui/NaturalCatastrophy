package ma.fstt.donation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "type")
    private String type;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "is_available")
    private Boolean isAvailable = true;

    @Column(name = "donator_username")
    private String donatorUsername;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "donator_id")
    private Donator donator;

}
