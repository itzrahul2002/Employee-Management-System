package EmployeeManagementSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class UpdateEmployee extends JFrame implements ActionListener {
    Random ran = new Random();
    JTextField tfeducation, tfname,tffname,tfsalary,tfaddress,tfphone,tfemail,tfdesignation,tfaadhar;
    JLabel lbalempid;
    JButton add,back;
    String empId;
    UpdateEmployee(String empId){
        this.empId = empId;
        getContentPane().setBackground(Color.black);
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setForeground(Color.white);
        heading.setFont(new Font("serif", Font.BOLD,30));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,150,30);
        lblname.setForeground(Color.white);
        lblname.setFont(new Font("serif", Font.PLAIN,20));
        add(lblname);


        JLabel labelname = new JLabel();
        labelname.setBounds(200,150,150,30);
        labelname.setBackground(Color.white);
        labelname.setForeground(Color.white);
        add(labelname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(430,150,150,30);
        lblfname.setForeground(Color.white);
        lblfname.setFont(new Font("serif", Font.PLAIN,20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        tffname.setForeground(Color.BLACK);
        add(tffname);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(50,200,150,30);
        lbldob.setForeground(Color.white);
        lbldob.setFont(new Font("serif", Font.PLAIN,20));
        add(lbldob);


        JLabel labeldob = new JLabel();
        labeldob.setBounds(200,200,150,30);
        labeldob.setBackground(Color.white);
        labeldob.setForeground(Color.white);
        add(labeldob);

        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setBounds(430,200,150,30);
        lblsalary.setForeground(Color.white);
        lblsalary.setFont(new Font("serif", Font.PLAIN,20));
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        tfsalary.setBackground(Color.black);
        tfsalary.setForeground(Color.white);
        add(tfsalary);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,250,150,30);
        lbladdress.setForeground(Color.white);
        lbladdress.setFont(new Font("serif", Font.PLAIN,20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        tfaddress.setBackground(Color.black);
        tfaddress.setForeground(Color.white);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(430,250,150,30);
        lblphone.setForeground(Color.white);
        lblphone.setFont(new Font("serif", Font.PLAIN,20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        tfphone.setBackground(Color.black);
        tfphone.setForeground(Color.white);
        add(tfphone);


        JLabel lblemail= new JLabel("Email Address");
        lblemail.setBounds(50,300,150,30);
        lblemail.setForeground(Color.white);
        lblemail.setFont(new Font("serif", Font.PLAIN,20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        tfemail.setBackground(Color.black);
        tfemail.setForeground(Color.white);
        add(tfemail);

        JLabel lbleducation = new JLabel("Higest Education");
        lbleducation.setBounds(430,300,150,30);
        lbleducation.setForeground(Color.white);
        lbleducation.setFont(new Font("serif", Font.PLAIN,20));
        add(lbleducation);

        tfeducation = new JTextField();
        tfeducation.setBounds(600,300,150,30);
        tfeducation.setBackground(Color.black);
        tfeducation.setForeground(Color.white);
        add(tfeducation);

        JLabel lbldegination = new JLabel("Designation");
        lbldegination.setBounds(50,350,150,30);
        lbldegination.setForeground(Color.white);
        lbldegination.setFont(new Font("serif", Font.PLAIN,20));
        add(lbldegination);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        tfdesignation.setBackground(Color.black);
        tfdesignation.setForeground(Color.white);
        add(tfdesignation);

        JLabel lbladhar = new JLabel("Aadhar Number");
        lbladhar.setBounds(430,350,150,30);
        lbladhar.setForeground(Color.white);
        lbladhar.setFont(new Font("serif", Font.PLAIN,20));
        add(lbladhar);

        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(600,350,150,30);
        labelaadhar.setBackground(Color.white);
        labelaadhar.setForeground(Color.white);
        add(labelaadhar);


        JLabel lbldempid = new JLabel("Employee Id");
        lbldempid.setBounds(50,400,150,30);
        lbldempid.setForeground(Color.white);
        lbldempid.setFont(new Font("serif", Font.PLAIN,20));
        add(lbldempid);

        lbalempid = new JLabel();
        lbalempid.setBounds(200,400,150,30);
        lbalempid.setBackground(Color.black);
        lbalempid.setForeground(Color.white);
        add(lbalempid);

        try{
            Conn c = new Conn();
            String query = "SELECT * from employee where Employee_Id ='"+empId+"' ";

            ResultSet  rs =c.s.executeQuery(query);

            while (rs.next()){
                labelname.setText(rs.getString("Name"));
                tffname.setText(rs.getString("Father_Name"));
                labeldob.setText(rs.getString("Date_of_Birth"));
                tfsalary.setText(rs.getString("Salary"));
                tfaddress.setText(rs.getString("Address"));
                tfphone.setText(rs.getString("Phone"));
                tfsalary.setText(rs.getString("Salary"));
                tfemail.setText(rs.getString("Email_Address"));
                tfeducation.setText(rs.getString("Education"));;
                tfdesignation.setText(rs.getString("Designation"));
                labelaadhar.setText(rs.getString("Aadhar_Number"));
                lbalempid.setText(rs.getString("Employee_Id"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        add = new JButton("Update Details");
        add.setForeground(Color.red);
        add.setFont(new Font("serif", Font.BOLD,13));
        add.setBackground(Color.white);
        add.addActionListener(this);
        add.setBounds(250,480,150,40);
        add(add);

        back = new JButton("Back");
        back.setForeground(Color.red);
        back.setFont(new Font("serif", Font.BOLD,13));
        back.setBackground(Color.white);
        back.addActionListener(this);
        back.setBounds(450,480,150,40);
        add(back);

        setBounds(200,40,880,600);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ee) {
        if(ee.getSource()==add){
            String fname =tffname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education =tfeducation.getText();
            String designation = tfdesignation.getText();


            try{
                Conn c = new Conn();

                String query = "update employee set Father_Name = '"+fname+"', Salary ='"+salary+"', Address = '"+address+"', Phone='"+phone+"',Email_Address='"+email+"',Education='"+education+"',Designation='"+designation+"' where Employee_Id ='"+empId+"'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Details Updated Successfully");
                setVisible(false);
                new Home();
            }catch (Exception ae) {
                ae.printStackTrace();
            }
        }
        else {
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
