package models.persistence.dao;

import models.persistence.dao.impl.OperatingSystemDao;
import models.persistence.entities.OperatingSystem;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OperatingSystemDaoTest
{
    private DaoTestBuilder daoTestBuilder = new DaoTestBuilder();
    private EntityManager mockEntityManager;

    private OperatingSystemDao operatingSystemDao;
    private OperatingSystem operatingSystem;

    @Before
    public void init()
    {
        daoTestBuilder.createTestObjects();
        operatingSystemDao = new OperatingSystemDao(daoTestBuilder.getMockEntityManagerProvider());

        daoTestBuilder.setStatus();
        operatingSystem = daoTestBuilder.getOperatingSystem();

        mockEntityManager = daoTestBuilder.getMockEntityManager();
    }

    @Test
    public void testCreate()
    {
        operatingSystemDao.create(operatingSystem);
        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(operatingSystem);
    }

    @Test
    public void testDelete()
    {

        operatingSystemDao.delete(1L);
        Mockito.verify(mockEntityManager, Mockito.times(1)).getReference(OperatingSystem.class, 1L);
    }

    @Test
    public void testUpdate()
    {
        operatingSystemDao.update(operatingSystem);
        Mockito.verify(mockEntityManager, Mockito.times(1)).merge(operatingSystem);
    }

    @Test
    public void testFind()
    {
        operatingSystemDao.find(1L);
        Mockito.verify(mockEntityManager, Mockito.times(1)).find(OperatingSystem.class, 1L);
    }

    @Test
    public void testList()
    {
<<<<<<< HEAD
        List<OperatingSystem> list = operatingSystemDao.list();
        assertEquals(daoTestBuilder.getMockResultList(), list);
    }
}
=======
        List<OperatingSystem> statusList = operatingSystemDao.list();
        assertEquals(daoTestBuilder.getMockResultList(), statusList);
    }
}
>>>>>>> 6deadbe746ee20d4203467e07c086415a21cfe1c
