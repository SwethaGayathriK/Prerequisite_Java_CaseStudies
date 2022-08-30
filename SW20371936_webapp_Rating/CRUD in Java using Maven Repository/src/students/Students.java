/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author Adnan Afzal
 */
public class Students {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        JFrame frame = new JFrame("Students");
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(0, 1));
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        
        frame.add(new InsertJPanel());
        frame.setVisible(true);
    }
    
}
