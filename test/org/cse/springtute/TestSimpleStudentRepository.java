/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cse.springtute;

import java.util.*;
import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Tharindu
 */
public class TestSimpleStudentRepository {

    private static HashMap<Long, Student> studentsDb = new HashMap<Long, Student>();
    static Student s1;

    @BeforeClass
    public static void setup() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        context.start();

        s1 = (Student) context.getBean("stdnt1");

    }

    @Test
    public void saveStudent() {
        studentsDb.put(s1.getRegNumber(), s1);
        Student ss = studentsDb.get(s1.getRegNumber());
        if (ss == null) {
            Assert.fail("ss should not be null. but it is null. has not been saved to the db");
        }
    }

    @Test
    public void findStudent() {
        try {
            studentsDb.get(s1.getRegNumber());
        } catch (Exception e) {
            Assert.fail("exception not expected");
        }
    }

    @Test
    public void deleteStudent() {
        studentsDb.remove(s1.getRegNumber());
        Student ss = studentsDb.get(s1.getRegNumber());
        if (ss != null) {
            Assert.fail("ss should be null. but it is not");
        }
    }
}
