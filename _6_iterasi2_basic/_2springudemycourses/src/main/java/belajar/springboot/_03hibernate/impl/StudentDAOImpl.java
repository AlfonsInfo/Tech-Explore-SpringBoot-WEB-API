package belajar.springboot._03hibernate.impl;

import belajar.springboot._03hibernate.dao.StudentDAO;
import belajar.springboot._03hibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Slf4j
public class StudentDAOImpl implements StudentDAO {


    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public List<Student> readAll() {
        //* Hbernate dont care what name in database, use class name.
        String query = "from Student";
        return entityManager.createQuery(query, Student.class).getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        log.info("Update DAO");
        Student attachedStudent = entityManager.merge(student);
        entityManager.persist(attachedStudent);
        log.info("End Of Update DAO");
    }

    @Override
    @Transactional
    public void delete(Student student) {
        log.info("Delete DAO");
        entityManager.remove(entityManager.contains(student) ? student : entityManager.merge(student));
    }
}
