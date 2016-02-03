package models.persistence.dao.impl;

import com.google.inject.Inject;
import models.persistence.dao.GenericDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.FunctionalOrganisation;
import models.persistence.entities.Location;

import java.util.List;

public class LocationDao extends GenericDao<Location> {
    @Inject
    public LocationDao(EntityManagerProvider emp)
    {
        super(emp);
    }

    public List<Location> findLocationsForFunctionalOrganisation(FunctionalOrganisation functionalOrganisation)
    {
        return getEntityManager().createQuery("SELECT l FROM Location l WHERE l.functionalOrg = :functionalOrganisation").setParameter("functionalOrganisation", functionalOrganisation).getResultList();
    }
}