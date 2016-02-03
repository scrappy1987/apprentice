package controllers.resource.play;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.persistence.entities.Location;
import models.services.location.LocationService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static play.mvc.Results.ok;

/**
 * Created by a613794 on 03/02/2016.
 */
public class LocationEndpointTest {

    private LocationEndpoint locationEndpoint;

    private LocationService locationService;

    private JsonNode locationsAsJson;

    @Test
    public void locationEndpointTest()
    {
        createLocationListAsJson();
        locationService = Mockito.mock(LocationService.class);
        locationEndpoint = new LocationEndpoint(locationService);
        Mockito.when(locationEndpoint.getService().listForFunctionalOrgId(Mockito.anyObject())).thenReturn(locationsAsJson);
        Assert.assertEquals(ok(locationsAsJson).toString(), locationEndpoint.list(1L).toString());
    }

    private void createLocationListAsJson()
    {
        List<Location> locations = new ArrayList<Location>();
        locations.add(0, new Location());
        locationsAsJson = new JSONHelper().toJson(locations);
    }
}
