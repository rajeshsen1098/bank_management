package  bank_management;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;


public class Login extends JFrame implements ActionListener{
    
    JButton login,clear,signup;
    JTextField cn;
    JPasswordField pt;


    Login(){
        // super();
        setTitle("ATM");
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel label =new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);


        JLabel text =new JLabel("WELCOME TO ATM");
        add(text);
        text.setBounds(200,10,1000,40);
        text.setFont(new Font("Osward",Font.BOLD,38));
        getContentPane().setBackground(Color.white);

        JLabel cardno =new JLabel("card no:");
        add(cardno);
        cardno.setBounds(150,150,150,40);
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        getContentPane().setBackground(Color.white);

        cn =new JTextField();
        add(cn);
        cn.setBounds(350,154,200,30);





        JLabel pin =new JLabel("pin");
        add(pin);
        pin.setBounds(150,250,1000,40);
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        getContentPane().setBackground(Color.white);

        pt =new JPasswordField();
        add(pt);
        pt.setBounds(350,250,200,30);


        login=new JButton("Sign In");
        login.setBounds(300,350,80,30);
        add(login);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);


       clear=new JButton("clear");
        clear.setBounds(500,350,80,30);
        add(clear);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);

        signup=new JButton("sign up");
        signup.setBounds(400,400,80,30);
        add(signup);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);

        
        setSize(700,600);
        setVisible(true);
        setLocation(300,150);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cn.setText("");
            pt.setText("");

        }else if(ae.getSource() ==login){

        }else if(ae.getSource()== signup){

        }

    }
       
    public static void main(String[] args) {
        new Login();
    }
}
