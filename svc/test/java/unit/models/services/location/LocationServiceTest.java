package models.services.location;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.persistence.entities.Location;
import models.services.UnavailableServiceOperation;
import models.services.functionalorg.ListLocationForFunctionalOrgServiceOperation;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a613794 on 02/02/2016.
 */
public class LocationServiceTest {

    private LocationService locationService;

    private ListLocationForFunctionalOrgServiceOperation listLocationForFunctionalOrgServiceOperation;

    private Location location;

    private JsonNode locationsAsJson;

    @Test
    public void locationServiceTest()
    {
        createLocationList();
        createListLocationForFunctionalOrg();
        JsonNode jsonRequest = new JSONHelper().toJson(1L);
        Assert.assertEquals(locationsAsJson, locationService.listForFunctionalOrgId(jsonRequest));
    }

    private void createLocationList()
    {
        location = new Location();
        List<Location> locations = new ArrayList<Location>();
        locations.add(0, location);
        locationsAsJson = new JSONHelper().toJson(locations);
    }

    private void createListLocationForFunctionalOrg()
    {
        listLocationForFunctionalOrgServiceOperation = Mockito.mock(ListLocationForFunctionalOrgServiceOperation.class);
        Mockito.when(listLocationForFunctionalOrgServiceOperation.execute(Mockito.anyObject())).thenReturn(locationsAsJson);
        locationService = new LocationService(listLocationForFunctionalOrgServiceOperation,
                new UnavailableServiceOperation(new JSONHelper()), new JSONHelper());
    }

}
