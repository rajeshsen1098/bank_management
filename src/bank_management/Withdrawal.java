package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdrawl,back;
    String pinNumber;

    Withdrawal(String pinNumber){
        this.pinNumber=pinNumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text =new JLabel("Enter the amount to deposit: ");
        text.setBounds(220,300,300,20);
        text.setForeground(Color.orange);
        text.setFont(new Font("System",Font.ITALIC,20));
        image.add(text);

        amount=new JTextField();
        amount.setBounds(240,400,200,20);
        amount.setFont(new Font("rale way",Font.ITALIC,20));
        amount.addActionListener(this);
        image.add(amount);

        withdrawl=new JButton("Withdrawal");
        withdrawl.setBounds(390,490,120,20);
        withdrawl.setFont(new Font("rale way",Font.ITALIC,15));
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        back=new JButton("Back");
        back.setBounds(165,490,120,20);
        back.setFont(new Font("rale way",Font.ITALIC,15));
        back.addActionListener(this);
        image.add(back);




        setSize(900,900);
        setLocation(300,0);
//        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdrawl){
            String cashDeposit=amount.getText();
            Date date=new Date();

            if(cashDeposit.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount ....");
            }else {
                Conn con=new Conn();
                String query="insert into bank values('"+pinNumber+"','"+date+"','withdrawal','"+cashDeposit+"');";
                try {
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+cashDeposit+" withdrawal successfully.");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);

        }

    }


    public static void main(String[] args) {
        new Withdrawal("");
//        Date date=new Date();
//        System.out.println(System.c);

    }
}
