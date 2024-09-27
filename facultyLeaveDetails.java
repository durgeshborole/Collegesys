package student.database.management;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class facultyLeaveDetails extends JFrame implements ActionListener {
    Choice choice;
    JTable table;
    JButton search, print, cancel;
    facultyLeaveDetails(){
        JLabel heading3 = new JLabel("Search by Employee Id:");
        heading3.setBounds(20,50,180,20);
        heading3.setFont(new Font("Tahona",Font.BOLD,15));
        add(heading3);

        choice = new Choice();
        choice.setBounds(220,50,150,20);
        add(choice);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from teacher");
            while (resultSet.next()) {
                choice.add(resultSet.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from facultyLeave");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane js = new JScrollPane(table);
        js.setBounds(0, 150, 900, 600);
        add(js);

        search = new JButton("Search");
        search.setBounds(20,100,90,20);
        search.setBackground(Color.black);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,100,90,20);
        print.setBackground(Color.black);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);

        cancel = new JButton("Cancel");
        cancel.setBounds(220, 100, 90, 20);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,600);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==search){
            String c1 = "select * from facultyLeave where empId = '" + choice.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(c1);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception r) {
                r.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try{
                table.print();
            }catch (Exception e1){
                e1.printStackTrace();
            }


        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new facultyLeaveDetails();
    }
}
