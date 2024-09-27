package student.database.management;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class facultyDetails extends JFrame implements ActionListener {
    Choice choice;
    JTable table;
    JButton search, print, cancel, add, update;
    facultyDetails() {

        JLabel heading = new JLabel("Faculty details");
        heading.setBounds(350, 20, 200, 30);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel heading2 = new JLabel("Search by Employee Id:");
        heading2.setBounds(20, 70, 150, 30);
        heading2.setFont(new Font("serif", Font.BOLD, 15));
        add(heading2);

        choice = new Choice();
        choice.setBounds(180, 70, 150, 30);
        choice.setSize(150, 30);
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
            ResultSet resultSet = c.statement.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane js = new JScrollPane(table);
        js.setBounds(0, 150, 900, 600);
        add(js);

        search = new JButton("Search");
        search.setBounds(20, 110, 90, 20);
        search.setBackground(Color.black);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        add = new JButton("Add");
        add.setBounds(120, 110, 90, 20);
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(220, 110, 90, 20);
        update.setBackground(Color.black);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        print = new JButton("Print");
        print.setBounds(320, 110, 90, 20);
        print.setBackground(Color.black);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);


        cancel = new JButton("Cancel");
        cancel.setBounds(420, 110, 90, 20);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


        setSize(900, 700);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            String c1 = "select * from teacher where empId = '" + choice.getSelectedItem() + "'";
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
            }catch (Exception y){
                y.printStackTrace();
            }

        } else if (e.getSource() == add) {
            setVisible(false);
            new Addfaculty();
        } else if (e.getSource()==update) {
            new Updatefaculty();

            }else {
            setVisible(false);

        }
    }

    public static void main(String[] args) {
     new facultyDetails();
    }
}
