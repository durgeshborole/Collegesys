package student.database.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class enterMarks extends JFrame implements ActionListener {
    JTextField sub1,sub2,sub3,sub4,sub5,marks1,marks2,marks3,marks4,marks5;
    Choice choice;
    JComboBox combobox;
    JButton submit,cancel;
    enterMarks(){

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icon/exam.png"));
        Image i2 = i.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(500,40,400,300);
        add(i4);


        JLabel tag = new JLabel("Enter marks of Student:");
        tag.setBounds(20,40,290,20);
        tag.setFont(new Font("Tahona",Font.BOLD,20));
        add(tag);

        JLabel heading = new JLabel("Select Roll No:");
        heading.setBounds(20,100,150,20);
        add(heading);

        choice = new Choice();
        choice.setBounds(180,100,150,20);
        add(choice);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from students");
            while (resultSet.next()){
                choice.add(resultSet.getString("rollNo"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel sem = new JLabel("Select Semester:");
        sem.setBounds(20,130,140,20);
        add(sem);

        String ar[] = {"Semester 1","Semester 2","Semester 3","Semester 4","Semester 5","Semester 6","Semester 7","Semester 8"};
        combobox = new JComboBox(ar);
        combobox.setBackground(Color.white);
        combobox.setBounds(180,130,150,20);
        add(combobox);

        JLabel h1 = new JLabel("Enter Subject:");
        h1.setBounds(70,160,150,30);
        add(h1);

        JLabel h2 = new JLabel("Enter Marks:");
        h2.setBounds(270,160,150,30);
        add(h2);

        sub1= new JTextField();
        sub1.setBounds(40,200,150,20);
        add(sub1);

        sub2= new JTextField();
        sub2.setBounds(40,230,150,20);
        add(sub2);

        sub3= new JTextField();
        sub3.setBounds(40,260,150,20);
        add(sub3);

        sub4= new JTextField();
        sub4.setBounds(40,290,150,20);
        add(sub4);

        sub5= new JTextField();
        sub5.setBounds(40,320,150,20);
        add(sub5);

        marks1= new JTextField();
        marks1.setBounds(230,200,150,20);
        add(marks1);

        marks2= new JTextField();
        marks2.setBounds(230,230,150,20);
        add(marks2);

        marks3= new JTextField();
        marks3.setBounds(230,260,150,20);
        add(marks3);

        marks4= new JTextField();
        marks4.setBounds(230,290,150,20);
        add(marks4);

        marks5= new JTextField();
        marks5.setBounds(230,320,150,20);
        add(marks5);

        submit = new JButton("Submit");
        submit.setBounds(80,380,90,20);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 380, 90, 20);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(1000,500);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
               try{
                   Conn c = new Conn();
                   String Q1 = "insert into subject values('"+choice.getSelectedItem()+"','"+combobox.getSelectedItem()+"','"+sub1.getText()+"','"+sub2.getText()+"','"+sub3.getText()+"','"+sub4.getText()+"','"+sub5.getText()+"')";
                   String Q2 = "insert into marks values('"+choice.getSelectedItem()+"','"+combobox.getSelectedItem()+"','"+marks1.getText()+"','"+marks2.getText()+"','"+marks3.getText()+"','"+marks4.getText()+"','"+marks5.getText()+"')";
                   c.statement.executeUpdate(Q1);
                   c.statement.executeUpdate(Q2);
                   JOptionPane.showMessageDialog(null,"Marks Inserted Succesfully");
                   setVisible(false);


               }catch (Exception t){
                   t.printStackTrace();
               }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new enterMarks();
    }
}
