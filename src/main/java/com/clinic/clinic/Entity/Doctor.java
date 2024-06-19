package com.clinic.clinic.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Doctor {
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


    @Column(name = "department")
    private String department;

    @ManyToOne
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Appointment> appointments = new ArrayList<>();

    public Doctor() {
    }

    public Doctor(String firstName, String lastName, String email, String phone, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.department = department;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
