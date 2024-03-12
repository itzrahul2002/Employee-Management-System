package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField tfusername,tfpassword;
    JButton login;
    Login(){

        getContentPane().setBackground(Color.black);
        setLayout(null);

        JLabel lblname = new JLabel("UserName");
        lblname.setBounds(40,40,100,30);
        lblname.setFont(new Font("Tahoma", Font.BOLD,14));
        lblname.setForeground(Color.white);
        add(lblname);

        tfusername = new JTextField();
        tfusername.setBounds(150,40,150,30);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,100,100,30);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD,14));
        lblpassword.setForeground(Color.white);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,100,150,30);
        add(tfpassword);

        login = new JButton("LOGIN");
        login.setForeground(Color.black);
        login.setFont(new Font("Tahoma", Font.BOLD,13));
        login.setBackground(Color.WHITE);
        login.addActionListener(this);
        login.setBounds(150,180,150,30);
        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.gif"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(250,-50,400,370);
        add(image);


        setBounds(350,200,600,300);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String username =tfusername.getText();
            String password =tfpassword.getText();

            Conn c = new Conn();
            String query ="select * from login where UserName ='"+username+"'and Password ='"+password+"'";

            ResultSet rs = c.s.executeQuery(query);

            if(rs.next()) {
                setVisible(false);
                new Home();
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Username or Password ❌");
                setVisible(false);
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Login();
    }

}
