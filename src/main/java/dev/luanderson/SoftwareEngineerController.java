package dev.luanderson;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 It's not recommended to expose entities directly in methods, as this may leak sensitive data.
 In a real application, we would create DTOs (Data Transfer Objects) to send and receive only the required properties.
 Since this project is for study purposes, I haven't implemented DTOs at this time.
*/

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @GetMapping("{id}")
    public SoftwareEngineer getSoftwareEngineerById(@PathVariable Integer id) {
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

    @PostMapping
    public void addNewSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    // TODO: implement the feature to delete software engineer by id

    // TODO: implement the feature to update software engineer by id
}
