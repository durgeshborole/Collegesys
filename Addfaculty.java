package student.database.management;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Addfaculty extends JFrame implements ActionListener {

    JTextField textName,textFName,tAddress,tPhone,t10,t12,tAadhaar,tEmail,texpertise,texp;
    JDateChooser cDob;
    JLabel empL;
    JComboBox Cb,Cb1;
    Random ran= new Random();
    JButton submit,Cancel;
    long f4 = Math.abs((ran.nextLong() % 9000L) + 1000L );
    Addfaculty(){
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel name = new JLabel("Name:");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        textName = new JTextField();
        textName.setBounds(120,150,200,30);
        add(textName);

        JLabel fName = new JLabel("Father's Name:");
        fName.setBounds(425,150,200,30);
        fName.setFont(new Font("serif",Font.BOLD,20));
        add(fName);

        textFName = new JTextField();
        textFName.setBounds(600,150,200,30);
        add(textFName);

        JLabel empId = new JLabel("Employee Id:");
        empId.setBounds(50,200,200,30);
        empId.setFont(new Font("serif",Font.BOLD,20));
        add(empId);

        empL = new JLabel("6901"+f4);
        empL.setBounds(200,200,200,30);
        empL.setFont(new Font("serif",Font.BOLD,20));
        add(empL);

        JLabel DoB = new JLabel("Date of Birth:");
        DoB.setBounds(425,200,200,30);
        DoB.setFont(new Font("serif",Font.BOLD,20));
        add(DoB);

        cDob = new JDateChooser();
        cDob.setBounds(600,200,150,30);
        add(cDob);

        JLabel Address = new JLabel("Address:");
        Address.setBounds(50,250,200,30);
        Address.setFont(new Font("serif",Font.BOLD,20));
        add(Address);

        tAddress = new JTextField();
        tAddress.setBounds(150,250,200,30);
        add(tAddress);

        JLabel Phone = new JLabel("Phone No:");
        Phone.setBounds(425,250,200,30);
        Phone.setFont(new Font("serif",Font.BOLD,20));
        add(Phone);

        tPhone = new JTextField();
        tPhone.setBounds(600,250,200,30);
        add(tPhone);

        JLabel Email = new JLabel("Email:");
        Email.setBounds(50,300,200,30);
        Email.setFont(new Font("serif",Font.BOLD,20));
        add(Email);

        tEmail = new JTextField();
        tEmail.setBounds(185,300,200,30);
        add(tEmail);

        JLabel M10 = new JLabel("Class 10th(%):");
        M10.setBounds(425,300,200,30);
        M10.setFont(new Font("serif",Font.BOLD,20));
        add(M10);

        t10 = new JTextField();
        t10.setBounds(600,300,200,30);
        add(t10);

        JLabel M12 = new JLabel("Class 12th(%):");
        M12.setBounds(50,350,200,30);
        M12.setFont(new Font("serif",Font.BOLD,20));
        add(M12);

        t12 = new JTextField();
        t12.setBounds(185,350,200,30);
        add(t12);

        JLabel Aadhaar = new JLabel("Aadhaar No:");
        Aadhaar.setBounds(425,350,200,30);
        Aadhaar.setFont(new Font("serif",Font.BOLD,20));
        add(Aadhaar);

        tAadhaar = new JTextField();
        tAadhaar.setBounds(600,350,150,30);
        add(tAadhaar);

        JLabel Qualification = new JLabel("Qualifications:");
        Qualification.setBounds(50,400,200,30);
        Qualification.setFont(new Font("serif",Font.BOLD,20));
        add(Qualification);

        String course[]= {"Select","B.Tech","BBA","M.Tech","PHD","BCA","BSC","MBA","MSC","MCom","MS"};
        Cb = new JComboBox(course);
        Cb.setBounds(185,400,200,30);
        Cb.setBackground(Color.white);
        add(Cb);

        JLabel Department = new JLabel("Department:");
        Department.setBounds(425,400,200,30);
        Department.setFont(new Font("serif",Font.BOLD,20));
        add(Department);

        String Branch[]= {"Select","Computer Science ","Electronics & Communication","Mechanical","Civil","Electronics & Computer Science"};
        Cb1 = new JComboBox(Branch);
        Cb1.setBounds(600,400,200,30);
        Cb1.setBackground(Color.white);
        add(Cb1);

        JLabel expertise = new JLabel("Expertise:");
        expertise.setBounds(50,450,200,30);
        expertise.setFont(new Font("serif",Font.BOLD,20));
        add(expertise);

        texpertise = new JTextField();
        texpertise.setBounds(185,450,200,30);
        add(texpertise);

        JLabel exp = new JLabel("Year of Experience:");
        exp.setBounds(425,450,200,30);
        exp.setFont(new Font("serif",Font.BOLD,20));
        add(exp);

        texp = new JTextField();
        texp.setBounds(625,450,200,30);
        add(texp);

        submit = new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.black);
        submit.addActionListener(this);
        add(submit);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(450,550,120,30);
        Cancel.setForeground(Color.WHITE);
        Cancel.setBackground(Color.black);
        Cancel.addActionListener(this);
        add(Cancel);

        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String name = textName.getText();
            String fName = textFName.getText();
            String empId = empL.getText();
            String DoB = ((JTextField)cDob.getDateEditor().getUiComponent()).getText();
            String Address = tAddress.getText();
            String Phone = tPhone.getText();
            String Email = tEmail.getText();
            String x = t10.getText();
            String xii = t12.getText();
            String Aadhhar = tAadhaar.getText();
            String course = (String) Cb.getSelectedItem();
            String dept = (String) Cb1.getSelectedItem();
            String expertise = texpertise.getText();
            String experience = texp.getText();
            try{
                String q = "insert into teacher values('"+name+"','"+fName+"','"+empId+"','"+DoB+"','"+Address+"','"+Phone+"','"+Email+"','"+x+"','"+xii+"','"+Aadhhar+"','"+course+"','"+dept+"','"+expertise+"','"+experience +"')";
                Conn c = new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Deatils Inserted");
                setVisible(false);

            }catch(Exception e2){
                e2.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Addfaculty();
    }
}
