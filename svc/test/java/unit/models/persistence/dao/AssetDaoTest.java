package models.persistence.dao;

import models.persistence.dao.impl.AssetDao;
import models.persistence.entities.Asset;
import models.persistence.entities.Contact;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AssetDaoTest
{
    private DaoTestBuilder daoTestBuilder = new DaoTestBuilder();
    private EntityManager mockEntityManager;

    private AssetDao assetDao;
    private Asset asset;

    @Before
    public void init()
    {
        daoTestBuilder.createTestObjects();
        assetDao = new AssetDao(daoTestBuilder.getMockEntityManagerProvider());

        asset = daoTestBuilder.getAsset();

        mockEntityManager = daoTestBuilder.getMockEntityManager();
    }

    @Test
    public void testCreate()
    {
        assetDao.create(asset);
        Mockito.verify(mockEntityManager, Mockito.times(1)).persist(asset);
    }

    @Test
    public void testDelete()
    {

        assetDao.delete(1L);
        Mockito.verify(mockEntityManager, Mockito.times(1)).getReference(Asset.class, 1L);
    }

    @Test
    public void testUpdate()
    {
        assetDao.update(asset);
        Mockito.verify(mockEntityManager, Mockito.times(1)).merge(asset);
    }

    @Test
    public void testFind()
    {
        assetDao.find(1L);
        Mockito.verify(mockEntityManager, Mockito.times(1)).find(Asset.class, 1L);
    }

    @Test
    public void testList()
    {
        List<Asset> list = assetDao.list();
        assertEquals(daoTestBuilder.getMockResultList(), list);
    }

    @Test
    public void testListWithContact()
    {
        daoTestBuilder.setContact();
        List<Asset> list = assetDao.listForContact(daoTestBuilder.getContact());
        assertEquals(daoTestBuilder.getMockResultList(), list);
    }
}
