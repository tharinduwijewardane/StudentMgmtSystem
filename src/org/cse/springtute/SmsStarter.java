package org.cse.springtute;

import org.springframework.context.support.*;

public class SmsStarter {

    public static void main(String[] args) {

        StudentManagementSystem sms = new StudentManagementSystem();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        context.start();

        System.out.println();

        //load the bean from spring
        Student stdnt = (Student) context.getBean("stdnt1");
        sms.registerStudent(stdnt);
        sms.listAllStudents();

        System.out.println();

        Student s2 = new Student("Isuru", "Jayaweera", 100227, "Veyangoda");
        Student s3 = new Student("Chmath", "Sajeewa", 100470, "Mathara");

        sms.registerStudent(s2);
        sms.registerStudent(s3);
        sms.listAllStudents();

    }
}
