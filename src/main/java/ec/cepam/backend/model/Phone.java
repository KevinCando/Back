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
@Table(name="TBL_PHONE")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PHON_ID", nullable = false)
    private Integer id;

    @Column(name = "REFE_ID")
    private Integer referedId;

    @Column(name = "VICT_ID")
    private Integer victimId;

    @Column(name = "PHON_TYPE", length = 3, nullable = false)
    private Integer type;

    @Column(name = "PHON_NUMBER", length = 100, nullable = false)
    private String number;
}
