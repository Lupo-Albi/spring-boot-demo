package dev.luanderson;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " not found"));
    }

    public void deleteSoftwareEngineerById(Integer id) {
        softwareEngineerRepository.deleteById(id);
    }

    public SoftwareEngineer updateSoftwareEngineerById(Integer id, SoftwareEngineer softwareEngineerUpdateData) {
        SoftwareEngineer softwareEngineerToUpdate = softwareEngineerRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id + " not found"));
        softwareEngineerToUpdate
                .setName(softwareEngineerUpdateData.getName());
        softwareEngineerToUpdate
                .setTechStack(softwareEngineerUpdateData.getTechStack());
        return softwareEngineerRepository.save(softwareEngineerToUpdate);
    }
}
