package bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
//
    JButton change,back;
    JPasswordField pinTextField,rePinTextField;
    String pinNumber;

    PinChange(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel ima=new JLabel(i3);
        ima.setBounds(0,0,900,900);
        add(ima);


        JLabel text=new JLabel("Change your pin  ") ;
        text.setBounds(250,300,350,30);
        text.setForeground(Color.RED);
        text.setFont(new Font("System",Font.BOLD,20));
        ima.add(text);

        JLabel pinText=new JLabel("New PIN :");
        pinText.setBounds(180,400,160,30);
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.ITALIC,16));
        ima.add(pinText);

         pinTextField=new JPasswordField();
        pinTextField.setBounds(340,400,175,30);
        ima.add(pinTextField);


        JLabel rePinText=new JLabel("ReEnter New PIN :");
        rePinText.setBounds(180,450,160,30);
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("System", Font.ITALIC,16));
        ima.add(rePinText);

         rePinTextField=new JPasswordField();
        rePinTextField.setBounds(340,450,175,30);
        ima.add(rePinTextField);

        change=new JButton("Change");
        change.setBounds(390,525,120,20);
        change.addActionListener(this);
        ima.add(change);

        back=new JButton("Back");
        back.setBounds(165,525,120,20);
        back.addActionListener(this);
        ima.add(back);


        setSize(900,900);
        setLocation(300,0);
//        setUndecorated(true);
        setVisible(true);

    }

    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change) {
            try {
                String npin = pinTextField.getText();
                String repin = rePinTextField.getText();
                if (!npin.equals(repin)) {
                    JOptionPane.showMessageDialog(null, "Enter Pin Does not Match");
                    return;

                }
                if(npin.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Enter PIN");
                    return;
                }
                if(repin.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"ReEnter PIN");
                    return;
                }
                Conn c=new Conn();
                String quary1="update bank set pin='"+repin+"' where pin='"+pinNumber+"';";
                String quary2="update login set pin_number='"+repin+"' where pin_number='"+pinNumber+"';";
                String quary3="update signup_3 set pin_number='"+repin+"' where pin_number='"+pinNumber+"';";

                try{
                    c.s.executeUpdate(quary1);
                    c.s.executeUpdate(quary2);
                    c.s.executeUpdate(quary3);
                    JOptionPane.showMessageDialog(null,"Pin Number change successfully");
                    setVisible(false);
                    new Transactions(repin).setVisible(true);


                }catch (Exception e){
                    System.out.println(e);
                }



            } catch (Exception e) {
                System.out.println(e);
            }
        }else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }

    }




    public static void main(String[] args) {
         new PinChange("");
    }
}
