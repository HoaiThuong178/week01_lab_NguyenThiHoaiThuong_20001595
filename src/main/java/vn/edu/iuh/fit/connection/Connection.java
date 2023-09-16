package vn.edu.iuh.fit.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {
    private static Connection instance;
    private final EntityManager em;

    private Connection() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("week01_lab_NguyenThiHoaiThuong_20001595");
        em = emf.createEntityManager();
    }

    public static Connection getInstance() {
        if (instance == null)
            instance = new Connection();
        return instance;
    }

    public EntityManager getEm() {
        return em;
    }
}
