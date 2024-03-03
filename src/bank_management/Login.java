package bank_management;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, clear, signup;                   //Globally declear variable for use in actionPerfromed method
    JTextField cn;
    JPasswordField pt;

    Login() {                                       // Login constructar

        setTitle("ATM");                                                                         // title of frame
        setLayout(null);                                                                      // by default frame has its own layout
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));           // ClassLoader.getSystemResource
                                                                                                    // load url from system path
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);    // set height,weight
        ImageIcon i3 = new ImageIcon(i2);                                                         // Convert to ImageIcon
        JLabel label = new JLabel(i3);                                                           // convert to label bcoz it can't convert image object to label
        label.setBounds(70, 10, 100, 100);                                     // we do owr won layout,setBound use for custom layout
        add(label);                                                                            // for added to frame

        JLabel text = new JLabel("WELCOME TO ATM");                                     // this is a new label for text
        add(text);
        text.setBounds(200, 10, 1000, 40);
        text.setFont(new Font("Osward", Font.BOLD, 38));
        getContentPane().setBackground(Color.white);

        JLabel cardno = new JLabel("card no:");
        add(cardno);
        cardno.setBounds(150, 150, 150, 40);
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        getContentPane().setBackground(Color.white);

        cn = new JTextField();                                                               // cn is a JTextField which is declear in globally for global uses
        add(cn);
        cn.setBounds(350, 154, 200, 30);
        cn.setBackground(Color.LIGHT_GRAY);

        JLabel pin = new JLabel("pin");
        add(pin);
        pin.setBounds(150, 250, 1000, 40);
        pin.setFont(new Font("Raleway", Font.BOLD, 28));                             // similar to cn object
        getContentPane().setBackground(Color.white);

        pt = new JPasswordField();                                                          // JPasswordField is use for password Hidden .in is in Javax.swing.*;
        add(pt);
        pt.setBounds(350, 250, 200, 30);
        pt.setBackground(Color.LIGHT_GRAY);

        login = new JButton("Sign In");                                             // JButton use to create button
        login.setBounds(300, 350, 80, 30);
        add(login); 
        login.setBackground(Color.BLACK);                                             // background color
        login.setForeground(Color.white);                                            // font color
        login.addActionListener(this);                                              // it use for after click what to to next(javax.swing).it return itself,thus
                                                                                   // "this" keyword use for return

        clear = new JButton("clear");
        clear.setBounds(500, 350, 80, 30);                     // similar to login button
        add(clear);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);

        signup = new JButton("sign up");
        signup.setBounds(400, 400, 80, 30);                  // similar to login button
        add(signup);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);

        setSize(700, 600);                       // SET size of frame
        setVisible(true);                                  // By default frame is non-visible,so it visible the frame
        setLocation(300, 150);                          // location of frame
    }

    public void actionPerformed(ActionEvent i) {         //actionPerformed Invoked when an action occurs.
        if (i.getSource() == clear) {                   //getSource take what ActionListener click
            cn.setText("");                          //if it takes clear that do or else if or else do.... 
            pt.setText("");

        } else if (i.getSource() == login) {

            Conn co=new Conn();
            String cardNumber =cn.getText();
            String pinNumber=pt.getText();
            String quary ="select * from login where cardNumber = '"+cardNumber+"'and pin_number = '"+pinNumber+"';";
            try{

                ResultSet rs=co.s.executeQuery(quary);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }

            }catch (Exception e) {
                System.out.println(e);
            }
        } else if (i.getSource() == signup) {
            setVisible(false);
            new SignUp_1().setVisible(true);

        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
