package student.database.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class register extends JFrame implements ActionListener {
    JButton rregister,rcancel;
    JTextField ruser,rpass,remail,rcpass;
    JCheckBox r;

    register(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(250,40,100,100);
        add(img);


        JLabel LabelName = new JLabel("Username:");
        LabelName.setBounds(150,150,100,20);
        LabelName.setForeground(Color.black);
        add(LabelName);

        ruser= new JTextField();
        ruser.setBounds(270,150,150,25);
        add(ruser);

        JLabel email = new JLabel("Email:");
        email.setBounds(150,180,100,20);
        email.setForeground(Color.black);
        add(email);

        remail= new JTextField();
        remail.setBounds(270,180,150,25);
        add(remail);

        JLabel pass = new JLabel("Enter Password:");
        pass.setBounds(150,210,100,20);
        pass.setForeground(Color.black);
        add(pass);

        rpass= new JTextField();
        rpass.setBounds(270,210,150,25);
        add(rpass);

        JLabel cpass = new JLabel("Re-Enter Password:");
        cpass.setBounds(150,240,200,20);
        cpass.setForeground(Color.black);
        add(cpass);

        rcpass= new JTextField();
        rcpass.setBounds(270,240,150,25);
        add(rcpass);


        rregister = new JButton("Register");
        rregister.setBounds(160,300,90,20);
        rregister.setBackground(Color.black);
        rregister.setForeground(Color.WHITE);
        rregister.addActionListener(this);
        add(rregister);

        rcancel = new JButton("Cancel");
        rcancel.setBounds(310,300,90,20);
        rcancel.setBackground(Color.black);
        rcancel.setForeground(Color.WHITE);
        rcancel.addActionListener(this);
        add(rcancel);


        setSize(600,500);
        setLocation(500,300);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rregister){
            String username = ruser.getText();
            String password = rpass.getText();
            String email = remail.getText();
            String rpass = rcpass.getText();


            try{
                String q = "insert into login values('"+username+"','"+password+"','"+email+"','"+rpass+"')";
                Conn c = new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Registration Succesful");
                setVisible(false);
                new login();

            }catch(Exception e2){
                e2.printStackTrace();
            }
            }else {
            setVisible(false);
        }
        }



    public static void main(String[] args) {
        new register();
    }
}
