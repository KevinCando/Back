package ec.cepam.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="TBL_WORKER")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WORK_ID")
    private Integer id;

    @Column(name = "AREA_ID",  nullable = false)
    private Integer areaId;

    @Column(name = "WORK_NAMES", nullable = false)
    private String names;

    @Column(name = "WORK_SURNAMES", nullable = false)
    private String surnames;

    @Temporal(TemporalType.DATE)
    @Column(name = "WORK_INITIAL_DATE", nullable = false)
    private Date initialDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "WORK_END_DATE")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "AREA_ID", referencedColumnName = "AREA_ID", nullable = false, updatable = false, insertable = false)
    private Area area;
}
