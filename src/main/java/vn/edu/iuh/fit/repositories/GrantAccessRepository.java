package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import vn.edu.iuh.fit.connection.Connection;
import vn.edu.iuh.fit.entities.Grant;
import vn.edu.iuh.fit.entities.GrantAccess;

import java.util.Optional;

public class GrantAccessRepository {
    private final EntityManager entityManager= Connection.getInstance().getEm();

    public Boolean add(GrantAccess grantAccess){
        EntityTransaction transaction=entityManager.getTransaction();
        try {


            transaction.begin();;
            entityManager.persist(grantAccess);
            transaction.commit();
            return true;

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public Optional<Boolean> update(GrantAccess grantAccess){
        EntityTransaction transaction=null;
        try {
            entityManager.createNativeQuery("SELECT *FROM GrantAccess WHERE role.id = ?1 AND account.id = ?2", GrantAccess.class)
                    .setParameter(1, grantAccess.getRole().getRoleId())
                    .setParameter(2, grantAccess.getAccount().getAccountId())
                    .getSingleResult();

            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.merge(grantAccess);

            transaction.commit();
            return Optional.of(true);
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return Optional.of(false);
    }
    public Optional<Boolean> updateGrant(String accountId, String roleId) {
        EntityTransaction transaction = null;

        try {
            GrantAccess grantAccess = entityManager.createQuery("from GrantAccess ga where ga.role.id=?1 and ga.account.id=?2", GrantAccess.class)
                    .setParameter(1, roleId)
                    .setParameter(2, accountId)
                    .getSingleResult();

            transaction = entityManager.getTransaction();
            transaction.begin();

            grantAccess.setIsGrant(Grant.enable);
            entityManager.merge(grantAccess);

            transaction.commit();
            return Optional.of(true);
        } catch (NoResultException ignored) {
            ignored.printStackTrace();
            return Optional.empty();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.of(false);
    }
}
