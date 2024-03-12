package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {
    JButton click;
    Splash(){
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);


        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(100,10,1200,80);
        heading.setFont(new Font("serif", Font.BOLD,65));
//        heading.setForeground(Color.red);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/emp.gif"));
        Image i2 = i1.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(-1,100,1090,550);
        add(image);

        click = new JButton("CLICK TO CONTINUE ➡️");
        click.setForeground(Color.WHITE);
        click.setFont(new Font("serif", Font.BOLD,13));
        click.setBackground(Color.black);
        click.addActionListener(this);
        click.setBounds(400,450,200,50);
        image.add(click);



        setBounds(100,10,1100,650);
        setVisible(true);

        while (true){
            heading.setVisible(false);
            heading.setForeground(new java.awt.Color(204, 166, 166));
            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }

            heading.setVisible(true);
            heading.setForeground(new java.awt.Color(30, 0, 179));
            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==click){
            new Login();
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Splash();
    }
}
