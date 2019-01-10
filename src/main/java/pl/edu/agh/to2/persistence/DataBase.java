package pl.edu.agh.to2.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    static{
        factory = Persistence.createEntityManagerFactory("default");
        entityManager = factory.createEntityManager();
    }

    private DataBase() { }

    public static void close(){
        entityManager.close();
        factory.close();
    }

    public static boolean save(Domain domain){
        try {
            EntityTransaction txn = entityManager.getTransaction();
            txn.begin();
            entityManager.persist(domain);
            txn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean save(Article article, Domain domain) {
        try {
            EntityTransaction txn = entityManager.getTransaction();
            txn.begin();
            entityManager.persist(article);
            domain.addArticle(article);
            txn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    //TODO
    public static List<Article> getArticles(Domain domain) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        String SQLquery = "SELECT a FROM Article a JOIN a.domain d WHERE d.url like :d_url";
        Query query = entityManager.createQuery(SQLquery, Article.class).setParameter("d_url", domain.getUrl());
//        String SQLquery = "SELECT a FROM Article a ";
//        Query query = entityManager.createQuery(SQLquery, Article.class);
        List list = query.getResultList();
        txn.commit();
        return list;
    }
}
