
package Student;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


class AdminLoginForm extends JFrame{
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3;
    JPasswordField p1;
    JButton b1,b2;
    Container con;
    public AdminLoginForm(){
        con=getContentPane();
        setLayout(new FlowLayout());
        l1=new JLabel("ADD ACCOUNTANT");
        l2=new JLabel("Name:");
        l3=new JLabel("Password:");
        l4=new JLabel("Email:");
        l5=new JLabel("Contact no:");
        
        t1=new JTextField(10);
        p1=new JPasswordField(10);
        t2=new JTextField(10);
        t3=new JTextField(10);
        
        b1=new JButton("Add");
        b2=new JButton("Back");
        con.add(l1);
        con.add(l2);
        con.add(t1);
        con.add(l3);
        con.add(p1);
        con.add(l4);
        con.add(t2);
        con.add(l5);
        con.add(t3);
        con.add(b1);
        con.add(b2);
        
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String name=t1.getText();
                String password=String.valueOf(p1.getPassword());
                String email=t2.getText();
                int contact=Integer.parseInt(t3.getText());
                
                int i=AccountantDoa.save(name,password,email,contact);
                if(i>0){
                    JOptionPane.showMessageDialog(AdminLoginForm.this,"data Added successfully");
                } else{
                    JOptionPane.showMessageDialog(AdminLoginForm.this,"Unable to save");
                }              
            }
        }); 
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AdminSuccess.main(new String[]{});
            }
        });
    }

    static void main(String[] string) {
        AdminLoginForm a=new AdminLoginForm();
        a.setVisible(true);
        a.setSize(300,300);
    }
    
}
