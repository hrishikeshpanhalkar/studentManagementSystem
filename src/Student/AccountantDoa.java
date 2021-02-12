
package Student;
import java.sql.*;

class AccountantDoa {

    static int save2(int roll_no,String name, String email, String course, int fee, int paid, int due, String address, String city, String state, String country, int contact) {
        int status=0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
            PreparedStatement ps=con.prepareStatement("update studentdetail set name=?,email=?,course=?,fee=?,paid=?,due=?,address=?,city=?,state=?,country=?,contact=? where roll_no=? ");
            ps.setInt(12, roll_no);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);
            ps.setInt(4, fee);
            ps.setInt(5, paid);
            ps.setInt(6, due);
            ps.setString(7, address);
            ps.setString(8, city);
            ps.setString(9, state);
            ps.setString(10, country);
            ps.setInt(11, contact); 
            status=ps.executeUpdate();
            ps.close();
        }catch(Exception e){System.out.println("Error" + e.getMessage());}       
        return status;
    }

    /*static int fetch(int roll_no) {
       int status=0;
       try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
            String sql="select * from studentdetail where roll_no=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, roll_no);
            ResultSet rs = ps.executeQuery();                        
                String name = rs.getString("name");
                String email = rs.getString("email");
                String course = rs.getString("course");
                int fee = rs.getInt("fee");
                int paid = rs.getInt("paid");
                int due = rs.getInt("due");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String country = rs.getString("country");
                int contact = rs.getInt("contact");
            rs.close();
       }catch(Exception e){System.out.println("Error:"+ e.getMessage());}
       return status;
    }*/
    Connection con=null;
    static int save1(String name, String email, String course, int fee, int paid, int due, String address, String city, String state, String country, int contact) {
        int status=0;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
        PreparedStatement ps=con.prepareStatement("insert into studentdetail(name,email,course,fee,paid,due,address,city,state,country,contact) values(?,?,?,?,?,?,?,?,?,?,?) ");
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, course);
        ps.setInt(4, fee);
        ps.setInt(5, paid);
        ps.setInt(6, due);
        ps.setString(7, address);
        ps.setString(8, city);
        ps.setString(9, state);
        ps.setString(10, country);
        ps.setInt(11, contact); 
        status=ps.executeUpdate();
        ps.close();
        }catch(Exception e){System.out.println("Error" + e.getMessage());}       
        return status;
    }
    
    static boolean update(String sname, String spassword) {
    boolean flag = false;
    try {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
         String queryString = "SELECT name, password FROM student";
         PreparedStatement ps=con.prepareStatement(queryString);
         ResultSet rs = ps.executeQuery();

        while (rs.next()) {
        String name = rs.getString("name");
        String password =  rs.getString("password");

        if ((sname.equals(name)) && (spassword.equals(password))) {
              flag = true;
        }
       }
        rs.close();
    } catch (Exception sql) {
       System.out.println("Error:" + sql.getMessage());
    }
    return flag;
    }
   
    public static int save(String name, String password, String email, int contact) {
        int status=0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
            PreparedStatement ps=con.prepareStatement("insert into student(name,password,email,contact) values(?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3,email);
            ps.setInt(4,contact);
            status=ps.executeUpdate();
            con.close();
        }catch(Exception e){System.out.println("Error"+e.getMessage());}
        return status;
    }

}
