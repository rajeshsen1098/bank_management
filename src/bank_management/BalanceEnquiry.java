package bank_management;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;


public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinNumber;
    JButton back;
    BalanceEnquiry(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel ima=new JLabel(i3);
        ima.setBounds(0,0,900,900);
        add(ima);

        back=new JButton("Back");
        back.setBounds(165,525,120,20);
        back.addActionListener(this);
        ima.add(back);


        Conn c=new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin ='" + pinNumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }


        }catch (Exception e) {
            System.out.println(e);
        }

        JLabel text=new JLabel("Your Current balance is :"+balance);
        text.setBounds(200,300,350,30);
        text.setForeground(Color.RED);
        text.setFont(new Font("System",Font.BOLD,20));
        ima.add(text);


        setSize(900,900);
        setLocation(300,0);
//        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);

    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

}
