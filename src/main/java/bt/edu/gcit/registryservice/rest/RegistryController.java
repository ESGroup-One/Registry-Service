package bt.edu.gcit.registryservice.rest;

import bt.edu.gcit.registryservice.entity.StudentRegistry;
import bt.edu.gcit.registryservice.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registry")
public class RegistryController {

    @Autowired
    private RegistryService registryService;

    // API to put student mock data in DB
    @PostMapping("/seed")
    public ResponseEntity<StudentRegistry> seedStudent(@RequestBody StudentRegistry student) {
        return ResponseEntity.ok(registryService.addMockStudent(student));
    }

    // Endpoint for Auth Service to check existence
    @GetMapping("/validate/{indexNumber}")
    public ResponseEntity<?> checkStudent(@PathVariable String indexNumber) {
        return registryService.verifyStudent(indexNumber)
                .map(student -> ResponseEntity.ok(student))
                .orElse(ResponseEntity.notFound().build());
    }
}