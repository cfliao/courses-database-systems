package nccu.orm.repository;

import java.util.List;

import jakarta.persistence.EntityManager;

import nccu.orm.entity.Employee;

public class EmployeeRepository {
    private final EntityManager entityManager;

    public EmployeeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Employee> findAll() {
        return entityManager
                .createQuery("SELECT e FROM Employee e ORDER BY e.ssn", Employee.class)
                .getResultList();
    }

    public Employee findById(String ssn) {
        return entityManager.find(Employee.class, ssn);
    }
}