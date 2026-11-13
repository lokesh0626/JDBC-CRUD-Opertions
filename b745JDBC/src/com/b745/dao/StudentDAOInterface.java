package com.b745.dao;

import com.b745.model.Student;

public interface StudentDAOInterface {
   public void insertStudent(Student st);
   public void getStudent();
   public void getStudentById(int stno);
   public String deleteStudentById(int stno);
   public String updateStudent(int stno, Student s);
}
