package models.persistence.dao;

import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.*;
import org.mockito.Mockito;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class DaoTestBuilder
{
    private Status status;
    private PropertyType propertyType;
    private OperatingSystem operatingSystem;
    private CategoryType categoryType;
    private Brand brand;

    private EntityManagerProvider mockEntityManagerProvider;
    private EntityManager mockEntityManager;
    private Query mockQuery;
    private List<Status> mockResultList;

    public void createTestObjects()
    {
        mockEntityManager = Mockito.mock(EntityManager.class);
        mockEntityManagerProvider = Mockito.mock(EntityManagerProvider.class);
        mockQuery = Mockito.mock(Query.class);
        mockResultList = new ArrayList<>();

        Mockito.when(mockEntityManagerProvider.getEntityManager()).thenReturn(mockEntityManager);
        Mockito.when(mockEntityManager.createQuery(Mockito.anyString())).thenReturn(mockQuery);
        Mockito.when(mockQuery.getResultList()).thenReturn(mockResultList);
    }

    public void setStatus()
    {
        this.status = new Status();
    }

    public void setPropertyType()
    {
        this.propertyType = new PropertyType();
    }

    public void setOperatingSystem()
    {
        this.operatingSystem = new OperatingSystem();
    }

    public void setBrand()
    {
        this.brand = new Brand();
    }

    public void setCategoryType()
    {
        this.categoryType = new CategoryType();
    }

    public Brand getBrand()
    {
        return brand;
    }

    public CategoryType getCategoryType()
    {
        return categoryType;
    }

    public OperatingSystem getOperatingSystem()
    {
        return operatingSystem;
    }

    public PropertyType getPropertyType()
    {
        return propertyType;
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