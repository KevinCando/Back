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
@Table(name="TBL_VICTIM")
public class Victim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VICT_ID")
    private Integer id;

    @Column(name = "VICT_NAMES", length = 100)
    private String names;

    @Column(name = "VICT_SURNAMES", length = 100)
    private String surnames;

    @Column(name = "VICT_AGE", length = 100)
    private String age;

    @Temporal(TemporalType.DATE)
    @Column(name = "VICT_BIRTHDATE")
    private Date birthdate;

    @Column(name = "VICT_GENDER", length = 3)
    private String gender;

    @Column(name = "VICT_GENDER_IDENTITY", length = 100)
    private String identity;

    @Column(name = "VICT_CI", length = 100)
    private String cedula;

    @Column(name = "VICT_NATIONALITY", length = 100)
    private String nationality;

    @Column(name = "VICT_MIGRATION_STATUS", length = 100)
    private String migrationStatus;

    @Column(name = "VICT_ADDRESS", length = 100)
    private String address;

    @Column(name = "VICT_LOCATION", length = 100)
    private String location;

    @Column(name = "VICT_PROVINCE", length = 100)
    private String province;

    @Column(name = "VICT_ADDRESS_WORK", length = 100)
    private String addressWork;

}
