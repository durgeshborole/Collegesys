package student.database.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener,Runnable {
    main_class(){

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/clg3.jpg"));
        Image i8 = i7.getImage().getScaledInstance(1540,900,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel img1 = new JLabel(i9);
        add(img1);


        JMenuBar mb = new JMenuBar();
//New information
        JMenu newInfo =new JMenu("New Information");
        newInfo.setForeground(Color.black);
        mb.add(newInfo);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.white);
        facultyInfo.addActionListener(this);
        newInfo.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener(this);
        newInfo.add(studentInfo);

        //Details
        JMenu details =new JMenu("View Details");
        details.setForeground(Color.black);
        mb.add(details);

        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.white);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.white);
        studentDetails.addActionListener(this);
        details.add(studentDetails);

        //Leave
        JMenu leave =new JMenu("Apply leave");
        leave.setForeground(Color.black);
        mb.add(leave);

        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.white);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.white);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        //Leave Details
        JMenu leaveDetails =new JMenu("Leave Details");
        leaveDetails.setForeground(Color.black);
        mb.add(leaveDetails);

        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.white);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.white);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        //Exams
        JMenu exam =new JMenu("Examination");
        exam.setForeground(Color.black);
        mb.add(exam);

        JMenuItem ExaminationDetails = new JMenuItem("Examination Details");
        ExaminationDetails.setBackground(Color.white);
        ExaminationDetails.addActionListener(this);
        exam.add(ExaminationDetails);

        JMenuItem EnterMarks = new JMenuItem("Enter Marks");
        EnterMarks.setBackground(Color.white);
        EnterMarks.addActionListener(this);
        exam.add(EnterMarks);

        //Update info
        JMenu updateInfo =new JMenu("Update Details");
        exam.setForeground(Color.black);
        mb.add(updateInfo);

        JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Details");
        updateFacultyInfo.setBackground(Color.white);
        updateFacultyInfo.addActionListener(this);
        updateInfo.add(updateFacultyInfo);

        JMenuItem updateStudentInfo = new JMenuItem("Update Student Details");
        updateStudentInfo.setBackground(Color.white);
        updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);

        //fees
        JMenu fees =new JMenu("Fees Details");
        fees.setForeground(Color.black);
        mb.add(fees);

        JMenuItem FeeStructure= new JMenuItem("Fee Structure");
        updateFacultyInfo.setBackground(Color.white);
        fees.add(FeeStructure);

        //utility

        JMenu utility =new JMenu("Utility");
        exam.setForeground(Color.black);
        mb.add(utility);

        JMenuItem Calculator = new JMenuItem("Calculator");
        Calculator.setBackground(Color.white);
        utility.add(Calculator);
        Calculator.addActionListener(this);

        JMenuItem Notepad = new JMenuItem("Notepad");
        Notepad.setBackground(Color.white);
        utility.add(Notepad);
        Notepad.addActionListener(this);

        //About

        JMenu about =new JMenu("About");
        about.setForeground(Color.black);
        mb.add(about);


        JMenuItem About = new JMenuItem("About");
        About.setBackground(Color.white);
        About.addActionListener(this);
        about.add(About);


        //Exit

        JMenu exit =new JMenu("Exit");
        exit.setForeground(Color.black);
        mb.add(exit);

        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setBackground(Color.white);
        exit.add(Exit);
        Exit.addActionListener(this);

        setJMenuBar(mb);


        setSize(1540,900);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Exit")) {
            System.exit(1);
        } else if (s.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception E) {
                E.printStackTrace();
            }

        } else if (s.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (s.equals("New Faculty Information")) {
            new Addfaculty();

        } else if (s.equals("New Student Information")) {
            new AddStudent();

        } else if (s.equals("View Faculty Details")) {
            new facultyDetails();
        } else if (s.equals("View Student Details")) {
            new studentDetails();

        } else if (s.equals("Faculty Leave")) {
            new facultyLeave();

        } else if (s.equals("Student Leave")) {
            new studentLeave();

        } else if (s.equals("Faculty Leave Details")) {
            new facultyLeaveDetails();

        } else if (s.equals("Student Leave Details")) {
            new studentLeaveDetails();

        } else if (s.equals("Examination Details")) {
            new examinationDetails();

        } else if (s.equals("Enter Marks")) {
            new enterMarks();

        } else if (s.equals("Update Faculty Details")) {
            new Updatefaculty();

        }else if (s.equals("Update Student Details")) {
            new Updatestudent();

        }else if (s.equals("About")) {
            new About();
        }
    }

    @Override
    public void run() {
        try{
            new Addfaculty();
            setVisible(false);
        }catch (Exception c){
            c.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new main_class();
    }
}
