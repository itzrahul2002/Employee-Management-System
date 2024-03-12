package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice cEmpid;
    JButton delete,back;
    RemoveEmployee(){
        getContentPane().setBackground(Color.black);
        setLayout(null);

        JLabel lblempid = new JLabel("Employee Id");
        lblempid.setBounds(50,50,100,30);
        lblempid.setForeground(Color.white);
        add(lblempid);

        cEmpid =new Choice();
        cEmpid.setBounds(200,50,120,30);
        cEmpid.setBackground(Color.black);
        cEmpid.setForeground(Color.white);
        add(cEmpid);

        try {
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs =c.s.executeQuery(query);
            while (rs.next()) {
                cEmpid.add(rs.getString("Employee_Id"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        labelname.setForeground(Color.white);
        add(labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(200,100,100,30);
        lblname.setForeground(Color.white);
        lblname.setBackground(Color.white);
        add(lblname);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50,150,100,30);
        labelphone.setForeground(Color.white);
        add(labelphone);

        JLabel lblphone = new JLabel();
        lblphone.setBounds(200,150,100,30);
        lblphone.setForeground(Color.white);
        lblphone.setBackground(Color.black);
        add(lblphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,200,100,30);
        labelemail.setForeground(Color.white);
        add(labelemail);

        JLabel lblemail = new JLabel();
        lblemail.setBounds(200,200,200,30);
        lblemail.setForeground(Color.white);
        lblemail.setBackground(Color.black);
        add(lblemail);

        try {
            Conn c = new Conn();
            String query = "select * from employee where Employee_Id ='"+cEmpid.getSelectedItem()+"'";
            ResultSet rs =c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("Name"));
                lblphone.setText(rs.getString("Phone"));
                lblemail.setText(rs.getString("Email_Address"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        cEmpid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from employee where Employee_Id ='"+cEmpid.getSelectedItem()+"'";
                    ResultSet rs =c.s.executeQuery(query);
                    while (rs.next()) {
                        lblname.setText(rs.getString("Name"));
                        lblphone.setText(rs.getString("Phone"));
                        lblemail.setText(rs.getString("Email_Address"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        delete = new JButton("Delete");
        delete.setForeground(Color.red);
        delete.setFont(new Font("serif", Font.BOLD,13));
        delete.setBackground(Color.white);
        delete.addActionListener(this);
        delete.setBounds(55,300,100,30);
        add(delete);

        back = new JButton("Back");
        back.setForeground(Color.red);
        back.setFont(new Font("serif", Font.BOLD,13));
        back.setBackground(Color.white);
        back.addActionListener(this);
        back.setBounds(220,300,100,30);
        add(back);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/del.gif"));
        Image i2 = i1.getImage().getScaledInstance(600,450,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,400,300);
        add(image);

        setBounds(200,150,900,400);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==delete){
            try {
                Conn c = new Conn();
                String query = "delete from employee where Employee_Id ='"+cEmpid.getSelectedItem()+"'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully");
                setVisible(false);
                new Home();
            }catch (Exception ir){
                ir.printStackTrace();
            }
        }else {
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
