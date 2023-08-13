package ec.cepam.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="TBL_ROLE")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Integer id;

    @Column(name = "AREA_ID", nullable = false)
    private Integer areaId;

    @Column(name = "ROLE_NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "ROLE_DESCRIPTION", length = 100)
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "ROLE_CREATE", nullable = false)
    private Date dateCreate;

    @ManyToOne
    @JoinColumn(name = "AREA_ID", referencedColumnName = "AREA_ID", insertable = false, updatable = false, nullable = false)
    private Area area;

}
