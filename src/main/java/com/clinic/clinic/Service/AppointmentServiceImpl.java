package com.clinic.clinic.Service;

import com.clinic.clinic.DAO.AppointmentPaginatedRepo;
import com.clinic.clinic.DAO.AppointmentRepository;
import com.clinic.clinic.Entity.Appointment;
import com.clinic.clinic.Entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    private final AppointmentRepository appointmentRepository;

    private final AppointmentPaginatedRepo aAppointmentPaginatedRepo;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, AppointmentPaginatedRepo aAppointmentPaginatedRepo) {
        this.appointmentRepository = appointmentRepository;
        this.aAppointmentPaginatedRepo = aAppointmentPaginatedRepo;
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment findById(Long id) {
        Optional<Appointment> result = appointmentRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public Page<Appointment> getAllPaginated(int page, int size) {
        return aAppointmentPaginatedRepo.findAll(PageRequest.of(page, size));
    }
}
