package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    JButton add,view,update,remove;
    Home(){
        getContentPane().setBackground(Color.black);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bck.gif"));
        Image i2 = i1.getImage().getScaledInstance(1100,650,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1100,650);
        add(image);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(660,10,400,40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("serif", Font.BOLD,30));
        image.add(heading);

        add = new JButton("Add Employee");
        add.setForeground(Color.red);
        add.setFont(new Font("serif", Font.BOLD,13));
        add.setBackground(Color.white);
        add.addActionListener(this);
        add.setBounds(730,70,150,40);
        image.add(add);

        view = new JButton("View Employee");
        view.setForeground(Color.black);
        view.setFont(new Font("serif", Font.BOLD,13));
        view.setBackground(Color.white);
        view.addActionListener(this);
        view.setBounds(920,70,150,40);
        image.add(view);

        update = new JButton("Update Employee");
        update.setForeground(Color.black);
        update.setFont(new Font("serif", Font.BOLD,13));
        update.setBackground(Color.white);
        update.addActionListener(this);
        update.setBounds(730,130,150,40);
        image.add(update);

        remove = new JButton("Remove Employee");
        remove.setForeground(Color.black);
        remove.setFont(new Font("serif", Font.BOLD,13));
        remove.setBackground(Color.white);
        remove.addActionListener(this);
        remove.setBounds(920,130,150,40);
        image.add(remove);




        setBounds(100,15,1100,650);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            setVisible(false);
            new AddEmployee();
        }
        else if(e.getSource()==view){
            setVisible(false);
            new ViewEmployee();
        }
        else if(e.getSource()==update){
            setVisible(false);
            new ViewEmployee();
        }else {
            setVisible(false);
            new RemoveEmployee();
        }
    }
    public static void main(String[] args) {
        new Home();
    }

}
