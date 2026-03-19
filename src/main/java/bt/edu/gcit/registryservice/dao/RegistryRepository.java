package bt.edu.gcit.registryservice.dao;

import bt.edu.gcit.registryservice.entity.StudentRegistry;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface RegistryRepository extends MongoRepository<StudentRegistry, String> {
    Optional<StudentRegistry> findByIndexNumber(String indexNumber);
}