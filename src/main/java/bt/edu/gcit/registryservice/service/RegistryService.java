package bt.edu.gcit.registryservice.service;

import bt.edu.gcit.registryservice.dao.RegistryRepository;
import bt.edu.gcit.registryservice.entity.StudentRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistryService {

    @Autowired
    private RegistryRepository repository;

    public StudentRegistry addMockStudent(StudentRegistry student) {
        return repository.save(student);
    }

    public Optional<StudentRegistry> verifyStudent(String indexNumber) {
        return repository.findByIndexNumber(indexNumber);
    }
}