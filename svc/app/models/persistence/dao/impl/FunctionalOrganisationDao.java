package models.persistence.dao.impl;

import com.google.inject.Inject;
import models.persistence.dao.GenericDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.FunctionalOrganisation;
import models.persistence.entities.User;

import java.util.List;

/**
 * Created by a613794 on 28/01/2016.
 */
public class FunctionalOrganisationDao extends GenericDao<FunctionalOrganisation> {
    @Inject
    public FunctionalOrganisationDao(EntityManagerProvider emp)
    {
        super(emp);
    }

    public List<FunctionalOrganisation> findFunctionalOrganistionsForUser(User user)
    {
        return user.getFunctionalOrgs();
    }
}
