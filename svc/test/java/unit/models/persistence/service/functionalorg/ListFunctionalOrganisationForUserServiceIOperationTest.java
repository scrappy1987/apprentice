package models.persistence.service.functionalorg;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.FunctionalOrganisationDao;
import models.persistence.dao.impl.UserDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.FunctionalOrganisation;
import models.services.functionalorg.ListFunctionalOrganisationForUserServiceOperation;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a613794 on 02/02/2016.
 */
public class ListFunctionalOrganisationForUserServiceIOperationTest {

    private ListFunctionalOrganisationForUserServiceOperation listFunctionalOrganisationForUserServiceOperation;
    private FunctionalOrganisationDao functionalOrganisationDao;
    private UserDao userDao;
    private EntityManager em;
    private EntityManagerProvider emp;
    private List<FunctionalOrganisation> functionalOrganisations = new ArrayList<FunctionalOrganisation>();
    private JsonNode jsonRequest, jsonResponse;
    @Test
    public void doExecuteTest()
    {
        setupEntityManager();
        createListFunctionOrganisationForUserServiceOperation();
        createJsonObjects();
        Assert.assertEquals(jsonResponse, listFunctionalOrganisationForUserServiceOperation.doExecute(jsonRequest));
    }

    private void createListFunctionOrganisationForUserServiceOperation()
    {
        userDao = new UserDao(emp);
        functionalOrganisationDao = Mockito.mock(FunctionalOrganisationDao.class);
        FunctionalOrganisation functionalOrganisation = new FunctionalOrganisation();
        functionalOrganisations.add(0, functionalOrganisation);
        Mockito.when(functionalOrganisationDao.findFunctionalOrganisationsForUser(Mockito.anyObject())).thenReturn(functionalOrganisations);
        listFunctionalOrganisationForUserServiceOperation = new ListFunctionalOrganisationForUserServiceOperation(functionalOrganisationDao, new JSONHelper(), userDao);
    }

    private void createJsonObjects()
    {
        jsonRequest = new JSONHelper().toJson(1L);
        jsonResponse = new JSONHelper().toJson(functionalOrganisations);
    }

    private void setupEntityManager()
    {
        em = Mockito.mock(EntityManager.class);
        emp = Mockito.mock(EntityManagerProvider.class);
        Mockito.when(emp.getEntityManager()).thenReturn(em);
    }
}
