package controllers.resource.play;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.persistence.entities.Contact;
import models.services.location.ContactService;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a613794 on 03/02/2016.
 */
public class ContactEndpointTest {

    private ContactEndpoint contactEndpoint;

    private ContactService contactService;

    private JsonNode contactAsJson;

    @Test
    public void contactEndpointTest()
    {
        createContactListAsJson();
        contactService = Mockito.mock(ContactService.class);
        contactEndpoint = new ContactEndpoint((contactService));
        Mockito.when(contactEndpoint.getService().listForLocation(Mockito.anyObject())).thenReturn(contactAsJson);
    }

    private void createContactListAsJson()
    {
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(0, new Contact());
        contactAsJson = new JSONHelper().toJson(contacts);
    }
}
