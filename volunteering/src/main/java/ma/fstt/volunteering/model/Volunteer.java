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
@Table(name="volunteer")
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "agence")
    private String agence;

    @Column(name = "role")
    private String role;

    @Column(name = "phone")
    private Long phone;

//    @JsonManagedReference
    @ManyToMany(mappedBy = "volunteers", cascade = CascadeType.ALL)
    private List<Distribution> distributions;

}
