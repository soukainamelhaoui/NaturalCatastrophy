package ma.fstt.donation.model;


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
@Table(name="donator")
public class Donator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private Long phone;

    @JsonManagedReference
    @OneToMany(mappedBy = "donator", cascade = CascadeType.ALL)
    private List<Item> itemList;

    @JsonManagedReference
    @OneToMany(mappedBy = "donator", cascade = CascadeType.ALL)
    private List<Money> moneyList;

    @JsonManagedReference
    @OneToMany(mappedBy = "donator", cascade = CascadeType.ALL)
    private List<Blood> bloodList;

}
