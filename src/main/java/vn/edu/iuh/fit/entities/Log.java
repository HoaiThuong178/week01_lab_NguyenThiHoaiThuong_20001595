package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Table(name = "log")
public class Log {
    @Id
    @Column(name = "id",columnDefinition = "bigint(20)",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "account_id",columnDefinition = "varchar(50)",nullable = false)
    private String accountId;
    @Column(name = "login_time",columnDefinition = "datetime",nullable = false)
    @ColumnDefault("current_timestamp()")
    private LocalDateTime loginTime;
    @Column(name = "logout_time",columnDefinition = "datetime",nullable = false)
    @ColumnDefault("current_timestamp()")
    private LocalDateTime logoutTime;
    @Column(name = "notes",columnDefinition = "varchar(250)",nullable = false)
    @ColumnDefault("''")

    private String notes;

    public Log() {
    }

    public Log(long id) {
        this.id = id;
    }

    public Log(long id, String accountId, LocalDateTime loginTime, LocalDateTime logoutTime, String notes) {
        this.id = id;
        this.accountId = accountId;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.notes = notes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public LocalDateTime getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(LocalDateTime logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", loginTime=" + loginTime +
                ", logoutTime=" + logoutTime +
                ", notes='" + notes + '\'' +
                '}';
    }
}
