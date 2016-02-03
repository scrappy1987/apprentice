package models.services.functionalorg;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.FunctionalOrganisationDao;
import models.persistence.dao.impl.LocationDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.Location;
import models.services.functionalorg.ListLocationForFunctionalOrgServiceOperation;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a613794 on 02/02/2016.
 */
public class ListLocationForFunctionalOrgServiceOperationTest {

    private ListLocationForFunctionalOrgServiceOperation listLocationForFunctionalOrgServiceOperation;

    private LocationDao locationDao;

    private FunctionalOrganisationDao functionalOrganisationDao;

    private EntityManager em;

    private EntityManagerProvider emp;

    private List<Location> locations;

    @Test
    public void listLocationForFunctionalOrgServiceOperationTest()
    {
        setUpEntityManager();
        createLocationsList();
        createDaoObjects();
        listLocationForFunctionalOrgServiceOperation = new ListLocationForFunctionalOrgServiceOperation(locationDao, functionalOrganisationDao, new JSONHelper());
        JsonNode jsonRequest = new JSONHelper().toJson(1L);
        Assert.assertEquals(new JSONHelper().toJson(locations), listLocationForFunctionalOrgServiceOperation.doExecute(jsonRequest));
    }

    private void createDaoObjects()
    {
        functionalOrganisationDao = new FunctionalOrganisationDao(emp);
        locationDao = Mockito.mock(LocationDao.class);
        Mockito.when(locationDao.findLocationsForFunctionalOrganisation(Mockito.anyObject())).thenReturn(locations);
    }

    private void setUpEntityManager()
    {
        em = Mockito.mock(EntityManager.class);
        emp = Mockito.mock(EntityManagerProvider.class);
        Mockito.when(emp.getEntityManager()).thenReturn(em);
    }

    private void createLocationsList()
    {
        locations = new ArrayList<Location>();
        Location location = new Location();
        locations.add(0, location);
    }
}
