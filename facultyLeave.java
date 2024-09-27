package student.database.management;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class facultyLeave extends JFrame implements ActionListener {
    Choice time,date;
    JDateChooser calendar;
    JButton submit1,cancel1;

    facultyLeave(){
        JLabel heading1 = new JLabel("Apply leave(Faculty)");
        heading1.setBounds(40,50,300,30);
        heading1.setFont(new Font("Tahona" ,Font.BOLD,20));
        add(heading1);

        JLabel rollNos1 = new JLabel("Search by Employee Id:");
        rollNos1.setBounds(40,100,300,30);
        rollNos1.setFont(new Font("Tahona" ,Font.PLAIN,20));
        add(rollNos1);

        date = new Choice();
        date.setBounds(40, 130, 150, 30);
        date.setSize(150, 30);
        add(date);
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from teacher");
            while (resultSet.next()) {
                date.add(resultSet.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel ldate1 = new JLabel("Date:");
        ldate1.setBounds(40,170,150,30);
        ldate1.setFont(new Font("Tahona" ,Font.PLAIN,20));
        add(ldate1);


        calendar = new JDateChooser();
        calendar.setBounds(40,210,150,30);
        add(calendar);

        JLabel ltime1 = new JLabel("Time:");
        ltime1.setBounds(40,250,150,30);
        ltime1.setFont(new Font("Tahona" ,Font.PLAIN,20));
        add(ltime1);

        time= new Choice();
        time.setBounds(40, 290, 150, 30);
        time.setSize(150, 30);
        time.add("Select");
        time.add("Full Day");
        time.add("Half Day");
        add(time);


        submit1 = new JButton("Apply");
        submit1.setBounds(40,330,100,30);
        submit1.setBackground(Color.black);
        submit1.setForeground(Color.WHITE);
        submit1.addActionListener(this);
        add(submit1);

        cancel1 = new JButton("Cancel");
        cancel1.setBounds(160,330,100,30);
        cancel1.setBackground(Color.black);
        cancel1.setForeground(Color.WHITE);
        cancel1.addActionListener(this);
        add(cancel1);



        setSize(500,550);
        setLocation(400,50);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit1){
            String empId = date.getSelectedItem();
            String dates = ((JTextField)calendar.getDateEditor().getUiComponent()).getText();
            String times = time.getSelectedItem();

            String T = "insert into facultyLeave values('"+empId+"','"+dates+"','"+times+"')";
            try{
                Conn c = new Conn();
                c.statement.executeUpdate(T);
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
        new facultyLeave();
    }
}
