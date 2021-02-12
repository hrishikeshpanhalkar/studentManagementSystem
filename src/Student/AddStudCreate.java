package Student;
import java.sql.*;
public class AddStudCreate {
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/students";
    
    static final String USER="root";
    static final String PASS="root";
    
    public static void main(String[] args){
        Connection conn=null;
        Statement stmt=null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to the database....");
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connected database successfully");
            
            System.out.println("Creating table in given database");
            stmt=conn.createStatement();
            
            String sql="create table studentdetail" +
                    "(roll_no INTEGER not NULL AUTO_INCREMENT," +
                    "name VARCHAR(255)," +
                    "email VARCHAR(255)," +
                    "course VARCHAR(255)," +
                    "fee INTEGER," +
                    "paid INTEGER," +
                    "due INTEGER," +
                    "address VARCHAR(255)," +
                    "city VARCHAR(255)," +
                    "state VARCHAR(255)," +
                    "country VARCHAR(255)," +
                    "contact INTEGER," +
                    "PRIMARY KEY(roll_no))";
            stmt.executeUpdate(sql);
            
           
            System.out.println("Created table in given database....");                   
        }catch(SQLException se){
        se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                conn.close();
               }catch(SQLException se){
                   se.printStackTrace();
               }
        }System.out.println("GoodBye!");
    }
}
