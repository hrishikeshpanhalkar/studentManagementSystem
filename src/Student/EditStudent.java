
package Student;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

class EditStudent extends JFrame{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    JTextArea a1;
    JButton b1,b2,b3;
    Container con;
    public EditStudent(){
        con=getContentPane();
        setLayout(new FlowLayout());
        l1=new JLabel("Roll No:");
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

        t=new JTextField(10);
        t1=new JTextField(10);
        t2=new JTextField(10);
        t3=new JTextField(10);
        t4=new JTextField(10);
        t5=new JTextField(10);
        t6=new JTextField(10);
        t7=new JTextField(10);
        t8=new JTextField(10);
        t9=new JTextField(10);
        t10=new JTextField(12);
        a1=new JTextArea(4,10);
        
        b1=new JButton("Edit");
        b2=new JButton("Back");
        b3=new JButton("Load Data");
        con.add(l1); con.add(t); con.add(b3); con.add(l2); con.add(t1); con.add(l3); con.add(t2);
        con.add(l4); con.add(t3); con.add(l5); con.add(t4); con.add(l6);
        con.add(t5); con.add(l7); con.add(t6); con.add(l8); con.add(a1);
        con.add(l9); con.add(t7); con.add(l10); con.add(t8); con.add(l11);
        con.add(t9); con.add(l12); con.add(t10); con.add(b1); con.add(b2);
        
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                int roll_no=Integer.parseInt(t.getText());
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
                
                int i=AccountantDoa.save2(roll_no,name,email,course,fee,paid,due,address,city,state,country,contact);
                if(i>0){
                    JOptionPane.showMessageDialog(EditStudent.this,"Details Added Successfully!");
                }else{
                    JOptionPane.showMessageDialog(EditStudent.this,"Can't Add data!");
                }
                
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                AccountantSuccess.main(new String[]{});
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
                    String sql="select name,email,course,fee,paid,due,address,city,state,country,contact from studentdetail where roll_no='"+t.getText()+"'";
                    PreparedStatement ps=con.prepareStatement(sql);
                                        
                    ResultSet rs = ps.executeQuery(); 
                    while(rs.next()){
                    t1.setText(rs.getString("name"));
                    t2.setText(rs.getString("email"));
                    t3.setText(rs.getString("course"));
                    t4.setText(rs.getString("fee"));
                    t5.setText(rs.getString("paid"));
                    t6.setText(rs.getString("due"));
                    a1.setText(rs.getString("address"));
                    t7.setText(rs.getString("city"));
                    t8.setText(rs.getString("state"));
                    t9.setText(rs.getString("country"));
                    t10.setText(rs.getString("contact"));
                    }
                    rs.close();                                      
                }catch(Exception e){System.out.println("Error:"+e.getMessage());}
                
            }
        });
    }

    static void main(String[] string) {
        EditStudent a=new EditStudent();
        a.setVisible(true);
        a.setSize(300,300);
    }

}
