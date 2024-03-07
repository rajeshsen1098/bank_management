package bank_management;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame  {
    String pinNumber;
    MiniStatement(String pinNumber){

        this.pinNumber=pinNumber;
        setLayout(null);

        JLabel miniText=new JLabel("                       Date                                     Type                Amount ");
        miniText.setBounds(50,165,500,20);
        add(miniText);

        JLabel mini=new JLabel();
        mini.setBounds(50,200,500,200);
        add(mini);

        JLabel bank=new JLabel("Indian Bank");
        bank.setFont(new Font("Algerian",Font.BOLD,30));
        bank.setBounds(150,50,200,30);
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(20,100,500,20);
        add(card);

        JLabel balance=new JLabel();
        balance.setBounds(20,135,500,20);
        add(balance);
        Conn c=new Conn();
        try{

            ResultSet rs=c.s.executeQuery("select * from login where pin_number='"+pinNumber+"';");
            while(rs.next()){
                card.setText("Card Number : "+rs.getString("cardNumber").substring(0,4)+" XXXX XXXX "+rs.getString("cardNumber").substring(12));

            }


        }catch(Exception e){
            System.out.println(e);
        }

        try{
//            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinNumber+"';");
            int i=1;
            while(rs.next()&& i<=5){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><hr><br>");
                i++;


            }


        }catch(Exception e){
            System.out.println(e);
        }

        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin ='" + pinNumber + "'");
            int bal = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Total Balance : "+ bal);
        }catch (Exception e) {
            System.out.println(e);
        }




            setSize(500,700);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MiniStatement("");

    }
}
