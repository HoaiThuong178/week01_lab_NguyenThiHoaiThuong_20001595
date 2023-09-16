package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.connection.Connection;
import vn.edu.iuh.fit.entities.Role;

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
}
