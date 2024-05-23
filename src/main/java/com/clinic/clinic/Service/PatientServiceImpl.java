package com.clinic.clinic.Service;

import com.clinic.clinic.DAO.DoctorPaginatedRepo;
import com.clinic.clinic.DAO.PatientPaginatedRepo;
import com.clinic.clinic.DAO.PatientRepository;
import com.clinic.clinic.Entity.Doctor;
import com.clinic.clinic.Entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;
    private final PatientPaginatedRepo patientPaginatedRepo;

    public PatientServiceImpl(PatientRepository patientRepository, PatientPaginatedRepo patientPaginatedRepo) {
        this.patientRepository = patientRepository;
        this.patientPaginatedRepo = patientPaginatedRepo;
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findById(Long id) {
        Optional<Patient> result = patientRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }


    @Override
    public Page<Patient> getAllPaginated(int page, int size) {
        return patientPaginatedRepo.findAll(PageRequest.of(page, size));
    }
}
