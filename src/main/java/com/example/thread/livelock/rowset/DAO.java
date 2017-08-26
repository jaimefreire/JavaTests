package com.example.thread.livelock.rowset;

import com.sun.rowset.CachedRowSetImpl;

import javax.sql.RowSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DAO {

    final RowSet rowSet;

    public DAO(RowSet rowSet) {
        this.rowSet = rowSet;
    }

    public void addEmployee(int id, String name, String phone, String email, float salary, String designation) {
        try {
            rowSet.moveToInsertRow();
            rowSet.updateInt("empId", id);
            rowSet.updateString("empName", name);
            rowSet.updateString("phone", phone);
            rowSet.updateString("email", email);
            rowSet.updateFloat("salary", salary);
            rowSet.updateString("desig", designation);
            rowSet.insertRow();
            rowSet.moveToCurrentRow();
//            rowSet.first();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteLastEmployee() {
        try {
            rowSet.last();
            rowSet.deleteRow();
            rowSet.beforeFirst();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void showEmployees() {
        try {
            ResultSetMetaData metaData = rowSet.getMetaData();
            int noOfCols = metaData.getColumnCount();
            System.out.println("Employees");

            for (int i = 1; i <= noOfCols; i++) {
                System.out.printf("%-20s\t", metaData.getColumnName(i));
            }
            System.out.println();

            while (rowSet.next()) {
                for (int i = 1; i <= noOfCols; i++) {
                    System.out.printf("%-20s\t", rowSet.getObject(i));
                }
                System.out.println();
            }
            rowSet.beforeFirst();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

