package EmployeeManagementSystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    Random ran = new Random();
    JTextField tfname,tffname,tfsalary,tfaddress,tfphone,tfemail,tfdesignation,tfaadhar;
    JComboBox cbeducation;
    JDateChooser tfdob;
    JLabel tfdemp;
    int number= ran.nextInt(999999);
    JButton add,back;
    AddEmployee(){
        getContentPane().setBackground(Color.black);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setForeground(Color.white);
        heading.setFont(new Font("serif", Font.BOLD,30));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,150,30);
        lblname.setForeground(Color.white);
        lblname.setFont(new Font("serif", Font.PLAIN,20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        tfname.setBackground(Color.white);
        add(tfname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(430,150,150,30);
        lblfname.setForeground(Color.white);
        lblfname.setFont(new Font("serif", Font.PLAIN,20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        tffname.setBackground(Color.white);
        add(tffname);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(50,200,150,30);
        lbldob.setForeground(Color.white);
        lbldob.setFont(new Font("serif", Font.PLAIN,20));
        add(lbldob);

        tfdob = new JDateChooser();
        tfdob.setBounds(200,200,150,30);
        tfdob.setBackground(Color.white);
        add(tfdob);

        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setBounds(430,200,150,30);
        lblsalary.setForeground(Color.white);
        lblsalary.setFont(new Font("serif", Font.PLAIN,20));
        add(lblsalary);

         tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        tfsalary.setBackground(Color.white);
        add(tfsalary);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,250,150,30);
        lbladdress.setForeground(Color.white);
        lbladdress.setFont(new Font("serif", Font.PLAIN,20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        tfaddress.setBackground(Color.white);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(430,250,150,30);
        lblphone.setForeground(Color.white);
        lblphone.setFont(new Font("serif", Font.PLAIN,20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        tfphone.setBackground(Color.white);
        add(tfphone);


        JLabel lblemail= new JLabel("Email Address");
        lblemail.setBounds(50,300,150,30);
        lblemail.setForeground(Color.white);
        lblemail.setFont(new Font("serif", Font.PLAIN,20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        tfemail.setBackground(Color.white);
        add(tfemail);

        JLabel lbleducation = new JLabel("Higest Education");
        lbleducation.setBounds(430,300,150,30);
        lbleducation.setForeground(Color.white);
        lbleducation.setFont(new Font("serif", Font.PLAIN,20));
        add(lbleducation);

        String course[] = {"BBA","BCA","BA","MTech","BSC","B.Com","B.Tech"};
        cbeducation = new JComboBox(course);
        cbeducation.setBounds(600,300,150,30);
        cbeducation.setBackground(Color.white);
        add(cbeducation);

        JLabel lbldegination = new JLabel("Designation");
        lbldegination.setBounds(50,350,150,30);
        lbldegination.setForeground(Color.white);
        lbldegination.setFont(new Font("serif", Font.PLAIN,20));
        add(lbldegination);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        tfdesignation.setBackground(Color.white);
        add(tfdesignation);

        JLabel lbladhar = new JLabel("Aadhar Number");
        lbladhar.setBounds(430,350,150,30);
        lbladhar.setForeground(Color.white);
        lbladhar.setFont(new Font("serif", Font.PLAIN,20));
        add(lbladhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        tfaadhar.setBackground(Color.white);
        add(tfaadhar);


        JLabel lbldempid = new JLabel("Employee Id");
        lbldempid.setBounds(50,400,150,30);
        lbldempid.setForeground(Color.white);
        lbldempid.setFont(new Font("serif", Font.PLAIN,20));
        add(lbldempid);

        tfdemp = new JLabel(" "+number);
        tfdemp.setBounds(200,400,150,30);
        tfdemp.setForeground(Color.white);
        add(tfdemp);

        add = new JButton("Submit");
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
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String name =tfname.getText();
            String fname =tffname.getText();
            String dob = ((JTextField)tfdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            String aadhar = tfaadhar.getText();
            String empid = tfdemp.getText();

            try{
                Conn c = new Conn();

//                String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+",'"+education+"','"+designation+"','"+aadhar+"','"+empid+"')";
                String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empid+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Details Inserted Successfully");
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
        new AddEmployee();
    }
}
