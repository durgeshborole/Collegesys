package student.database.management;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class examinationDetails extends JFrame implements ActionListener {

    JTextField search;
    JButton result,back;
    JTable table;
    examinationDetails(){

        JLabel heading = new JLabel("Check result");
        heading.setBounds(20,40,150,30);
        heading.setFont(new Font("Tahona",Font.BOLD,20));
        add(heading);

        search = new JTextField();
        search.setBounds(20,80,150,20);
        add(search);

        result = new JButton("Result");
        result.setBounds(190,80,90,20);
        result.setBackground(Color.black);
        result.setForeground(Color.WHITE);
        result.addActionListener(this);
        add(result);

        back= new JButton("Back");
        back.setBounds(300,80,90,20);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,130,1000,300);
        add(scrollPane);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from students");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        table.addMouseListener(( new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row  = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,2).toString());
            }
        }));

        setSize(1000,500);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == result){
            setVisible(false);
            //
            new marks(search.getText());
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new examinationDetails();
    }
}
