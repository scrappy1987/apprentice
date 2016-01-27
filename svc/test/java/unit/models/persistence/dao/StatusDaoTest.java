package models.persistence.dao;

import models.persistence.dao.impl.StatusDao;
import models.persistence.entities.Status;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import javax.persistence.EntityManager;
import java.util.List;

public class StatusDaoTest
{
    private DaoTestBuilder statusDaoTestBuilder = new DaoTestBuilder();
    private EntityManager mockEntityManager;

    private StatusDao statusDao;
    private Status status;

    @Before
    public void init()
    {
        statusDaoTestBuilder.createTestObjects();
        statusDao = new StatusDao(statusDaoTestBuilder.getMockEntityManagerProvider());

        statusDaoTestBuilder.setStatus();
        status = statusDaoTestBuilder.getStatus();

        mockEntityManager = statusDaoTestBuilder.getMockEntityManager();
    }

    @Test
    public void testCreateStatus()
    {
        statusDao.create(status);
        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(status);
    }

    @Test
    public void testDeleteStatus()
    {

        statusDao.delete(1L);
        Mockito.verify(mockEntityManager, Mockito.times(1)).getReference(Status.class, 1L);
    }

    @Test
    public void testUpdateStatus()
    {
        statusDao.update(status);
        Mockito.verify(mockEntityManager, Mockito.times(1)).merge(status);
    }

    @Test
    public void testFindStatus()
    {
        statusDao.find(1L);
        Mockito.verify(mockEntityManager, Mockito.times(1)).find(Status.class, 1L);
    }

    @Test
    public void testListStatus()
    {
        List<Status> statusList = statusDao.list();
        assertEquals(statusDaoTestBuilder.getMockResultList(), statusList);
    }
}
