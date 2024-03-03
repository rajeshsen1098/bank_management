package bank_management;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class SignUp_3 extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignUp_3(String formno){
        this.formno= formno;
        setLayout(null);

        JLabel l1= new JLabel("Page 3: Account Detail");
        l1.setFont(new Font("Rale way",Font.BOLD,20));
        l1.setBounds(240,70,300,30);
        add(l1);

        JLabel type= new JLabel("Account Type");
        type.setFont(new Font("Rale way",Font.BOLD,19));
        type.setBounds(80,150,300,30);
        add(type);

        r1=new JRadioButton("currentAccount");
        r1.setFont(new Font("Rale way",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(80,190,150,20);
        add(r1);

        r2=new JRadioButton("Recurring Deposit Account");
        r2.setFont(new Font("Rale way",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(80,220,240,20);
        add(r2);

        r3=new JRadioButton("Saving Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(350,190,150,20);
        add(r3);

        r4=new JRadioButton("Fixed Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,200,20);
        add(r4);

        ButtonGroup groupAccount=new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);



        JLabel cardNumber= new JLabel("Card Number: ");
        cardNumber.setFont(new Font("Rale way",Font.BOLD,19));
        cardNumber.setBounds(80,250,300,30);
        add(cardNumber);

        JLabel cardDetail= new JLabel("This is your 16 digit Card Number");
        cardDetail.setFont(new Font("Rale way",Font.BOLD,10));
        cardDetail.setBounds(80,280,200,20);
        add(cardDetail);

        JLabel number= new JLabel("XXXX-XXXX-XXXX-X123");
        number.setFont(new Font("Rale way",Font.BOLD,19));
        number.setBounds(280,250,300,30);
        add(number);

        JLabel pinNumber= new JLabel("PIN Number: ");
        pinNumber.setFont(new Font("Rale way",Font.BOLD,19));
        pinNumber.setBounds(80,320,300,30);
        add(pinNumber);

        JLabel pinDetail= new JLabel("This is your 4 digit PIN Number");
        pinDetail.setFont(new Font("Rale way",Font.BOLD,10));
        pinDetail.setBounds(80,360,200,20);
        add(pinDetail);


        JLabel pin= new JLabel("XXXX");
        pin.setFont(new Font("Rale way",Font.BOLD,19));
        pin.setBounds(280,320,300,30);
        add(pin);

        JLabel service= new JLabel("Service Required: ");
        service.setFont(new Font("Rale way",Font.BOLD,19));
        service.setBounds(80,390,300,30);
        add(service);

        c1=new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Rale way",Font.BOLD,12));
        c1.setBounds(90,425,150,15);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Rale way",Font.BOLD,12));
        c2.setBounds(90,445,150,15);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Rale way",Font.BOLD,12));
        c3.setBounds(90,465,150,15);
        add(c3);

        c4=new JCheckBox("Email and SMS Alert");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Rale way",Font.BOLD,12));
        c4.setBounds(90,485,150,15);
        add(c4);

        c5=new JCheckBox("Check Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Rale way",Font.BOLD,12));
        c5.setBounds(90,505,150,15);
        add(c5);

        c6=new JCheckBox("E Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Rale way",Font.BOLD,12));
        c6.setBounds(90,525,150,15);
        add(c6);

        c7=new JCheckBox("I hearby declear that above detail are fill correctly.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Rale way",Font.BOLD,12));
        c7.setBounds(75,560,400,15);
        add(c7);


        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.ORANGE);
        submit.setFont(new Font("Raleway",Font.BOLD,17));
        submit.setBounds(100,600,100,30);
        add(submit);
        submit.addActionListener(this);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.ORANGE);
        cancel.setFont(new Font("Rale way",Font.BOLD,17));
        cancel.setBounds(400,600,100,30);
        add(cancel);
        cancel.addActionListener(this);



        setSize(700,800);
        setLocation(350,10);
        setVisible(true);
        getContentPane().setBackground(Color.white);

    }
    public void  actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
            String accountType=null;
            if(r1.isSelected()){
                accountType="currentAccount";
            }else if(r2.isSelected()){
                accountType="Recurring Deposit Account";
            }else if(r3.isSelected()){
                accountType="Saving Account";
            }else if(r4.isSelected()){
                accountType="Fixed Deposit Account";
            }
            Random random=new Random();
            String cardNumber= ""+Math.abs((random.nextLong()% 900000000L+5040936000000000L));
            String pinNumber= ""+Math.abs((random.nextLong()% 9000L+1000L));
            String faculty="";
            if(c1.isSelected()){
                faculty=faculty+" ATM Card";
            }else if(c2.isSelected()){
                faculty=faculty+" Internet Banking";
            }else if(c3.isSelected()){
                faculty=faculty+" Mobile Banking";
            }else if(c4.isSelected()){
                faculty=faculty+" Email and SMS Alert";
            }else if(c5.isSelected()){
                faculty=faculty+" Check Book";
            }else if(c6.isSelected()){
                faculty=faculty+" E Statement";
            }

            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type Required");
                }else{
                    Conn connection=new Conn();
                    String quary1="Insert into signup_3 values('"+formno+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+faculty+"')";
                    connection.s.executeUpdate(quary1);
                    String quary2="Insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                    connection.s.executeUpdate(quary2);
                    JOptionPane.showMessageDialog(null,"Card Number: "+cardNumber+"\n Pin Number: "+pinNumber);

                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);

                }

            }catch (Exception e){
                System.out.println(e);
            }

        }else if (ae.getSource() == cancel){
            setVisible(false);
            new  Login().setVisible(true);

        }
    }
    public static void main(String[] args) {
        new SignUp_3("");
    }

}
