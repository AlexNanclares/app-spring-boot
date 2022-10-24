package co.com.user.taskusers.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date_birth")
    private LocalDate dateBirth;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "dependence")
    private String dependence;

    @ElementCollection(targetClass = Profile.class)
    @Column(name = "profile")
    @Enumerated(EnumType.STRING)
    public List<Profile> profile;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Row> rows;



}
