package com.lifesup.jpadata;

import com.lifesup.jpadata.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class JpaDataApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testMockData() {
        Employee emp = new Employee();
        emp.setAge(25);
        emp.setName("Hong");

        // mock data
        EntityManager entityManager = mock(EntityManager.class);
        when(entityManager.find(Employee.class, 1L)).thenReturn(emp);

//        Employee empData = (Employee) entityManager.createQuery("FROM Employee e WHERE e.id = :id")
//                .setParameter("id", 1L)
//                .getSingleResult();
        Employee empData = entityManager.find(Employee.class, 1L);
        assertEquals("Hong", empData.getName());
    }
}
