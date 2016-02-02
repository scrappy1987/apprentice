package models.persistence.dao.impl;

import com.google.inject.Inject;
import models.persistence.dao.GenericDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.Contact;

public class ContactDao extends GenericDao<Contact> {
    @Inject
    public ContactDao(EntityManagerProvider emp)
    {
        super(emp);
    }
}
