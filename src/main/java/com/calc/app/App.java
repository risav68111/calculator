package com.calc.app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class App implements ActionListener  {
    JFrame frame;
    JTextField textfield;
    JButton[] numButtons= new JButton[10];
    JButton[] funcButtons= new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    Font myFont= new Font("Times New Roman", Font.PLAIN, 30);
    double num1=0, num2=0, result=0;
    char operator;

    App() {
        frame = new JFrame("App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield= new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        addButton= new JButton("+");
        subButton= new JButton("-");
        mulButton= new JButton("*");
        divButton= new JButton("/");
        decButton= new JButton(".");
        equButton= new JButton("=");
        delButton= new JButton("del");
        clrButton= new JButton("clr");
        negButton= new JButton("neg");
        
        funcButtons[0]= addButton;
        funcButtons[1]= subButton;
        funcButtons[2]= mulButton;
        funcButtons[3]= divButton;
        funcButtons[4]= decButton;
        funcButtons[5]= equButton;
        funcButtons[6]= delButton;
        funcButtons[7]= clrButton;
        funcButtons[8]= negButton;

        for(int i=0; i<9; i++) {
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myFont);
            funcButtons[i].setFocusable(false);
        }

        for(int i=0; i<10; i++) {
            numButtons[i]= new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setFocusable(false);
        }

        negButton.setBounds(50,430, 80, 50);
        delButton.setBounds(150, 430, 90, 50);
        clrButton.setBounds(255, 430, 95, 50);
        
        panel= new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.CYAN);

        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);
        
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);

        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(mulButton);
        
        panel.add(decButton);
        panel.add(numButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);

        frame.setVisible(true);
    }
    public static void main( String[] args ){
        @SuppressWarnings("unused")
        App app= new App();
        // System.out.println( "Hello World!" );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<10; i++) {
            if(e.getSource()== numButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()== decButton) {
            String s= textfield.getText();
            if(s.length()==0 || s.charAt(s.length()-1)== '.' || s.contains(".")) {
                textfield.setText(s);
            }else {
                textfield.setText(textfield.getText().concat("."));
            }
        }
        if(e.getSource()==addButton ) {
            num1= Double.parseDouble(textfield.getText());
            operator= '+';
            textfield.setText("");
        }
        if(e.getSource()==subButton ) {
            num1= Double.parseDouble(textfield.getText());
            operator= '-';
            textfield.setText("");
        }
        if(e.getSource()==mulButton ) {
            num1= Double.parseDouble(textfield.getText());
            operator= '*';
            textfield.setText("");
        }
        if(e.getSource()==divButton ) {
            num1= Double.parseDouble(textfield.getText());
            operator= '/';
            textfield.setText("");
        }
        if(e.getSource()==negButton ) {
            double temp= Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }
        if(e.getSource()== equButton) {
            num2= Double.parseDouble(textfield.getText());

            switch (operator) {
                // Supports onl for java version 14 onwards
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2; 
            }
            textfield.setText(String.valueOf(result));
        }
        if(e.getSource()== clrButton) {
            textfield.setText("");
        }
        if(e.getSource()== delButton) {
            String s= textfield.getText();
            if(s.length()>0) {
                textfield.setText(s.substring(0, s.length()-1));
            } else {
                textfield.setText("");
            }
        }
    }
}
