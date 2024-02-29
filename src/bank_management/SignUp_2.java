package bank_management;

import java.awt.*;
import java.awt.event.*;
//import java.awt.event.ActionListener;
import javax.swing.*;


public class SignUp_2 extends JFrame implements ActionListener {
//    int random;
    JTextField panTextField,aadharNumberTextField;
    JRadioButton eyes,eno,sno,syes;
    JButton next;
//    ButtonGroup senionCitizenGroup;
    JComboBox cata,relig,occu,edu,inco;
    String formno;
//
    SignUp_2(String formno){
        this.formno=formno;

        setLayout(null);
        setTitle("new application : from 2");


        JLabel additionalDetail =new JLabel("Page No. 2 :Additional Detail");
        additionalDetail.setFont(new Font("Raleway",Font.BOLD,20));
        additionalDetail.setBounds(240,70,300,30);
        add(additionalDetail);

        JLabel religion =new JLabel("Religion: ");
        religion.setFont(new Font("Raleway",Font.BOLD,15));
        religion.setBounds(80,120,300,30);
        add(religion);

        String []varReligion={"Hindu","Muslim","Sikh","Christan","Other"};
         relig = new JComboBox(varReligion);
        relig.setBounds(250,120,200,20);
        relig.setBackground(Color.LIGHT_GRAY);
        add(relig);



        JLabel category =new JLabel("Category ");
        category.setFont(new Font("Raleway",Font.BOLD,15));
        category.setBounds(80,150,300,30);
        add(category);

        String []varcategory={"General","OBC-A","OBC-B","SC","ST"};
         cata=new JComboBox<>(varcategory);
        cata.setBounds(250,150,200,20);
        cata.setBackground(Color.LIGHT_GRAY);
        add(cata);




        JLabel income =new JLabel("Income");
        income.setFont(new Font("Raleway",Font.BOLD,15));
        income.setBounds(80,180,300,30);
        add(income);

        String []varincome={"0 to 1,50,000","<2,50,000","<5,00,000","Above 10,00,000"};
         inco=new JComboBox(varincome);
        inco.setBounds(250,180,200,20);
        inco.setBackground(Color.LIGHT_GRAY);
        add(inco);



        JLabel education =new JLabel("Edu. Qualification");
        education.setFont(new Font("Raleway",Font.BOLD,15));
        education.setBounds(80,210,300,30);
        add(education);

        String []varEducation={"Non_graduation","Graduation","Post_Graduation","PHD","other"};
         edu=new JComboBox(varEducation);
        edu.setBounds(250,210,200,20);
        edu.setBackground(Color.LIGHT_GRAY);
        add(edu);

        JLabel occupation =new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway",Font.BOLD,15));
        occupation.setBounds(80,240,300,30);
        add(occupation);

        String []varOccupation={"Salaried","Self_Employed","Bussiness","Student","Retired","Other"};
         occu=new JComboBox(varOccupation);
        occu.setBounds(250,240,200,20);
        occu.setBackground(Color.LIGHT_GRAY);
        add(occu);


        JLabel panNumber =new JLabel("PAN Number: ");
        panNumber.setFont(new Font("Raleway",Font.BOLD,15));
        panNumber.setBounds(80,270,300,30);
        add(panNumber);

        panTextField =new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,15));
        panTextField.setBounds(250,270,200,20);
        add(panTextField);

        JLabel aadharNumber =new JLabel("Aadhar Number: ");
        aadharNumber.setFont(new Font("Raleway",Font.BOLD,15));
        aadharNumber.setBounds(80,300,300,30);
        add(aadharNumber);

        aadharNumberTextField =new JTextField();
        aadharNumberTextField.setFont(new Font("Raleway",Font.BOLD,15));
        aadharNumberTextField.setBounds(250,300,200,20);
        add(aadharNumberTextField);

        JLabel seniorCitizen =new JLabel("Senior Citizen: ");
        seniorCitizen.setFont(new Font("Raleway",Font.BOLD,15));
        seniorCitizen.setBounds(80,330,300,30);
        add(seniorCitizen);

           syes =new JRadioButton("YES");
        syes.setBounds(250,330,50,20);
        syes.setBackground(Color.white);
        add(syes);

        sno =new JRadioButton("NO");
        sno.setBounds(320,330,50,20);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup senionCitizenGroup=new ButtonGroup();
                senionCitizenGroup.add(syes);
               senionCitizenGroup.add(sno);

        JLabel existingAccount =new JLabel("Existing Account: ");
        existingAccount.setFont(new Font("Rale way",Font.BOLD,15));
        existingAccount.setBounds(80,360,300,30);
        add(existingAccount);

        eyes =new JRadioButton("YES");
        eyes.setBounds(250,360,50,20);
        eyes.setBackground(Color.white);
        add(eyes);

        eno =new JRadioButton("NO");
        eno.setBounds(320,360,50,20);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup existingCitizenGroup=new ButtonGroup();
        existingCitizenGroup.add(eyes);
        existingCitizenGroup.add(eno);


        next=new JButton("Next");
        add(next);
        next.setBounds(400,450,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.ORANGE);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.addActionListener(this);



        setSize(700,600);
        setLocation(350,10);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }
    public void actionPerformed(ActionEvent ae){
//        String formno = ""+random;
        String sreligion= (String) relig.getSelectedItem();
        String scatagory= (String) cata.getSelectedItem();
        String soccupation= (String) occu.getSelectedItem();
        String seducation= (String) edu.getSelectedItem();
        String sincome= (String) inco.getSelectedItem();


        String seniCiti =null;
        if(syes.isSelected()){
            seniCiti="YES";
        }else if(sno.isSelected()){
            seniCiti="NO";
        }

        String existingAccount =null;
        if(eyes.isSelected()){
            existingAccount="YES";
        }else if(eno.isSelected()){
            existingAccount="NO";

        }
        String span=panTextField.getText();
        String saadhar=aadharNumberTextField.getText();

        try{

                conn p=new conn();
                String quary="insert into signup_2 values('"+formno+"','"+sreligion+"','"+saadhar+"','"+span+"','"+scatagory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+seniCiti+"','"+existingAccount+"')";
                p.s.executeUpdate(quary);




        }catch(Exception e){

        }

    }

    public static void main(String[] args) {

        new SignUp_2("");
    }

}
