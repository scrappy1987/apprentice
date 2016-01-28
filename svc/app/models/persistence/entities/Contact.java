package models.persistence.entities;

import javax.persistence.*;

@Table(name = "dbo.T_CONTACTS")
@Entity
public class Contact
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "functionalOrg", nullable = false)
    private FunctionalOrganisation functionalOrg;

    @Column(name = "employeeNo", nullable = false)
    private String employeeNo;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "middleName", nullable = false)
    private String middleName;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "email", nullable = false)
    private String email;
}
