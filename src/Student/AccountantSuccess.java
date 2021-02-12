
package Student;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class AccountantSuccess extends JFrame{
    JLabel l1;
    JButton b1,b2,b3,b4,b5;
    Container con;
    public AccountantSuccess(){
        con=getContentPane();
        setLayout(new FlowLayout());
        l1=new JLabel("ACCOUNTANT SECTION");
        b1=new JButton("Add Student");
        b2=new JButton("View Student");
        b3=new JButton("Edit Student");
        b4=new JButton("Due Fee");
        b5=new JButton("logout");

        con.add(l1);
        con.add(b1);
        con.add(b2);
        con.add(b3);
        con.add(b4);
        con.add(b5);

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            AddStudent.main(new String[]{});
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            ViewStudent.main(new String[]{});
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            EditStudent.main(new String[]{});
            }
        });
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                DueFee.main(new String[]{});
            }
        });
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            AccountantLogin.main(new String[]{});
            }
        });
    }

    public static void main(String[] string) {
       AccountantSuccess a=new AccountantSuccess();
       a.setVisible(true);
       a.setSize(300,300);
    }

}
