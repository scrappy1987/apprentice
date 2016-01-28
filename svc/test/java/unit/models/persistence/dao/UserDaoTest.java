package models.persistence.dao;

import models.persistence.dao.impl.UserDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;

/**
 * Created by a613794 on 28/01/2016.
 */
public class UserDaoTest {

    private EntityManager em;
    private EntityManagerProvider emp;
    private UserDao userDao;
    private User user;

    @Before
    public void before()
    {
        buildMockObjects();
        userDao = new UserDao(emp);
        user = new User();
    }

    @Test
    public void createUserTest()
    {
        userDao.create(user);
        Mockito.verify(em, Mockito.times(1)).persist(user);
    }

    @Test
    public void deleteUserTest()
    {
        userDao.delete(1L);
        Mockito.verify(em, Mockito.times(1)).getReference(User.class, 1L);
    }

    @Test
    public void updateUserTest()
    {
        userDao.update(user);
        Mockito.verify(em, Mockito.times(1)).merge(user);
    }

    private void buildMockObjects()
    {
        em = Mockito.mock(EntityManager.class);
        emp = Mockito.mock(EntityManagerProvider.class);
        Mockito.when(emp.getEntityManager()).thenReturn(em);
    }
}
