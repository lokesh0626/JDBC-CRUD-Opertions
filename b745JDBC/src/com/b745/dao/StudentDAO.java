package com.b745.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.b745.model.Student;
import com.b745.utility.DBConnection;

public class StudentDAO implements StudentDAOInterface {

	Connection con = null;
	String status = "fail";

	public void insertStudent(Student st) {
		try {

			con = DBConnection.getConnection();

			// Statement
			// Statement st = con.createStatement(); instead of this we are writing prepared
			// statement

			PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?)");
			ps.setInt(1, st.getStno());
			ps.setString(2, st.getSname());
			ps.setInt(3, st.getMarks());
			// Execute and get Result
			int n = ps.executeUpdate();
			if (n > 0) {
				System.out.println(n + "Rows effected");
			} else {
				System.out.println("Something went wrong");
			}
			// Closing the Connection
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void getStudent() {
		try {

			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + ":" + rs.getString(2) + ":" + rs.getInt(3));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void getStudentById(int stno) {
		try {
			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from student where stno=?");
			ps.setInt(1, stno);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + ":" + rs.getString(2) + ":" + rs.getInt(3));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public String deleteStudentById(int stno) {
		try {

			con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from student where stno=?");
			ps.setInt(1, stno);
			int n = ps.executeUpdate();
			if (n > 0) {
				status = "Success";
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	public String updateStudent(int stno, Student st) {

		try {
			con = DBConnection.getConnection();
			PreparedStatement ps1 = con.prepareStatement("select * from student where stno=?");
			ps1.setInt(1, stno);
			ResultSet rs = ps1.executeQuery();
			int count = 0;
			while (rs.next()) {
				count++;
			}

			if (count > 0) {
				PreparedStatement ps = con.prepareStatement("update student set sname=?,marks=? where stno=?");
				ps.setString(1, st.getSname());
				ps.setInt(2, st.getMarks());
				ps.setInt(3, stno);

				int n = ps.executeUpdate();
				if (n > 0) {
					status = "Record Updated Successfully";
				}

			} else {
				status = stno + ":not found";
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;

	}

}
