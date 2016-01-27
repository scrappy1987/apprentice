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
    private StatusDaoTestBuilder statusDaoTestBuilder = new StatusDaoTestBuilder();
    private EntityManager mockEntityManager;

    private StatusDao statusDao;
    private Status status;

    @Before
    public void init()
    {
        statusDaoTestBuilder.createStatusTestObjects();
        statusDao = new StatusDao(statusDaoTestBuilder.getMockEntityManagerProvider());
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
        statusDao.create(status);
        statusDao.delete(status);
        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(status);
    }

    @Test
    public void testUpdateStatus()
    {
        statusDao.create(status);
        statusDao.update(status);
        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(status);
    }

    @Test
    public void testFindStatus()
    {
        statusDao.create(status);
        statusDao.find(status);
        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(status);
    }

    @Test
    public void testListStatus()
    {
        List<Status> statusList = statusDao.list();
        assertEquals(statusDaoTestBuilder.getMockResultList(), statusList);
    }
}
