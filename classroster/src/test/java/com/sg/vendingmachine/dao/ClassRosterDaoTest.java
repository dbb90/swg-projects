package com.sg.vendingmachine.dao;


import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoFileImpl;
import com.sg.classroster.dto.Student;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dbb09
 */
public class ClassRosterDaoTest {
    
    private final ClassRosterDao dao = new ClassRosterDaoFileImpl();

        
    public ClassRosterDaoTest() {

    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }
    
    
    @Before
public void setUp() throws Exception {
    List<Student> studentList = dao.getAllStudents();
    for (Student student : studentList) {
        dao.removeStudent(student.getStudentId());
    }
}

@Test
public void testAddGetStudent() throws Exception {
    Student student = new Student("0001");
    student.setFirstName("Joe");
    student.setLastName("Smith");
    student.setCohort("Java-May-2000");
   
    dao.addStudent(student.getStudentId(), student);
   
    Student fromDao = dao.getStudent(student.getStudentId());
   
    assertEquals(student, fromDao);
}


@Test
public void testGetAllStudents() throws Exception {
    Student student1 = new Student("0001");
    student1.setFirstName("Joe");
    student1.setLastName("Smith");
    student1.setCohort("Java-May-2000");
   
    dao.addStudent(student1.getStudentId(), student1);
   
    Student student2 = new Student("0002");
    student2.setFirstName("John");
    student2.setLastName("Doe");
    student2.setCohort(".NET-May-2000");
   
    dao.addStudent(student2.getStudentId(), student2);
   
    assertEquals(2, dao.getAllStudents().size());
   
}

@Test
public void testRemoveStudent() throws Exception {
    Student student1 = new Student("0001");
    student1.setFirstName("Joe");
    student1.setLastName("Smith");
    student1.setCohort("Java-May-2000");
   
    dao.addStudent(student1.getStudentId(), student1);
   
    Student student2 = new Student("0002");
    student2.setFirstName("John");
    student2.setLastName("Doe");
    student2.setCohort(".NET-May-2000");
   
    dao.addStudent(student2.getStudentId(), student2);
   
    dao.removeStudent(student1.getStudentId());
    assertEquals(1, dao.getAllStudents().size());
    assertNull(dao.getStudent(student1.getStudentId()));
   
    dao.removeStudent(student2.getStudentId());
    assertEquals(0, dao.getAllStudents().size());
    assertNull(dao.getStudent(student2.getStudentId()));
          
}
}
