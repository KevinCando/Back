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
@Table(name="TBL_FORM")
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FORM_ID")
    private Integer id;

    @Column(name = "AREA_ID",  nullable = false, updatable = false)
    private Integer areaId;

    @Column(name="FORM_NAME", nullable = false, length = 100)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "FORM_CREATE", nullable = false)
    private Date create;

    @Column(name = "FORM_CODE", length = 100)
    private String code;

    @Temporal(TemporalType.DATE)
    @Column(name = "FORM_UPDATE", nullable = false)
    private Date update;

    @Version
    @Column(name = "FORM_VERSION", nullable = false)
    private Long version;
}
