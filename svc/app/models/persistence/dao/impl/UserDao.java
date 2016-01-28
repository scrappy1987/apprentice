package models.persistence.dao.impl;

import com.google.inject.Inject;
import models.persistence.dao.GenericDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.User;

/**
 * Created by a613794 on 28/01/2016.
 */
public class UserDao extends GenericDao<User> {
    @Inject
    public UserDao(EntityManagerProvider emp)
    {
        super(emp);
    }
}
