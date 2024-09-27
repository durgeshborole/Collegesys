package student.database.management;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class studentLeave extends JFrame implements ActionListener {

    Choice choice1,choice2;
    JDateChooser cal;
    JButton submit,cancel;
    studentLeave(){

        JLabel heading = new JLabel("Apply leave(Student)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahona" ,Font.BOLD,20));
        add(heading);

        JLabel rollNos = new JLabel("Search by Roll No:");
        rollNos.setBounds(40,100,300,30);
        rollNos.setFont(new Font("Tahona" ,Font.PLAIN,20));
        add(rollNos);

        choice1 = new Choice();
        choice1.setBounds(40, 130, 150, 30);
        choice1.setSize(150, 30);
        add(choice1);
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from students");
            while (resultSet.next()) {
                choice1.add(resultSet.getString("rollNo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel ldate = new JLabel("Date:");
        ldate.setBounds(40,170,150,30);
        ldate.setFont(new Font("Tahona" ,Font.PLAIN,20));
        add(ldate);


        cal = new JDateChooser();
        cal.setBounds(40,210,150,30);
        add(cal);

        JLabel ltime = new JLabel("Time:");
        ltime.setBounds(40,250,150,30);
        ltime.setFont(new Font("Tahona" ,Font.PLAIN,20));
        add(ltime);

        choice2 = new Choice();
        choice2.setBounds(40, 290, 150, 30);
        choice2.setSize(150, 30);
        choice2.add("Select");
        choice2.add("Full Day");
        choice2.add("Half Day");
        add(choice2);


        submit = new JButton("Apply");
        submit.setBounds(40,330,100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(160,330,100,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);



        setSize(500,550);
        setLocation(400,50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String rollNo = choice1.getSelectedItem();
            String cali = ((JTextField)cal.getDateEditor().getUiComponent()).getText();
            String time = choice2.getSelectedItem();

            String Q = "insert into studentLeave values('"+rollNo+"','"+cali+"','"+time+"')";
            try{
                Conn c = new Conn();
                c.statement.executeUpdate(Q);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                setVisible(false);

            }catch (Exception o){
                o.printStackTrace();
            }
        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new studentLeave();
    }
}
