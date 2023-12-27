package ma.fstt.donation.model;


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

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone", unique = true)
    private Long phone;

    @OneToMany(mappedBy = "donator", cascade = CascadeType.ALL)
    private List<Item> itemList;

}