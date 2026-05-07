package nccu.orm.repository;

import nccu.orm.entity.Department;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class DepartmentRepository {
    private final EntityManager entityManager;

    public DepartmentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Department> findAll() {
        return entityManager
                .createQuery("SELECT d FROM Department d ORDER BY d.id", Department.class)
                .getResultList();
    }

    public Department findById(int dnumber) {
        return entityManager.find(Department.class, dnumber);
    }

    public Department save(Department department) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            Department merged = entityManager.merge(department);
            tx.commit();
            return merged;
        } catch (RuntimeException ex) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw ex;
        }
    }
}
