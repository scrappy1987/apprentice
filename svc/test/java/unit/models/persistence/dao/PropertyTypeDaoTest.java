package models.persistence.dao;

import models.persistence.dao.impl.PropertyTypeDao;
import models.persistence.entities.PropertyType;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import javax.persistence.EntityManager;
import java.util.List;

public class PropertyTypeDaoTest
{
    private DaoTestBuilder daoTestBuilder = new DaoTestBuilder();
    private EntityManager mockEntityManager;

    private PropertyTypeDao propertyTypeDao;
    private PropertyType propertyType;

    @Before
    public void init()
    {
        daoTestBuilder.createTestObjects();
        propertyTypeDao = new PropertyTypeDao(daoTestBuilder.getMockEntityManagerProvider());

        daoTestBuilder.setStatus();
        propertyType = daoTestBuilder.getPropertyType();

        mockEntityManager = daoTestBuilder.getMockEntityManager();
    }

    @Test
    public void testCreate()
    {
        propertyTypeDao.create(propertyType);
        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(propertyType);
    }

    @Test
    public void testDelete()
    {

        propertyTypeDao.delete(1L);
        Mockito.verify(mockEntityManager, Mockito.times(1)).getReference(PropertyType.class, 1L);
    }

    @Test
    public void testUpdate()
    {
        propertyTypeDao.update(propertyType);
        Mockito.verify(mockEntityManager, Mockito.times(1)).merge(propertyType);
    }

    @Test
    public void testFind()
    {
        propertyTypeDao.find(1L);
        Mockito.verify(mockEntityManager, Mockito.times(1)).find(PropertyType.class, 1L);
    }

    @Test
    public void testListStatus()
    {
        List<PropertyType> list = propertyTypeDao.list();
        assertEquals(daoTestBuilder.getMockResultList(), list);
    }
}
