package ru.geekbrains.studentDB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class StudentRepository extends AbstractRepository {

    private final EntityManagerFactory entityManagerFactory;

    public StudentRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void initRepoWithDefaultData() {
        int defaultNumberOfStudents = 1000;

        for (int i = 0; i < defaultNumberOfStudents; i++) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            String name = "student-" + (i + 1);
            Student student = new Student(name);
            entityManager.persist(student);
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }

    @Override
    public List showAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Student> productList = entityManager.createQuery("from Student", Student.class).getResultList();
        entityManager.close();
        return productList;
    }

    @Override
    public Student findById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = entityManager.find(Student.class, id);
        entityManager.close();
        return student;
    }

    @Override
    public void insertObj(Object student) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(student);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public void insert (String name,int mark) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Student student = new Student(name,mark);
        entityManager.persist(student);

        entityManager.getTransaction().commit();
        entityManager.close();

    }


    @Override
    public void updateName(long id, String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = entityManager.find(Student.class, id);
        entityManager.getTransaction().begin();
        student.setName(name);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateMark(long id, int mark) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = entityManager.find(Student.class, id);
        entityManager.getTransaction().begin();
        student.setMark(mark);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateAllInfo(long id,String name, int mark) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = entityManager.find(Student.class, id);
        entityManager.getTransaction().begin();
        student.setName(name);
        student.setMark(mark);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    @Override
    public void deleteById(long id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Object delProduct = entityManager.find(Student.class, id);
        if (delProduct != null) {
            entityManager.remove(delProduct);
            entityManager.getTransaction().commit();
        } else {
            System.out.println("Product not found");
        }
        entityManager.close();
    }
}



