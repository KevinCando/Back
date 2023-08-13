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
@Table(name="TBL_FORM_SECTION")
public class FormSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SECT_ID")
    private Integer id;

    @Column(name = "FORM_ID", nullable = false)
    private Integer formId;

    @Column(name = "SECT_NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "SECT_DESCRIPTION", nullable = false, length = 100)
    private String description;
}
