package nccu.orm;

import nccu.orm.entity.Department;
import nccu.orm.entity.Employee;
import nccu.orm.repository.DepartmentRepository;
import nccu.orm.repository.EmployeeRepository;

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
                    DepartmentRepository departmentRepository = new DepartmentRepository(em);
                    EmployeeRepository employeeRepository = new EmployeeRepository(em);

                    // List<Department> departments = departmentRepository.findAll();
                    // System.out.println("All departments in Company database:");
                    // departments.forEach(System.out::println);

                    Department research = departmentRepository.findById(5);
                    System.out.println("\nDepartment with dnumber=5:");
                    System.out.println(research != null ? research : "No record found");

                    List<Employee> employees = employeeRepository.findAll();
                    System.out.println("\nAll employees in Company database:");
                    employees.forEach(System.out::println);

                    //System.out.println(research.getManager().getSsn());
                }
            }
        } catch (Exception ex) {
            System.err.println("Failed to start ORM demo. Check MySQL credentials in src/main/resources/META-INF/persistence.xml.");
            ex.printStackTrace();
        }
    }
}
