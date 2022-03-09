package com.Hesap;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillCalculator {
    private JPanel panel1;
    private JButton SalaryAveg;
    private JButton AgeAveg;
    private JButton addButton;
    private JTextField incTextField;
    private JTextField ageTextField;
    private JTextField nameTextField;
    private JTabbedPane tabbedPane1;
    private JLabel Name;
    private JLabel Age;
    private JLabel Age1;
    private JButton SearchButton;
    private JTextField Search;
    private JButton Load;
    private JButton Save;
    private JLabel Liste;
    private JTextField ResultButton;
    private JButton BillButton;
    private JTextField BillField;
    private JButton CalButton;
    private JTextField NameField;
    private JLabel TotalResultLabel;
    private JButton BillSaveButton;

    int cocounter=0;
    int index=0;
    int index3=0;
    int BillResult =0;


    public String[] name = new String[100];
    public String[] income = new String[100];
    public String[] age = new String[100];
    public String[] BillName =new String[100];
    public String[] Amount =new String[100];
    String NameLabel ="Name";
    String AgeLabel ="Age";
    String SearchedFor ="Name";
    String SalaryLabel ="Salary";
    String Result ="Bills";
    String BillResultStr ="Total Amount:"+BillResult;

    public BillCalculator() {
        KeyAdapter listener = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                name[index]= nameTextField.getText();
                age[index]= ageTextField.getText();
                income[index]= incTextField.getText();


                super.keyReleased(e);
            }
        };
        incTextField.addKeyListener(listener);
        ageTextField.addKeyListener(listener);
        nameTextField.addKeyListener(listener);

        addButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {//Name Age And Salary Viewer
                NameLabel =("<html>"+(index+1+cocounter)+"."+ name[index]+"<br>"+ NameLabel +"<html>");
                AgeLabel =("<html>"+(index+1+cocounter)+"."+ age[index]+"<br>"+ AgeLabel +"<html>");
                SalaryLabel =("<html>"+(index+1+cocounter)+"."+ income[index]+"<br>"+ SalaryLabel +"<html>");
                Name.setText(NameLabel);
                Age.setText(SalaryLabel);
                Age1.setText(AgeLabel);
                index++;
            }
        });




        AgeAveg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//Average Age Calculation

                float result = 0,index2=0,i=0;
                while(i<index+cocounter+3)
                {
                    if(age[(int) i]!=null){
                    index2 = Integer.parseInt(age[(int)i]);
                    result =index2+ result;}
                    i++;

                }
                result = result /(index+cocounter);
                JOptionPane.showMessageDialog(null,"Average Age:"+ result);

            }
        });


        SalaryAveg.addActionListener(new ActionListener() {//Average Salary Calculation
            @Override
            public void actionPerformed(ActionEvent e) {
                float result = 0,index2=0,i=0;
                while(i<index+cocounter+3)
                {    if(income[(int) i]!=null){
                    index2 = Integer.parseInt(income[(int)i]);
                    result =index2+ result;}
                    i++;

                }
                result = result /(index+cocounter);
                JOptionPane.showMessageDialog(null,"Average Salary:"+ result);



            }
        });




        SearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchedFor = Search.getText();
                int sonuc1 = 0,index2=0,i=0;
                for(i=0;i<index+cocounter+3;i++)
                {
                    if(SearchedFor.equalsIgnoreCase(name[i]))
                    {
                        sonuc1=i;
                    }

                }
                if (SearchedFor.equalsIgnoreCase(name[sonuc1])){
                    JOptionPane.showMessageDialog(null,"<html>"+"Income:"+ income[sonuc1]+"<br>"+"Age :"+ age[sonuc1]+"<html>");}
                else{
                    JOptionPane.showMessageDialog(null,"That name doesn't exist.");}



            }
        });
        Load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {//Scanner for names
                    File txt = new File("D:/NameList.txt");
                    Scanner scan = new Scanner(txt);
                    ArrayList<String> data = new ArrayList<String>() ;
                    while(scan.hasNextLine()){
                        data.add(scan.nextLine());
                    }
                    System.out.println(data);
                    ListReader(data);



// If you want to convert to a String[]
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    try (FileWriter writer = new FileWriter("D:/NameList.txt")) {
                        String[] ad = BillCalculator.this.name;
                        String[] yas = BillCalculator.this.age;
                        String[] maas = BillCalculator.this.income;

                        //Kaydetme Kısmı Tamam.Fakat Yükleme kısmı yapılmadı
                            int i =0;
                            writer.write("NameList"+"\n");
                            for(i=0;i<ad.length;i++){
                                if(ad[i]!=null){
                                    String Fatura="\n"+ad[i]+"\n"+yas[i]+"\n"+maas[i];
                                    writer.write(Fatura);

                                }

                            }
                        writer.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });


        InputMethodListener listener1 = new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {


            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        };
        BillField.addInputMethodListener(listener1);
        ResultButton.addInputMethodListener(listener1);

        BillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Result ="<html>"+ BillName[index3]+":"+ Amount[index3]+"<br>"+"<html>"+ Result;
                Liste.setText(Result);
                BillResult =Integer.parseInt(Amount[index3])+ BillResult;
                BillResultStr ="Total Amount:"+ BillResult;
                TotalResultLabel.setText(BillResultStr);
                index3++;



            }
        });
        InputMethodListener listener2 = new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {

            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        };
        BillField.addInputMethodListener(listener2);
        ResultButton.addInputMethodListener(listener2);
        KeyAdapter listener3 = new KeyAdapter() {
        };


        BillField.addKeyListener(listener3);
        ResultButton.addKeyListener(listener3);
        KeyAdapter listener4 = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                BillName[index3]= BillField.getText();
                Amount[index3]= ResultButton.getText();
                super.keyReleased(e);
            }
        };


        BillField.addKeyListener(listener4);
        ResultButton.addKeyListener(listener4);

        CalButton.addActionListener(new ActionListener() {//This Method Calculates "Can this Person in the Namefield pay his/her bills ?"
            @Override
            public void actionPerformed(ActionEvent e) {
                String Person;
                Person= NameField.getText();
                int sonuc2 = 0,index2=0,i=0;
                while(i<index+cocounter+3)
                {
                    if(Person.equalsIgnoreCase(name[i]))
                    {
                        sonuc2=i;
                    }
                    i++;
                }

                if (Person.equalsIgnoreCase(name[sonuc2])){
                    BillResult =Integer.parseInt(income[sonuc2])- BillResult;
                    if(BillResult <0){ JOptionPane.showMessageDialog(null,"<html>"+"Your income is more than your expenses.Your Debt:"+ BillResult +"<html>");}
                    else if(BillResult ==0){ JOptionPane.showMessageDialog(null,"<html>"+"Your Salary is Fully Enough for Your Bills.Your Debt:"+ BillResult +"<html>");}
                    else if(BillResult >0){ JOptionPane.showMessageDialog(null,"<html>"+"Your Bills Are Fully Paid.Your Remaining Money:"+ BillResult +"<html>");}
                   }
                else{ JOptionPane.showMessageDialog(null,"That name doesn't exist.");}


            }
        });


        BillSaveButton.addActionListener(new ActionListener() {//For Saving Bill Variables to text file.
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    try (FileWriter writer = new FileWriter("D:/BillOutput.txt")) {
                        String[] BillName = BillCalculator.this.BillName;
                        String[] Amount = BillCalculator.this.Amount;
                        int i =0;
                        writer.write("Bill List"+"\n");
                        for(i=0; i< BillName.length; i++){
                            if(BillName[i]==null){}else{
                            String Bill="\n"+ BillName[i]+":"+ Amount[i];
                            writer.write(Bill);
                            }
                        }
                        writer.write("\n"+"-----------------------------"+"\n"+"Total:"+BillResult);
                       }
                }



                catch (IOException exception) {
                    exception.printStackTrace();
                }
                }
        });
    }



    public void ListReader(List liste) {
        byte index6=0;
        byte indexchanger=2;
        String[] name = BillCalculator.this.name;
        String[] age = BillCalculator.this.age;
        String[] sal = BillCalculator.this.income;
        Integer counter= 1;
        for(int i=2;i<liste.size();i=i+3)//For Names
        {
            name[counter]= (String) liste.get(i);
            counter++;

        }
        counter=1;
        for(int i=4;i<liste.size();i=i+3)//For moni :D (sal==salary)
        {
            sal[counter]= (String) liste.get(i);
            counter++;

        }
        counter=1;
        for(int i=3;i<liste.size();i=i+3)//For ages
        {
            age[counter]= (String) liste.get(i);counter++;


        }
        counter=1;
        Rewriter(liste);
        return;

    }

    public void Rewriter(List liste)
    {
        NameLabel ="";
        AgeLabel ="";
        SalaryLabel ="";
        for(int i=1;i< ((liste.size()-2)/3)+1;i++){
            cocounter++;
            NameLabel =("<html>"+(i)+"."+ name[i]+"<br>"+ NameLabel +"<html>");}
        for(int i=1;i<((liste.size()-2)/3)+1;i++){ AgeLabel =("<html>"+(i)+"."+ age[i]+"<br>"+ AgeLabel +"<html>");}
        for(int i=1;i<((liste.size()-2)/3)+1;i++){
            SalaryLabel =("<html>"+(i)+"."+ income[i]+"<br>"+ SalaryLabel +"<html>");}
        Name.setText(NameLabel);
        Age.setText(SalaryLabel);
        Age1.setText(AgeLabel);
        return;
    }
    public static void main(String[] args) {
        JFrame frame=new JFrame("Income Calculator App");
        frame.setContentPane(new BillCalculator().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
