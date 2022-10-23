package co.com.user.taskusers.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "rows")
public class Row {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "duration")
    private Long duration;

    @JsonManagedReference
    @OneToOne(mappedBy = "row", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Task task;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

}
