package models.persistence.dao;

import models.persistence.dao.play.EntityManagerProvider;
<<<<<<< HEAD
import models.persistence.entities.*;
=======
import models.persistence.entities.OperatingSystem;
import models.persistence.entities.PropertyType;
import models.persistence.entities.Status;
>>>>>>> 6deadbe746ee20d4203467e07c086415a21cfe1c
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
<<<<<<< HEAD
    private CategoryType categoryType;
    private Brand brand;
=======
>>>>>>> 6deadbe746ee20d4203467e07c086415a21cfe1c

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

<<<<<<< HEAD
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

=======
>>>>>>> 6deadbe746ee20d4203467e07c086415a21cfe1c
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
