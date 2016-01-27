package models.persistence.dao;

import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.Status;
import org.mockito.Mockito;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class StatusDaoTestBuilder
{
    private Status status;
    private EntityManagerProvider mockEntityManagerProvider;
    private EntityManager mockEntityManager;
    private Query mockQuery;
    private List<Status> mockResultList;

    public void createStatusTestObjects()
    {
        mockEntityManager = Mockito.mock(EntityManager.class);
        mockEntityManagerProvider = Mockito.mock(EntityManagerProvider.class);
        mockQuery = Mockito.mock(Query.class);
        mockResultList = new ArrayList<>();

        Mockito.when(mockEntityManagerProvider.getEntityManager()).thenReturn(mockEntityManager);
        Mockito.when(mockEntityManager.createQuery(Mockito.anyString())).thenReturn(mockQuery);
        Mockito.when(mockQuery.getResultList()).thenReturn(mockResultList);

        status = new Status();
    }

    public Status getStatus()
    {
        return status;
    }

    public EntityManagerProvider getMockEntityManagerProvider()
    {
        return mockEntityManagerProvider;
    }

    public EntityManager getMockEntityManager()
    {
        return mockEntityManager;
    }

    public List<Status> getMockResultList()
    {
        return mockResultList;
    }
}
