package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.connection.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class CRUDRepository<T,K> {
    private static EntityManager entityManager;

    public CRUDRepository() {
        entityManager = Connection.getInstance().getEm();
    }


    public Optional<T> findById(Class<T> clazz, K id){
        T t=  entityManager.find(clazz,id);
        if(t==null)
            return Optional.empty();
        return Optional.of(t);
    }
    public List<T> getAll(Class<T> clazz){
        try {
            return entityManager.createNativeQuery("select* from"+clazz.getName(),clazz).getResultList();
        }catch (Exception e){

            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    public Boolean add(T t){
        EntityTransaction transaction=entityManager.getTransaction();;
        try {


            transaction.begin();;
            entityManager.persist(t);
            transaction.commit();
            return true;

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }
    public Optional<Boolean> update(T t,K id){
        EntityTransaction transaction=null;
        try {
            transaction=entityManager.getTransaction();
            T t1=(T)entityManager.find(t.getClass(),id);
            if(t1==null){
                return Optional.empty();
            }
            transaction.begin();
            entityManager.merge(t);
            transaction.commit();
            return Optional.of(true);
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return Optional.of(false);
    }
}
