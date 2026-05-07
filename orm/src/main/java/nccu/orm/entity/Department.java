package nccu.orm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Department")
public class Department {
    @Id
    @Column(name = "dnumber", nullable = false)
    private Integer dnumber;

    @Column(name = "dname", nullable = false, length = 25)
    private String dname;

    @Column(name = "mgrssn", nullable = false, columnDefinition = "char(9)")
    private String mgrssn;

    @Column(name = "mgrstartdate")
    private LocalDate mgrstartdate;

    public Department() {
    }

    public Department(Integer dnumber, String dname, String mgrssn, LocalDate mgrstartdate) {
        this.dnumber = dnumber;
        this.dname = dname;
        this.mgrssn = mgrssn;
        this.mgrstartdate = mgrstartdate;
    }

    public Integer getDnumber() {
        return dnumber;
    }

    public void setDnumber(Integer dnumber) {
        this.dnumber = dnumber;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getMgrssn() {
        return mgrssn;
    }

    public void setMgrssn(String mgrssn) {
        this.mgrssn = mgrssn;
    }

    public LocalDate getMgrstartdate() {
        return mgrstartdate;
    }

    public void setMgrstartdate(LocalDate mgrstartdate) {
        this.mgrstartdate = mgrstartdate;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dnumber=" + dnumber +
                ", dname='" + dname + '\'' +
                ", mgrssn='" + mgrssn + '\'' +
                ", mgrstartdate=" + mgrstartdate +
                '}';
    }
}
