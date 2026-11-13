package com.b745.controller;

import com.b745.dao.StudentDAO;
import com.b745.model.Student;

public class StudentMain {

	public static void main(String[] args) {
		Student st=new Student();
		st.setSname("Abhi");
		st.setMarks(100);
		StudentDAO s = new StudentDAO();
		String status=s.updateStudent(7, st);
		if(status.equals("Success")) {
			System.out.println(status);
		}else {
			System.out.println(status);
		}
//		String status=s.deleteStudentById(5);
//		if(status.equals("Success")) {
//			System.out.println("Deleted Successfully"); 
//		}else {
//			System.out.println("Something went wrong");
//		}
		//s.getStudentById(4);
		//s.getStudent();
//		Student st=new Student();
//		st.setStno(6);
//		st.setSname("Shashankkk");
//		st.setMarks(100);
//		s.insertStudent(st);
	}

}
