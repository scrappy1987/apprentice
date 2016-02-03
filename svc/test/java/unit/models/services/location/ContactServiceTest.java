package models.services.location;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.persistence.entities.Contact;
import models.services.UnavailableServiceOperation;
import models.services.functionalorg.ListContactForLocationServiceOperation;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a613794 on 03/02/2016.
 */
public class ContactServiceTest {

    private ContactService contactService;

    private ListContactForLocationServiceOperation listContactForLocationServiceOperation;

    private Contact contact;

    private JsonNode contactAsJson;

    @Test
    public void contactServiceTest()
    {
        createContactList();
        createListContactForLocation();
        JsonNode jsonRequest = new JSONHelper().toJson(1L);
        Assert.assertEquals(contactAsJson, contactService.listForLocation(jsonRequest));
    }

    private void createContactList()
    {
        contact = new Contact();
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(0, contact);
        contactAsJson = new JSONHelper().toJson(contacts);
    }

    private void createListContactForLocation()
    {
        listContactForLocationServiceOperation = Mockito.mock(ListContactForLocationServiceOperation.class);
        Mockito.when(listContactForLocationServiceOperation.doExecute(Mockito.anyObject())).thenReturn(contactAsJson);
        contactService = new ContactService(listContactForLocationServiceOperation,
                new UnavailableServiceOperation(new JSONHelper()), new JSONHelper());
    }




}
