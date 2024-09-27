package student.database.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Updatestudent extends JFrame implements ActionListener {
    JTextField tAddress,tPhone,tAadhaar,tEmail,tcourse,tdept;
    JLabel empL;
    JButton submit,Cancel;
    Choice crollNo;
    Updatestudent(){

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,35));
        add(heading);

        JLabel empId1 = new JLabel("Select Student:");
        empId1.setBounds(50,100,200,30);
        empId1.setFont(new Font("serif",Font.PLAIN,20));
        add(empId1);

        crollNo = new Choice();
        crollNo.setBounds(250,100,200,20);
        add(crollNo);

        try{
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from students");
            while(rs.next()){
                crollNo.add(rs.getString("rollNo"));
            }
        }catch (Exception c){
            c.printStackTrace();
        }


        JLabel name = new JLabel("Name:");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        JLabel textName = new JLabel();
        textName.setBounds(120,150,200,30);
        add(textName);

        JLabel fName = new JLabel("Father's Name:");
        fName.setBounds(425,150,200,30);
        fName.setFont(new Font("serif",Font.BOLD,20));
        add(fName);

        JLabel textFName = new JLabel();
        textFName.setBounds(600,150,200,30);
        add(textFName);

        JLabel empId = new JLabel("Employee Id:");
        empId.setBounds(50,200,200,30);
        empId.setFont(new Font("serif",Font.BOLD,20));
        add(empId);

        empL = new JLabel();
        empL.setBounds(200,200,200,30);
        empL.setFont(new Font("serif",Font.BOLD,20));
        add(empL);

        JLabel DoB = new JLabel("Date of Birth:");
        DoB.setBounds(425,200,200,30);
        DoB.setFont(new Font("serif",Font.BOLD,20));
        add(DoB);

        JLabel dDob = new JLabel();
        dDob.setBounds(600,200,150,30);
        add(dDob);

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

        JLabel t10 = new JLabel();
        t10.setBounds(600,300,200,30);
        add(t10);

        JLabel M12 = new JLabel("Class 12th(%):");
        M12.setBounds(50,350,200,30);
        M12.setFont(new Font("serif",Font.BOLD,20));
        add(M12);

        JLabel t12 = new JLabel();
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

        tcourse = new JTextField();
        tcourse.setBounds(200,400,200,30);
        add(tcourse);

        JLabel Department = new JLabel("Department:");
        Department.setBounds(425,400,200,30);
        Department.setFont(new Font("serif",Font.BOLD,20));
        add(Department);

        tdept = new JTextField();
        tdept.setBounds(600,400,150,30);
        add(tdept);


        try{
            Conn c =  new Conn();
            String query = "select * from students where rollNo = '"+crollNo.getSelectedItem()+"'";
            ResultSet resultset = c.statement.executeQuery(query);
            while(resultset.next()){
                textName.setText(resultset.getString("name"));
                textFName.setText(resultset.getString("fname"));
                dDob.setText(resultset.getString("DoB"));
                tAddress.setText(resultset.getString("Address"));
                tPhone.setText(resultset.getString("Phone"));
                tEmail.setText(resultset.getString("email"));
                t10.setText(resultset.getString("M10"));
                t12.setText(resultset.getString("M12"));
                tAadhaar.setText(resultset.getString("Aadhaar"));
                empL.setText(resultset.getString("rollNo"));
                tcourse.setText(resultset.getString("course"));
                tdept.setText(resultset.getString("branch"));

            }

        }catch (Exception r ){
            r.printStackTrace();
        }

        crollNo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c =  new Conn();
                    String query = "select * from teacher where empId = '"+crollNo.getSelectedItem()+"'";
                    ResultSet resultset = c.statement.executeQuery(query);
                    while(resultset.next()) {
                        textName.setText(resultset.getString("name"));
                        textFName.setText(resultset.getString("fname"));
                        dDob.setText(resultset.getString("DoB"));
                        tAddress.setText(resultset.getString("Address"));
                        tPhone.setText(resultset.getString("Phone"));
                        tEmail.setText(resultset.getString("email"));
                        t10.setText(resultset.getString("M10"));
                        t12.setText(resultset.getString("M12"));
                        tAadhaar.setText(resultset.getString("Aadhhar"));
                        empL.setText(resultset.getString("rollNo"));
                        tcourse.setText(resultset.getString("course"));
                        tdept.setText(resultset.getString("branch"));
                    }

                }catch (Exception g){
                    g.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
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
        if(e.getSource()==submit){
            String empid = empL.getText();
            String address = tAddress.getText();
            String phone= tPhone.getText();
            String email = tEmail.getText();
            String course = tcourse.getText();
            String branch = tdept.getText();

            try{
                String Q = "update students set address = '"+address+"',phone = '"+phone+"',email = '"+email+"',course = '"+course+"',branch = '"+branch+"'where rollNo ='"+empid+"'";
                Conn c = new Conn();
                c.statement.executeUpdate(Q);

                JOptionPane.showMessageDialog(null,"Details Updated");
                setVisible(false);
            }catch (Exception p ){
                p.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Updatestudent();
    }
}
