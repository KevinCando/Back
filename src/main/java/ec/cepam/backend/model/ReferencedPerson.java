package ec.cepam.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="TBL_REFERENCE_PERSON")
public class ReferencedPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REFE_ID", nullable = false)
    private Integer id;

    @Column(name = "VICT_ID", nullable = false)
    private Integer victimId;

    @Column(name = "REFE_NAMES", nullable = false, length = 100)
    private String referedNames;

    @Column(name = "REFE_SURNAMES", nullable = false, length = 100)
    private String referedSurnames;

    @Column(name = "REFE_RELATIONSHIP", nullable = false, length = 100)
    private String relation;
}
