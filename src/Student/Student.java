
package Student;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Student extends JFrame{
    JLabel l1;
    JButton b1,b2;
    Container con;
    public Student(){
        con=getContentPane();
        setLayout(new FlowLayout());
        l1=new JLabel("FEE REPORT");
        b1=new JButton("Admin Login");
        b2=new JButton("Accountant Login");
        con.add(l1);
        con.add(b1);
        con.add(b2);
        
         b1.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           AdminLogin.main(new String[]{});
       }
   });
      b2.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           AccountantLogin.main(new String[]{});
       }
   });  
   }
    
    public static void main(String [] arg){
        Student s=new Student();
        s.setVisible(true);
        s.setSize(300,300);
    }
    
}
