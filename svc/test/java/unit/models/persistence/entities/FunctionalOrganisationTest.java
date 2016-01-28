package models.persistence.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a613794 on 28/01/2016.
 */
public class FunctionalOrganisationTest
{
    private FunctionalOrganisation functionalOrg;
    private List<BusinessUnit> businessUnits = new ArrayList<BusinessUnit>();

    @Before
    public void before()
    {
        functionalOrg = new FunctionalOrganisation();
        functionalOrg.setId (1);
        functionalOrg.setAccount("accountNameTest");
        functionalOrg.setSmPlatform("smPlatformNameTest");
        functionalOrg.setCmdbPlatform("cmdPlatformNameTest");
    }

    @Test
    public void getIdTest()
    {
        Assert.assertEquals(1L, functionalOrg.getId());
    }

    @Test
    public void getAssetTest()
    {
        Assert.assertEquals("accountNameTest", functionalOrg.getAccount());
    }

    @Test
    public void getSmPlatformTest()
    {
        Assert.assertEquals("smPlatformNameTest", functionalOrg.getSmPlatform());
    }

    @Test
    public void getCmdPlatformTest()
    {
        Assert.assertEquals("cmdPlatformNameTest", functionalOrg.getCmdbPlatform());
    }

    @Test
    public void getBusinessUnitsTest()
    {
        Assert.assertEquals(businessUnits, functionalOrg.getBusinessUnits());
    }
}
