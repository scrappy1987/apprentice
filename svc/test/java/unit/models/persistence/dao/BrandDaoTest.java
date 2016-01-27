package models.persistence.dao;

import models.persistence.dao.impl.BrandDao;
import models.persistence.entities.Brand;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import javax.persistence.EntityManager;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class BrandDaoTest
{
    private DaoTestBuilder daoTestBuilder = new DaoTestBuilder();
    private EntityManager mockEntityManager;

    private BrandDao brandDao;
    private Brand brand;

    @Before
    public void init()
    {
        daoTestBuilder.createTestObjects();
        brandDao = new BrandDao(daoTestBuilder.getMockEntityManagerProvider());

        daoTestBuilder.setStatus();
        brand = daoTestBuilder.getBrand();

        mockEntityManager = daoTestBuilder.getMockEntityManager();
    }

    @Test
    public void testCreate()
    {
        brandDao.create(brand);
        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(brand);
    }

    @Test
    public void testDelete()
    {

        brandDao.delete(1L);
        Mockito.verify(mockEntityManager, Mockito.times(1)).getReference(Brand.class, 1L);
    }

    @Test
    public void testUpdate()
    {
        brandDao.update(brand);
        Mockito.verify(mockEntityManager, Mockito.times(1)).merge(brand);
    }

    @Test
    public void testFind()
    {
        brandDao.find(1L);
        Mockito.verify(mockEntityManager, Mockito.times(1)).find(Brand.class, 1L);
    }

    @Test
    public void testListStatus()
    {
        List<Brand> list = brandDao.list();
        assertEquals(daoTestBuilder.getMockResultList(), list);
    }
}
