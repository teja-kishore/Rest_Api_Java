package com.example.demo;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentDetailsController {
    private final StudentDetailsRepository repository;

    StudentDetailsController(StudentDetailsRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/StudentDetails")
    List<StudentDetails> all() {
        return repository.findAll();
    }
    @PostMapping("/StudentDetails")
    StudentDetails newStudentDetails(@RequestBody StudentDetails newStudentDetails) {
        return repository.save(newStudentDetails);
    }
    @PutMapping("/StudentDetails/{id}")
    StudentDetails replaceStudentDetails(@RequestBody StudentDetails newStudentDetails, @PathVariable Long id) {

        return repository.findById(id)
                .map(StudentDetails -> {
                    StudentDetails.setName(newStudentDetails.getName());
                    return repository.save(StudentDetails);
                })
                .orElseGet(() -> {
                    newStudentDetails.setId(id);
                    return repository.save(newStudentDetails);
                });
    }
    @DeleteMapping("/StudentDetails/{id}")
    void deleteStudentDetails(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
