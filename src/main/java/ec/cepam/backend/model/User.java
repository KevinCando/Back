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
@Table(name="TBL_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer id;

    @Column(name = "ROLE_ID", nullable = false)
    private Integer roleId;

    @Column(name = "WORK_ID", nullable = false)
    private Integer workId;

    @Column(name = "USER_NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "USER_PASS", nullable = false, length = 50)
    private String pass;

    @Temporal(TemporalType.DATE)
    @Column(name = "USER_CREATE", nullable = false)
    private Date dateCreate;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID", insertable = false, updatable = false, nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "WORK_ID", referencedColumnName = "WORK_ID", nullable = false, insertable = false, updatable = false)
    private Worker worker;
}
