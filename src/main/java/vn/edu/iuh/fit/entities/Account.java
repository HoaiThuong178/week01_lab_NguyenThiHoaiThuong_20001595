package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "account_id",columnDefinition = "varchar(50)",nullable = false)
    private String accountId;
    @Column(name = "full_name",columnDefinition = "varchar(50)",nullable = false)
    private String fullName;
    @Column(columnDefinition = "varchar(50)",nullable = false)
    private String password;
    @Column(columnDefinition = "varchar(50)")
    @ColumnDefault("''")
    private String email;
    @Column(columnDefinition = "varchar(50)")
    @ColumnDefault("''")
    private String phone;
    @Column(columnDefinition = "tinyint(4)",nullable = false)
    @ColumnDefault("1")
    private Status status;
    @OneToMany(mappedBy = "accountId")
    private List<GrantAccess> grantAccesses;

    public Account() {
    }

    public Account(String accountId) {
        this.accountId = accountId;
    }

    public Account(String accountId, String fullName, String password, String email, String phone, Status status) {
        this.accountId = accountId;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Status getStatus() {
        return status;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }

}
