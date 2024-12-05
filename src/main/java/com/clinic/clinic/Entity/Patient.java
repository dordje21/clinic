package com.clinic.clinic.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patients")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    @NotNull(message = "is required")
    @Size(min=1,message = "is required")
    private String firstName;

    @Column(name = "lastName")
    @NotNull(message = "is required")
    @Size(min=1,message = "is required")
    private String lastName;

    @Column(name = "email")
    @NotNull(message = "Email is mandatory")
    @Email(message = "Email must be a valid format (e.g. user@example.com)")

    private String email;

    @Column(name = "phone")
    @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 characters long")
    @Pattern(
            regexp = "^\\+?[0-9]{10,15}$",
            message = "Phone number must contain only digits and may start with a plus sign"
    )
    private String phone;

    @Column(name = "birthday")
    @NotNull(message = "Birth date is mandatory")
    @Past(message = "Birth date must be in the past")

    private Date birthday;

    @ManyToOne
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Appointment> appointments = new ArrayList<>();


    public Patient(){
    }

    public Patient(String firstName, String lastName, String email, String phone, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void add(Patient patient) {
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
