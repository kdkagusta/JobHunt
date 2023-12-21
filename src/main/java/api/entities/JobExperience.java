package api.entities;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_experience")
@AllArgsConstructor
@NoArgsConstructor
public class JobExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "position")
    private String position;

    @Column(name = "date_of_start")
    private Date dateOfStart;

    @Column(name = "resignation_date")
    private Date resignationDate;

    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private Cv cv;
}
