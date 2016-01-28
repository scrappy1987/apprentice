package models.persistence.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a613794 on 28/01/2016.
 */
public class UserTest {
    private User user;
    private List<FunctionalOrganisation> functionalOrgs = new ArrayList<FunctionalOrganisation>();

    @Before
    public void before()
    {
        user = new User();
        user.setId (1L);
        user.setName("name");
        user.setFunctionalOrgs(functionalOrgs);
    }

    @Test
    public void getIdTest()
    {
        Assert.assertTrue(1L ==  user.getId());
    }

    @Test
    public void getNameTest()
    {
        Assert.assertEquals("name", user.getUserId());
    }

    @Test
    public void getFunctionalOrgsTest()
    {
        Assert.assertEquals(functionalOrgs, user.getFunctionalOrgs());
    }
}
