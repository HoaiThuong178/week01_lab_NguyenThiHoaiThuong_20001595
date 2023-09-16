package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.connection.Connection;
import vn.edu.iuh.fit.entities.Role;
import vn.edu.iuh.fit.entities.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleRepository extends CRUDRepository<Role,String>{
    private final EntityManager entityManager= Connection.getInstance().getEm();

    @Override
    public Boolean add(Role role) {
        return super.add(role);
    }

    @Override
    public Optional<Boolean> update(Role role, String id) {
        return super.update(role, id);
    }
    public List<Role> getRoleByAccountId(String accountId) {
        try {
            List resultList = entityManager.createNativeQuery("select  * from role where status = ?2 AND id IN (SELECT ga.role_id FROM grant_access ga WHERE ga.account_id = ?1)", Role.class)
                    .setParameter(1, accountId)
                    .setParameter(2, Status.active)
                    .getResultList();
            return resultList;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
