package bank_management;
import  java.sql.*;
//import  com.mysql.*;


public class conn {
    Connection c;
    Statement s;
    public conn(){
        try{
//            Class.forName(com.mysql.cj.jdbc.Driver);
            c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Rajesh@1098");
            s=c.createStatement();
        } catch (Exception e){
            System.out.println(e);


        }
    }
}
