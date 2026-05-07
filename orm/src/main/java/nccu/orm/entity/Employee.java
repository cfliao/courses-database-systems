package nccu.orm.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "ssn", columnDefinition = "CHAR(9)")
    private String ssn;

    @Column(name = "fname")
    private String fname;

    @Column(name = "minit")
    private String minit;

    @Column(name = "lname")
    private String lname;

    @Column(name = "bdate")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @ManyToOne
    @JoinColumn(name = "dno", referencedColumnName = "dnumber")
    private Department department;

    @Column(name = "address")
    private String address;

    @Column(name = "sex", columnDefinition = "CHAR(1)")
    private String gender;

    @Column(name = "salary", precision = 10, scale = 2)
    private BigDecimal salary;

    @Column(name = "superssn", columnDefinition = "CHAR(9)")
    private String superssn;

    public Employee() {
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMinit() {
        return minit;
    }

    public void setMinit(String minit) {
        this.minit = minit;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date bdate) {
        this.birthday = bdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String sex) {
        this.gender = sex;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getSuperssn() {
        return superssn;
    }

    public void setSuperssn(String superssn) {
        this.superssn = superssn;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ssn='" + ssn + '\'' +
                ", fname='" + fname + '\'' +
                ", minit='" + minit + '\'' +
                ", lname='" + lname + '\'' +
                ", bdate=" + birthday +
                ", address='" + address + '\'' +
                ", sex='" + gender + '\'' +
                ", salary=" + salary +
                ", superssn='" + superssn + '\'' + 
                ", department='" + department.getName() + '\'' + 
                '}';
    }
}
