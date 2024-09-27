package student.database.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JTextField textFieldName;
    JPasswordField textPassword;
    JButton login,revert,rregister;

    login(){
        JLabel LabelName = new JLabel("Username:");
        LabelName.setBounds(270,40,100,20);
        LabelName.setForeground(Color.black);
        add(LabelName);

        textFieldName= new JTextField();
        textFieldName.setBounds(350,40,150,20);
        add(textFieldName);

        JLabel labelpass = new JLabel("Password:");
        labelpass.setBounds(270,90,100,20);
        labelpass.setForeground(Color.black);
        add(labelpass);

        textPassword= new JPasswordField();
        textPassword.setBounds(350,90,150,20);
        add(textPassword);

        login = new JButton("Login");
        login.setBounds(280,140,120,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        revert = new JButton("Revert");
        revert.setBounds(410,140,120,30);
        revert.setBackground(Color.black);
        revert.setForeground(Color.WHITE);
        revert.addActionListener(this);
        add(revert);

        JLabel i = new JLabel("Not a user?");
        i.setBounds(300,180,150,30);
        i.setForeground(Color.BLACK);
        add(i);

        rregister = new JButton("Register");
        rregister.setBounds(370,180,90,20);
        rregister.setBackground(Color.black);
        rregister.setForeground(Color.WHITE);
        rregister.addActionListener(this);
        add(rregister);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/account.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(40,20,200,200);
        add(img);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/login.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,600,300);
        add(image);



        setSize(600,300);
        setLocation(500,300);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource()==login){
             String username = textFieldName.getText();
             String password = textPassword.getText();

             String query = "select * from login where username='"+username+"' and password='"+password+"'";
             try{
                 Conn c= new Conn();
                 ResultSet resultSet = c.statement.executeQuery(query);
                 if(resultSet.next()){
                     setVisible(false);
                     new main_class();
                 }else {
                     JOptionPane.showMessageDialog(null,"Invalid Username & Password");
                 }
             }catch(Exception E){
                 E.printStackTrace();
             }
         }if (e.getSource()== rregister){
             new register();
             setVisible(false);
        }

         else {
             setVisible(false);
         }
    }

    public static void main(String[] args) {
        new login();
    }
}
