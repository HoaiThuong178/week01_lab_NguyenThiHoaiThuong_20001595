package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.connection.Connection;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.Role;
import vn.edu.iuh.fit.entities.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepository extends CRUDRepository<Account,String>{

    private final EntityManager entityManager=Connection.getInstance().getEm();

    @Override
    public Boolean add(Account account) {
        return add(account);
    }

    @Override
    public Optional<Boolean> update(Account account, String id) {
        return update(account, id);
    }
    public Optional<Account> isLogin(String id, String pwd){
        EntityTransaction transaction=null;
        try {
            transaction=entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNativeQuery("select * from account  where account_id=?1 and password=?2 and status=?3")
                    .setParameter(1, id)
                    .setParameter(2, pwd)
                    .setParameter(3, Status.active);
            Account account= (Account) query.getSingleResult();
            transaction.commit();
            return Optional.of(account);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
    public List<Account> getAccountByRoleId(String roleId) {
        try {
            List resultList = entityManager.createNativeQuery("select  * from account where status = ?2 AND id IN (SELECT ga.account_id FROM grant_access ga WHERE ga.role_id = ?1)", Account.class)
                    .setParameter(1, roleId)
                    .setParameter(2, Status.active)
                    .getResultList();
            return resultList;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}

