package ma.fstt.volunteering.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "agence")
    private String agence;

    @Column(name = "role")
    private String role;

    @Column(name = "phone", unique = true)
    private Long phone;

//    @JsonManagedReference
    @ManyToMany(mappedBy = "volunteers", cascade = CascadeType.ALL)
    private List<Distribution> distributions;

}
