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
@Table(name="TBL_ANSWER")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANSW_ID", nullable = false)
    private Integer id;

    @Column(name = "VICT_ID", nullable = false)
    private Integer victimId;

    @Column(name = "QUES_ID", nullable = false)
    private Integer questionId;

    @Column(name = "ANSW_ANSWER", nullable = false, length = 500)
    private Integer answer;

    @Temporal(TemporalType.DATE)
    @Column(name = "ANSW_CREATE", nullable = false)
    private Date createDate;
}
