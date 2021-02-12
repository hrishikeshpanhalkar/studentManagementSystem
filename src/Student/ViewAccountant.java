package Student;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.*;



class ViewAccountant extends JFrame {
    public JTable table;
    Container con1=getContentPane();
    public ViewAccountant(){
        String data[][]=null;
        String column[]=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
            PreparedStatement ps=con.prepareStatement("select * from student",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=ps.executeQuery();
            
            ResultSetMetaData rsmd=rs.getMetaData();
            int cols=rsmd.getColumnCount();
            column=new String[cols];
            for(int i=1;i<=cols;i++){
                column[i-1]=rsmd.getColumnName(i);
            }
            rs.last();
            int rows=rs.getRow();
            rs.beforeFirst();
            
            data=new String[rows][cols];
            int count=0;
            while(rs.next()){
                for(int i=1;i<=cols;i++){
                data[count][i-1]=rs.getString(i);
            }
                count++;                
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
        
        table =new JTable(data,column);
        JScrollPane jp= new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        con1.add(jp);
    }

    static void main(String[] string) {
        ViewAccountant b=new ViewAccountant();
        b.setVisible(true);
        b.setSize(300,300);
    }
    
}
