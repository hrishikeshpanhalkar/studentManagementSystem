package Student;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class AdminLogin extends JFrame{

     JTextField t1;
     JPasswordField t2;
     JLabel l1,l2,l3;
     Container con;
     JButton b1,b2;
     static AdminLogin frame;
   public AdminLogin()
   {       
       con=getContentPane();
       setLayout(new FlowLayout());
       
       l1=new JLabel("Admin Login Form");
       l2=new JLabel("Enter Name");
       l3=new JLabel("Enter Password");
       t1=new JTextField(10);
       t2=new JPasswordField(10);
       b1=new JButton("Login");
       b2=new JButton("Back");
       con.add(l1);
       con.add(l2);
       con.add(t1);
       con.add(l3);
       con.add(t2);
       con.add(b1);   
       con.add(b2);
       
       b1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               String name=t1.getText();
               String password=String.valueOf(t2.getPassword());
               if(name.equals("admin")&& password.equals("admin123")){
                   AdminSuccess.main(new String[]{});
//                   frame.dispose();
               }else{
                   JOptionPane.showMessageDialog(AdminLogin.this,"Sorry,Username or password Error","Login Error!",JOptionPane.ERROR_MESSAGE);
                   t1.setText("");
                   t2.setText("");
               }  
           }
       });
       b2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            Student.main(new String[]{});
        }  
    });
   }
    public static void main(String[] args) 
    {
       AdminLogin b=new AdminLogin();
        b.setVisible(true);
        b.setSize(300,300);        
    }
}

