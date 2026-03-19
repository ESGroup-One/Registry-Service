package bt.edu.gcit.registryservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "rub_student_registry")
public class StudentRegistry {
    @Id
    private String id;
    private String indexNumber;
    private String cid;
    private String fullName;
    private String email;
    
    private AcademicMarks academicMarks;

    @Data
    public static class AcademicMarks {
        private String stream;
        private Double english;
        private Double dzongkha;
        private Double math;
        private Double biology;
        private Double physics;
        private Double chemistry;
        private Double history;
        private Double geography;
        private Double commerce;
        private Double economics;
    }
}