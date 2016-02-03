package models.persistence.dao.impl;

import com.google.inject.Inject;
import common.util.json.play.JSONHelper;
import models.persistence.dao.GenericDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.Contact;
import models.persistence.entities.FunctionalOrganisation;
import models.persistence.entities.Location;
import models.persistence.entities.User;
import play.Logger;

import java.util.List;

public class ContactDao extends GenericDao<Contact> {
    @Inject
    public ContactDao(EntityManagerProvider emp)
    {
        super(emp);
    }

    public List<Contact> findContactsForLocation(Location location)
    {
        return getEntityManager().createQuery("SELECT c FROM Contact c WHERE c.location = :location").setParameter("location", location).getResultList();
    }
}
