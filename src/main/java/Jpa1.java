import cn.pojo.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Jpa1 {
    public static void main(String[] args) {
        //insert();
        //query();
        //delete();
        update();
    }

    private static void update() {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Customer customer = em.find(Customer.class, 1L);
        customer.setCustAddress("beijing");
        em.merge(customer);
        tx.commit();
        em.close();
    }

    private static void delete() {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(2L);
        tx.commit();
        em.close();
    }

    private static void query() {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //Customer c = em.find(Customer.class, 1L);     //立即加载
        Customer c = em.getReference(Customer.class, 1L);       //延时加载，会得到动态代理对象
        System.out.println("c = " + c);
        tx.commit();
        em.close();
    }

    private static void insert() {
    /* EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
     EntityManager entityManager = entityManagerFactory.createEntityManager();*/
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        Customer customer = new Customer();
        customer.setCustName("tset2");
        tx.begin();
        entityManager.persist(customer);
        tx.commit();
        entityManager.close();
        //entityManagerFactory.close();
    }
}
