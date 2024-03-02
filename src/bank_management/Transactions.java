package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit,withdrawal,pinChange,miniStatement,balanceEnquiry,exit,fastCash;

    String pinNumber;
    Transactions(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel ima=new JLabel(i3);
        ima.setBounds(0,0,900,900);
        add(ima);

        JLabel text =new JLabel("Please select your Transactions ");
        text.setBounds(180,300,350,30);
        text.setForeground(Color.RED);
        text.setFont(new Font("System",Font.BOLD,20));
        ima.add(text);


        deposit= new JButton("Deposit");
        deposit.setBounds(165,420,120,20);
        deposit.addActionListener(this);
        ima.add(deposit);

        withdrawal = new JButton("Withdrawal");
        withdrawal.setBounds(165,455,120,20);
        withdrawal.addActionListener(this);
        ima.add(withdrawal);

        fastCash= new JButton("Fast Cash");
        fastCash.setBounds(390,420,120,20);
        fastCash.addActionListener(this);
        ima.add(fastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(390,455,120,20);
        miniStatement.addActionListener(this);
        ima.add(miniStatement);

        pinChange = new JButton("PinChange");
        pinChange.setBounds(165,490,120,20);
        pinChange.addActionListener(this);
        ima.add(pinChange);

         balanceEnquiry= new JButton("Bal. Enquiry ");
        balanceEnquiry.setBounds(390,490,120,20);
        balanceEnquiry.addActionListener(this);
        ima.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(390,525,120,20);
        exit.addActionListener(this);
        ima.add(exit);






        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new Transactions("");

    }
}
