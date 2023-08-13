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
public class FormQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUES_ID", nullable = false)
    private Integer id;

    @Column(name = "SECT_ID", nullable = false)
    private Integer sectionId;

    @Column(name = "QUES_QUESTION", nullable = false, length = 100)
    private String question;

    @Column(name = "QUES_TYPE", nullable = false, length = 3)
    private String type;

}