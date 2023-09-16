package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "grant_access")
public class GrantAccess {
    @Id
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @Column(name = "is_grant",columnDefinition = "enum('1','0', '-1')",nullable = false)
    @ColumnDefault("1")
    private Grant isGrant;
    @Column(columnDefinition = "varchar(250)")
    @ColumnDefault("''")
    private String note;

    public GrantAccess() {
    }

    public GrantAccess(Account account) {
        this.account = account;
    }

    public GrantAccess(Account account, Role role, Grant isGrant, String note) {
        this.account = account;
        this.role = role;
        this.isGrant = isGrant;
        this.note = note;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Grant getIsGrant() {
        return isGrant;
    }

    public void setIsGrant(Grant isGrant) {
        this.isGrant = isGrant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "accountId='" + account + '\'' +
                ", roleId='" + role + '\'' +
                ", isGrant=" + isGrant +
                ", note='" + note + '\'' +
                '}';
    }
}
