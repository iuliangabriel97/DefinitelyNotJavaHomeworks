/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import entities.CourseEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.eclipse.persistence.config.CacheUsage;
import org.eclipse.persistence.config.QueryHints;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author roungureanu
 */
public class PerformanceTests {
    @Test
    public void secondLevelCache() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Tema4PU");
        EntityManager em = factory.createEntityManager();
        
        long startTime;
        long durationWithCache;
        long durationWithoutCache;
        
        startTime = System.currentTimeMillis();
        Query queryWithCache = em.createQuery("SELECT c FROM CourseEntity c");
        queryWithCache.getResultList();
        durationWithCache = System.currentTimeMillis() - startTime;
        
        startTime = System.currentTimeMillis();
        Query queryWithoutCache = em.createQuery("SELECT c FROM CourseEntity c");
        queryWithoutCache.setHint(QueryHints.CACHE_USAGE, CacheUsage.DoNotCheckCache);
        queryWithoutCache.getResultList();
        durationWithoutCache = System.currentTimeMillis() - startTime;
        
        assertTrue(durationWithCache < durationWithoutCache);
    }
}
