import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JPQL1 {
    //java persistence query language
    public static void main(String[] args) {
        //fun1();
        //fun2();
        //fun3();
        fun4();
    }

    private static void fun4() {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        String jpql = "from Customer where custName like ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, "%t%");
        List resultList = query.getResultList();
        resultList.forEach(System.out::println);
        tx.commit();
        em.close();
    }

    private static void fun3() {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        String jpql = "from Customer";
        Query query = em.createQuery(jpql);
        query.setFirstResult(0);
        query.setMaxResults(2);
        List resultList = query.getResultList();
        resultList.forEach(System.out::println);
        tx.commit();
        em.close();
    }

    private static void fun2() {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        String jpql = "select count(custId) from Customer";
        Query query = em.createQuery(jpql);
        Object singleResult = query.getSingleResult();
        System.out.println("singleResult = " + singleResult);
        tx.commit();
        em.close();
    }

    private static void fun1() {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //String jpql = "from Customer ";
        String jpql = "from Customer order by custId desc ";
        Query query = em.createQuery(jpql);
        List resultList = query.getResultList();
        resultList.forEach(System.out::println);
        tx.commit();
        em.close();
    }
}
