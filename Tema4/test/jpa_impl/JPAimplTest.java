package jpa_impl;

import entities.CourseEntity;
import org.junit.Test;
import java.util.List;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author LucianAlexandru
 */
public class JPAimplTest extends JPAimplTestInterface {
    
    @Test
    public void testGetObjectById_success() {
        CourseEntity course = em.find(CourseEntity.class, 1);
        assertNotNull(course);
    }

    @Test
    public void testGetAll_success() {
        List<CourseEntity> courses = em.createNamedQuery("CourseEntity.getAll", CourseEntity.class).getResultList();
        assertEquals(1, courses.size());
    }

    @Test
    public void testPersist_success() {
        em.getTransaction().begin();
        em.persist(new CourseEntity());
        em.getTransaction().commit();

        List<CourseEntity> courses = em.createNamedQuery("CourseEntity.getAll", CourseEntity.class).getResultList();

        assertNotNull(courses);
        assertEquals(2, courses.size());
    }

    @Test
    public void testDelete_success(){
        CourseEntity course = em.find(CourseEntity.class, 1);

        em.getTransaction().begin();
        em.remove(course);
        em.getTransaction().commit();

        List<CourseEntity> courses = em.createNamedQuery("CourseEntity.getAll", CourseEntity.class).getResultList();

        assertEquals(0, courses.size());
    }

}
