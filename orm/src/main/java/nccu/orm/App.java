package nccu.orm;

import nccu.orm.entity.Department;
import nccu.orm.repository.DepartmentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("companyPU");

            try (emf) {
                EntityManager em = emf.createEntityManager();
                try (em) {
                    DepartmentRepository repository = new DepartmentRepository(em);

                    List<Department> departments = repository.findAll();
                    System.out.println("All departments in Company database:");
                    departments.forEach(System.out::println);

                    Department research = repository.findById(5);
                    System.out.println("\nDepartment with dnumber=5:");
                    System.out.println(research != null ? research : "No record found");
                }
            }
        } catch (Exception ex) {
            System.err.println("Failed to start ORM demo. Check MySQL credentials in src/main/resources/META-INF/persistence.xml.");
            System.err.println("Current defaults assume: jdbc:mysql://localhost:3306/Company, user=root, password=nccutest.");
            ex.printStackTrace();
        }
    }
}
