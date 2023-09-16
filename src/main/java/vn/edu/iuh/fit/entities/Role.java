package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
@Table(name="role")
public class Role {
    @Id
    @Column(name = "role_id",columnDefinition = "varchar(50)",nullable = false)
    private String roleId;
    @Column(name = "role_name",columnDefinition = "varchar(50)",nullable = false)
    private String roleName;
    @Column(columnDefinition = "varchar(50)")
    @ColumnDefault("''")
    private String decription;
    @Column(columnDefinition = "tinyint(4)",nullable = false)
    private Status status;
    @OneToMany(mappedBy = "roleId")
    private List<GrantAccess> grantAccesses;


    public Role() {
    }

    public Role(String roleId) {
        this.roleId = roleId;
    }

    public Role(String roleId, String roleName, String decription, Status status) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.decription = decription;
        this.status = status;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getDecription() {
        return decription;
    }

    public Status getStatus() {
        return status;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", decription='" + decription + '\'' +
                ", status=" + status +
                '}';
    }
}
