package models.persistence.dao;

import models.persistence.dao.impl.CategoryTypeDao;
import models.persistence.entities.CategoryType;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CategoryTypeDaoTest
{
    private DaoTestBuilder daoTestBuilder = new DaoTestBuilder();
    private EntityManager mockEntityManager;

    private CategoryTypeDao categoryTypeDao;
    private CategoryType categoryType;

    @Before
    public void init()
    {
        daoTestBuilder.createTestObjects();
        categoryTypeDao = new CategoryTypeDao(daoTestBuilder.getMockEntityManagerProvider());

        categoryType = daoTestBuilder.getCategoryType();

        mockEntityManager = daoTestBuilder.getMockEntityManager();
    }

    @Test
    public void testCreate()
    {
        categoryTypeDao.create(categoryType);
        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(categoryType);
    }

    @Test
    public void testDelete()
    {

        categoryTypeDao.delete(1L);
        Mockito.verify(mockEntityManager, Mockito.times(1)).getReference(CategoryType.class, 1L);
    }

    @Test
    public void testUpdate()
    {
        categoryTypeDao.update(categoryType);
        Mockito.verify(mockEntityManager, Mockito.times(1)).merge(categoryType);
    }

    @Test
    public void testFind()
    {
        categoryTypeDao.find(1L);
        Mockito.verify(mockEntityManager, Mockito.times(1)).find(CategoryType.class, 1L);
    }

    @Test
    public void testListStatus()
    {
        List<CategoryType> list = categoryTypeDao.list();
        assertEquals(daoTestBuilder.getMockResultList(), list);
    }
}
