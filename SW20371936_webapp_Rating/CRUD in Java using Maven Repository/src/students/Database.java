/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Adnan Afzal
 */
public class Database {
    private Connection connection;
    private Statement statement;
    private final String URL = "jdbc:mysql://localhost/";
    private final String NAME = "itDept";
    private final String USER = "root";
    private final String PASS = "";
    
    public Database() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASS);
        statement = connection.createStatement();
        statement.execute("CREATE DATABASE IF NOT EXISTS " + NAME);
        
        connection = DriverManager.getConnection(URL + NAME, USER, PASS);
        statement = connection.createStatement();
        
        statement.execute("CREATE TABLE IF NOT EXISTS students("
                + "id INTEGER NOT NULL AUTO_INCREMENT,"
                + "roll INTEGER NOT NULL,"
                + "name VARCHAR(50),"
                + "gpa DOUBLE,"
                + "PRIMARY KEY (id))");
    }
    
    public void insertRecord(int roll, String name, double gpa) throws SQLException {
        statement.execute("INSERT INTO students(roll, name, gpa) VALUES(" + roll + ", '" + name + "', " + gpa + ")");
        JOptionPane.showMessageDialog(null, "Record inserted");
    }
    
    public void showAll() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
        while(resultSet.next()) {
            JOptionPane.showMessageDialog(null, "Roll: " + resultSet.getInt("roll") + 
                    "\nName: " + resultSet.getString("name") + 
                    "\nGPA: " + resultSet.getDouble("gpa"));
        }
    }
    
    public void updateRecord(int roll, String name, double gpa) throws SQLException {
        statement.execute("UPDATE students SET name='" + name + "', gpa=" + gpa + " WHERE roll=" + roll);
        JOptionPane.showMessageDialog(null, "Record updated");
    }
    
    public void deleteRecord(int roll) throws SQLException {
        statement.execute("DELETE FROM students WHERE roll=" + roll);
        JOptionPane.showMessageDialog(null, "Record deleted");
    }
}
