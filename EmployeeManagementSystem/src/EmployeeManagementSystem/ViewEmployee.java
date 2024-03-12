package EmployeeManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {
    JTable table;
    Choice cempid;
    JButton search,print,update,back;
    ViewEmployee(){
        getContentPane().setBackground(Color.black);
        setLayout(null);

        JLabel lblsearch = new JLabel("Search By Employee Id");
        lblsearch.setForeground(Color.white);
        lblsearch.setBackground(Color.white);
        lblsearch.setBounds(20,20,150,30);
        add(lblsearch);

        cempid = new Choice();
        cempid.setBounds(180,26,150,20);
        cempid.setForeground(Color.white);
        cempid.setBackground(Color.black);
        add(cempid);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM employee");
            while (rs.next()){
                cempid.add(rs.getString("Employee_Id"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        table.setBackground(Color.black);
        table.setForeground(Color.white);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,120,1000,600);
        add(jsp);

        search = new JButton("Search");
        search.setForeground(Color.red);
        search.setFont(new Font("serif", Font.BOLD,13));
        search.setBackground(Color.white);
        search.addActionListener(this);
        search.setBounds(20,70,100,25);
        add(search);

        print = new JButton("Print");
        print.setForeground(Color.red);
        print.setFont(new Font("serif", Font.BOLD,13));
        print.setBackground(Color.white);
        print.addActionListener(this);
        print.setBounds(140,70,100,25);
        add(print);

        update = new JButton("Update");
        update.setForeground(Color.red);
        update.setFont(new Font("serif", Font.BOLD,13));
        update.setBackground(Color.white);
        update.addActionListener(this);
        update.setBounds(260,70,100,25);
        add(update);

        back = new JButton("Back");
        back.setForeground(Color.red);
        back.setFont(new Font("serif", Font.BOLD,13));
        back.setBackground(Color.white);
        back.addActionListener(this);
        back.setBounds(380,70,100,25);
        add(back);




        setBounds(160,40,1000,600);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String query = "select * from employee where Employee_Id = '"+cempid.getSelectedItem()+"'";

            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception fe){
                fe.printStackTrace();
            }
        }else if(e.getSource()==print){
            try {
                table.print();

            }catch (Exception ee){
                ee.printStackTrace();
            }

        }else if(e.getSource()==update){
            setVisible(false);
            new UpdateEmployee(cempid.getSelectedItem());
        }else {
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args) {
        new ViewEmployee();
    }

}
