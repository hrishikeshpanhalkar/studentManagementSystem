
package Student;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class AddStudent extends JFrame{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    JTextArea a1;
    JButton b1,b2;
    Container con;
    public AddStudent(){
        con=getContentPane();
        setLayout(new FlowLayout());
        l1=new JLabel("Add Student");
        l2=new JLabel("Name:");
        l3=new JLabel("Email:");
        l4=new JLabel("Course:");
        l5=new JLabel("Fee:");
        l6=new JLabel("Paid:");
        l7=new JLabel("Due:");
        l8=new JLabel("Address:");
        l9=new JLabel("City:");
        l10=new JLabel("State:");
        l11=new JLabel("Country:");
        l12=new JLabel("Contact no:");

        t1=new JTextField(10);
        t2=new JTextField(10);
        t3=new JTextField(10);
        t4=new JTextField(10);
        t5=new JTextField(10);
        t6=new JTextField(10);
        t7=new JTextField(10);
        t8=new JTextField(10);
        t9=new JTextField(10);
        t10=new JTextField(10);
        a1=new JTextArea(4,10);
        
        b1=new JButton("Add");
        b2=new JButton("back");
        
        con.add(l1); con.add(l2); con.add(t1); con.add(l3); con.add(t2);
        con.add(l4); con.add(t3); con.add(l5); con.add(t4); con.add(l6);
        con.add(t5); con.add(l7); con.add(t6); con.add(l8); con.add(a1);
        con.add(l9); con.add(t7); con.add(l10); con.add(t8); con.add(l11);
        con.add(t9); con.add(l12); con.add(t10); con.add(b1); con.add(b2);
        
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String name=t1.getText();
                String email=t2.getText();
                String course=t3.getText();
                int fee=Integer.parseInt(t4.getText());
                int paid=Integer.parseInt(t5.getText());
                int due=Integer.parseInt(t6.getText());
                String address=a1.getText();
                String city=t7.getText();
                String state=t8.getText();
                String country=t9.getText();
                int contact=Integer.parseInt(t10.getText());
                
                int i=AccountantDoa.save1(name,email,course,fee,paid,due,address,city,state,country,contact);
                if(i>0){
                    JOptionPane.showMessageDialog(AddStudent.this,"Details Added Successfully!");
                }else{
                    JOptionPane.showMessageDialog(AddStudent.this,"Can't Add data!");
                }
                
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                AccountantSuccess.main(new String[]{});
            }
        });
    }

    static void main(String[] string) {
        AddStudent a=new AddStudent();
        a.setVisible(true);
        a.setSize(300,300);
    }

}
