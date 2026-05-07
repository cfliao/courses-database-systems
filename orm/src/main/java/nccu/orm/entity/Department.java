package nccu.orm.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Department {
    @Id
    @Column(name = "dnumber")
    private int id;

    @Column(name = "dname")
    private String name;

    @OneToOne
    @JoinColumn(name = "mgrssn", referencedColumnName = "ssn")
    private Employee manager;

    @Column(name = "mgrstartdate")
    @Temporal(TemporalType.DATE)
    private Date mgrstartdate;

    public Department() {
    }

    public Department(int dnumber, String name, Employee manager, Date mgrstartdate) {
        this.id = dnumber;
        this.name = name;
        this.manager = manager;
        this.mgrstartdate = mgrstartdate;
    }

    public Integer getId() {
        return id;
    }

    public void setDnumber(Integer dnumber) {
        this.id = dnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String dname) {
        this.name = dname;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Date getMgrstartdate() {
        return mgrstartdate;
    }

    public void setMgrstartdate(Date mgrstartdate) {
        this.mgrstartdate = mgrstartdate;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dnumber=" + id +
                ", dname='" + name + '\'' +
                ", manager=" + (manager != null ? manager.getSsn() : null) +
                ", mgrstartdate=" + mgrstartdate +
                '}';
    }
}
