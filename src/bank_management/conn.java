package bank_management;
import  java.sql.*; 

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Rajesh@1098");
            s=c.createStatement();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
