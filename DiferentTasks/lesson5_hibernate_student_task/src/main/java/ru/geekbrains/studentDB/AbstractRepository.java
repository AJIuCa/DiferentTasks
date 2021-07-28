package ru.geekbrains.studentDB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public abstract class AbstractRepository<T> {

    public abstract void initRepoWithDefaultData();
    public abstract List<T> showAll();
    public abstract T findById (long id);
    public abstract void insertObj(T i);
    public abstract void updateName(long id, String name);
    public abstract void deleteById(long id);

}
