import java.sql.*;
class JDBC1{
    public static void main(String[] args){
        Connection conn=null;
        Statement stmnt=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to the database");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/EMP", "root", "root");

            stmnt=conn.createStatement();
            String sql;
            sql="Select * from Employees";
            ResultSet rs=stmnt.executeQuery(sql);

            System.out.println("a");

            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");

                System.out.println(id+". "+name);
            }

            rs.close();
            stmnt.close();
            conn.close();
            

        }catch(Exception e){
            System.out.println(e);
        }
    }
}