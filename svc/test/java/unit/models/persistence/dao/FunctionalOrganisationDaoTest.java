package models.persistence.dao;

import models.persistence.dao.impl.FunctionalOrganisationDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.FunctionalOrganisation;
import models.persistence.entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a613794 on 28/01/2016.
 */
public class FunctionalOrganisationDaoTest {
    private EntityManager em;
    private EntityManagerProvider emp;
    private FunctionalOrganisationDao functionalOrgDao;
    private FunctionalOrganisation functionalOrg;

    @Before
    public void before()
    {
        buildMockObjects();
        functionalOrgDao = new FunctionalOrganisationDao(emp);
        functionalOrg = new FunctionalOrganisation();
    }

    @Test
    public void createFunctionalOrgTest()
    {
        functionalOrgDao.create(functionalOrg);
        Mockito.verify(em, Mockito.times(1)).persist(functionalOrg);
    }

    @Test
    public void deleteFunctionalOrgTest()
    {
        functionalOrgDao.delete(1L);
        Mockito.verify(em, Mockito.times(1)).getReference(FunctionalOrganisation.class, 1L);
    }

    @Test
    public void updateFunctionalOrgTest()
    {
        functionalOrgDao.update(functionalOrg);
        Mockito.verify(em, Mockito.times(1)).merge(functionalOrg);
    }

    @Test
    public void findFunctionalOrganisationsForUser()
    {
        User user = new User();
        List<FunctionalOrganisation> functionalOrgs = new ArrayList<FunctionalOrganisation>();
        user.setFunctionalOrgs(functionalOrgs);
        Assert.assertEquals(functionalOrgs, functionalOrgDao.findFunctionalOrganistionsForUser(user));
    }

    private void buildMockObjects()
    {
        em = Mockito.mock(EntityManager.class);
        emp = Mockito.mock(EntityManagerProvider.class);
        Mockito.when(emp.getEntityManager()).thenReturn(em);
    }
}
