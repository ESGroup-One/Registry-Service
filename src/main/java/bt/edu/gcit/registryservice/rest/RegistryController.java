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

    @GetMapping("/ping")
    public String ping() {
        return "Registry Service is ALIVE on port 8084!";
    }

    @PostMapping("/seed")
    public ResponseEntity<?> seedData(@RequestBody StudentRegistry student) { // Added @RequestBody
        try {
            StudentRegistry savedStudent = registryService.seed(student);
            return ResponseEntity.ok(savedStudent);
        } catch (Exception e) {
            System.err.println("DATABASE ERROR: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    // Endpoint for Auth Service to check existence
    @GetMapping("/validate/{indexNumber}")
    public ResponseEntity<?> checkStudent(@PathVariable String indexNumber) {
        return registryService.verifyStudent(indexNumber)
                .map(student -> ResponseEntity.ok(student))
                .orElse(ResponseEntity.notFound().build());
    }
}