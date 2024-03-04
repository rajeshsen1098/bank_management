package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton rs_10000,rs_5000,rs_2000,rs_1000,rs_500,rs_100,exit;

    String pinNumber;
    FastCash(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel ima=new JLabel(i3);
        ima.setBounds(0,0,900,900);
        add(ima);

        JLabel fast =new JLabel("Select withdrawal amount");
        fast.setBounds(200,300,350,30);
        fast.setForeground(Color.RED);
        fast.setFont(new Font("System",Font.BOLD,20));
        ima.add(fast);


        rs_100= new JButton("Rs 100");
        rs_100.setBounds(165,420,120,20);
        rs_100.addActionListener(this);
        ima.add(rs_100);

        rs_500 = new JButton("Rs 500");
        rs_500.setBounds(165,455,120,20);
        rs_500.addActionListener(this);
        ima.add(rs_500);

        rs_1000= new JButton("Rs 1000");
        rs_1000.setBounds(390,420,120,20);
        rs_1000.addActionListener(this);
        ima.add(rs_1000);

        rs_2000 = new JButton("Rs 2000");
        rs_2000.setBounds(390,455,120,20);
        rs_2000.addActionListener(this);
        ima.add(rs_2000);

        rs_5000 = new JButton("Rs 5000");
        rs_5000.setBounds(165,490,120,20);
        rs_5000.addActionListener(this);
        ima.add(rs_5000);

        rs_10000= new JButton("Rs 10000");
        rs_10000.setBounds(390,490,120,20);
        rs_10000.addActionListener(this);
        ima.add(rs_10000);

        exit = new JButton("Back");
        exit.setBounds(390,525,120,20);
//        exit.addActionListener(this);
        ima.add(exit);






        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
//            System.exit(0);
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else {
            String amount= ((JButton) ae.getSource()).getText().substring(3);
            Conn c=new Conn();
            try {
                ResultSet rs=c.s.executeQuery("select * from bank where pin ='"+pinNumber+"'");
                int balance=0;
                while (rs.next()){
                    if(rs.getString("type").equals("deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");

                }else{
                    Date date=new Date();
                    String query="insert into bank values('"+pinNumber+"','"+date+"','withdrawl',"+amount+");";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"RS "+amount+" Debited successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }


            }catch (Exception e){
                System.out.println(e);
            }


        }

    }

    public static void main(String[] args) {
        new FastCash("");

    }
}
