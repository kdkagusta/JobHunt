package api.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "jobs")
@AllArgsConstructor
@NoArgsConstructor
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "explanation")
    private String explanation;

    @Column(name = "job_positions")
    private String positions;

    @OneToMany(mappedBy = "jobs")
    private List<JobAdvertisement> jobAdvertisements;
}
