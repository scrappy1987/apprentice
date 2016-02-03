package models.services.functionalorg;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.ContactDao;
import models.persistence.dao.impl.LocationDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.Contact;
import models.persistence.entities.Location;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a613794 on 03/02/2016.
 */
public class ListContactForLocationServiceOperationTest {

    private ListContactForLocationServiceOperation listContactForLocationServiceOperation;

    private ContactDao contactDao;

    private LocationDao locationDao;

    private Contact contact;

    private List<Contact> contacts;

    private JsonNode contactsAsJsonNode;

    private EntityManagerProvider emp;

    @Test
    public void listContactForLocationServiceOperationTest()
    {
        setUpEntityManager();
        createDaoObjects();
        createContactsAsJsonResponse();
        Mockito.when(contactDao.findContactsForLocation(Mockito.anyObject())).thenReturn(contacts);
        listContactForLocationServiceOperation = new ListContactForLocationServiceOperation(contactDao, locationDao, new JSONHelper());
        Assert.assertEquals(contactsAsJsonNode.toString(), listContactForLocationServiceOperation.doExecute(new JSONHelper().toJson(1L)).toString());
    }

    private void createContactsAsJsonResponse()
    {
        contact = new Contact();
        contacts = new ArrayList<Contact>();
        contacts.add(0, contact);
        contactsAsJsonNode = new JSONHelper().toJson(contacts);
    }

    private void createDaoObjects()
    {
        contactDao = Mockito.mock(ContactDao.class);
        locationDao = new LocationDao(emp);
    }

    private void setUpEntityManager()
    {
        EntityManager em = Mockito.mock(EntityManager.class);
        emp = Mockito.mock(EntityManagerProvider.class);
        Mockito.when(emp.getEntityManager()).thenReturn(em);
    }
}
