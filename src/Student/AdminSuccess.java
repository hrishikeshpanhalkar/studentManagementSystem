
package Student;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class AdminSuccess extends JFrame{
    JButton b1,b2,b3;
    JLabel l1;
    Container con;
    public AdminSuccess(){
        con=getContentPane();
        setLayout(new FlowLayout());
        l1=new JLabel("Admin Section");
        b1=new JButton("Add Accountant");
        b2=new JButton("View Accountant");
        b3=new JButton("Logout");
        con.add(l1);
        con.add(b1);
        con.add(b2);
        con.add(b3);
        
        b1.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           AdminLoginForm.main(new String[]{});
       }
   });
          b2.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           ViewAccountant.main(new String[]{});
       }
   });
           b3.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           AdminLogin.main(new String[]{});
       }
   });
    }
    

    static void main(String[] string) {
        AdminSuccess a=new AdminSuccess();
        a.setVisible(true);        
        a.setSize(300,300);
        
    }
    
}
