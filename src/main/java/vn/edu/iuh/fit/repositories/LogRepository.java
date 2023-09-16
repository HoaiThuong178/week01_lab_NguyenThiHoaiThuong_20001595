package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.connection.Connection;
import vn.edu.iuh.fit.entities.Log;

import java.util.Optional;

public class LogRepository extends CRUDRepository<Log,Long>{
    private final EntityManager entityManager= Connection.getInstance().getEm();

    @Override
    public Optional<Boolean> update(Log log, Long id) {
        return super.update(log, id);
    }
}
