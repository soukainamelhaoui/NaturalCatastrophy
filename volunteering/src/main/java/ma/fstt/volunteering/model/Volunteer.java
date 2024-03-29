package ma.fstt.volunteering.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(name = "verified")
    private Boolean isVerified = false;

    @JsonBackReference
    @ManyToMany(mappedBy = "volunteers", cascade = CascadeType.ALL)
    private List<Distribution> distributions;

}
