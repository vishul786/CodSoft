/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmangesystem;

import db.MyConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vishu
 */
public class Score {

    Connection con = MyConnect.getConnection();
    PreparedStatement ps;

    //get Table max row
    public int getMax() {
        int id = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery("select max(id) from score");
            while (res.next()) {
                id = res.getInt(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id + 1;
    }

    public boolean getDetails(int sid, int semesterNo) {
        try {
            ps = con.prepareStatement("select * from course where student_id=? and semester=? ");
            ps.setInt(1, sid);
            ps.setInt(2, semesterNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Home.jTextField14.setText(String.valueOf(rs.getInt(2)));
                Home.jTextField17.setText(String.valueOf(rs.getInt(3)));
                Home.course1.setText(rs.getString(4));
                Home.course2.setText(rs.getString(5));
                Home.course3.setText(rs.getString(6));
                Home.course4.setText(rs.getString(7));
                Home.course5.setText(rs.getString(8));
                // Home.course1.setText(rs.getString(2));
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Student's Id and semester doesn't exist!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //check id   already exist or not
    public boolean isIdExist(int id) {
        try {
            ps = con.prepareStatement("select * from score where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //check id   already exist or not
    public boolean isSideSemesterExist(int sid, int semesterNo) {
        try {
            ps = con.prepareStatement("select * from score where student_id=? and semester=?");
            ps.setInt(1, sid);
            ps.setInt(2, semesterNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //get all the course values from database course table
    public void getScoreValue(JTable table, String searchValue) {
        String sql = "select * from score where concat(id,Student_id,semester) like ? order by id desc";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchValue + "%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while (rs.next()) {
                row = new Object[14];
                row[0] = rs.getInt(1);
                row[1] = rs.getInt(2);
                row[2] = rs.getInt(3);
                row[3] = rs.getString(4);
                row[4] = rs.getDouble(5);
                row[5] = rs.getString(6);
                row[6] = rs.getDouble(7);
                row[7] = rs.getString(8);
                row[8] = rs.getDouble(9);
                row[9] = rs.getString(10);
                row[10] = rs.getDouble(11);
                row[11] = rs.getString(12);
                row[12] = rs.getDouble(13);
                row[13] = rs.getDouble(14);                         
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //insert data into course table   
    public void insert(int id, int sid, int semester, String course1, String course2, String course3, String course4, String course5,
            double score1, double score2, double score3, double score4, double score5, double average) {
        String sql = "insert into score values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, sid);
            ps.setInt(3, semester);
            ps.setString(4, course1);
            ps.setDouble(5, score1);
            ps.setString(6, course2);
            ps.setDouble(7, score2);
            ps.setString(8, course3);
            ps.setDouble(9, score3);
            ps.setString(10, course4);
            ps.setDouble(11, score3);
            ps.setString(12, course5);
            ps.setDouble(13, score3);
            ps.setDouble(14, average);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showConfirmDialog(null, "Score added successfully");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //update student value
    public void update(int id, double score1, double score2, double score3, double score4, double score5,double average) {

        try {
            String sql = " update score set score1=?,score2=?,score3=?,score4=?,score5=?,average=? where id =?";
            ps = con.prepareStatement(sql);
           // ps.setInt(1, id);
            ps.setDouble(1, score1);
            ps.setDouble(2, score2);
            ps.setDouble(3, score3);
            ps.setDouble(4, score4);
            ps.setDouble(5, score5);
            ps.setDouble(6,average);
            ps.setInt(7, id);
            

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Scoreis updated successfully!!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
