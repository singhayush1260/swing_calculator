/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ayush Singh
 */
package basic.calculator;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class BasicCalculator extends JFrame implements ActionListener {
    JFrame frame;
    JPanel text_field_panel, button_panel;
    JTextField text_field;
    JButton open_bracket, close_bracket, clear_button,division_button;
    JButton seven_button, eight_button, nine_button, multiply_button;
    JButton four_button, five_button, six_button, subtract_button;
    JButton one_button, two_button, three_button, add_button;
    JButton  zero_button, dot_button, del_button, equal_button;
    
    EvaluateExpression cal=new EvaluateExpression();
    
    BasicCalculator() {
        createGUI();
        addComponents();
        addEventListener();
    }

    public void createGUI() {
        frame = new JFrame("Basic Calculator");
        frame.setSize(450, 650);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        text_field_panel = new JPanel();
        text_field_panel.setPreferredSize(new Dimension(450, 150));
        //text_field_panel.setBackground(Color.red);

        button_panel = new JPanel();
       //button_panel.setBackground(Color.green);
        GridLayout grid_layout = new GridLayout(5, 4);
        grid_layout.setHgap(2);
        grid_layout.setVgap(2);
        button_panel.setLayout(grid_layout);

        frame.setLayout(new BorderLayout());
        frame.add(text_field_panel, BorderLayout.NORTH);
        frame.add(button_panel, BorderLayout.CENTER);
    }

    public void addComponents() {
        text_field = new JTextField();
        text_field.setPreferredSize(new Dimension(420, 140));
        text_field.setFont(new Font("Arial", Font.BOLD, 60));
        text_field.setHorizontalAlignment(SwingConstants.RIGHT);
        text_field_panel.add(text_field);

        open_bracket = new JButton("(");
        open_bracket.setPreferredSize(new Dimension(40, 40));
        button_panel.add(open_bracket);

        close_bracket = new JButton(")");
        close_bracket.setPreferredSize(new Dimension(40, 40));
        button_panel.add(close_bracket);

        clear_button = new JButton("CLEAR");
        clear_button.setPreferredSize(new Dimension(40, 40));
        button_panel.add(clear_button);

        del_button = new JButton("DELETE");
        del_button.setPreferredSize(new Dimension(40, 40));
        button_panel.add(del_button);

        division_button = new JButton("/");
        division_button.setPreferredSize(new Dimension(40, 40));
        button_panel.add(division_button);

        seven_button = new JButton("7");
        seven_button.setPreferredSize(new Dimension(40, 40));
        button_panel.add(seven_button);

        eight_button = new JButton("8");
        eight_button.setPreferredSize(new Dimension(40, 40));
        button_panel.add(eight_button);

        nine_button = new JButton("9");
        nine_button.setPreferredSize(new Dimension(40, 40));
        button_panel.add(nine_button);

        multiply_button = new JButton("*");
        multiply_button.setPreferredSize(new Dimension(40, 40));
        button_panel.add(multiply_button);

        four_button = new JButton("4");
        four_button.setPreferredSize(new Dimension(40, 40));
        button_panel.add(four_button);

        five_button = new JButton("5");
        five_button.setPreferredSize(new Dimension(40, 40));
        button_panel.add(five_button);

        six_button = new JButton("6");
        six_button.setPreferredSize(new Dimension(40, 40));
        button_panel.add(six_button);

        subtract_button = new JButton("-");
        subtract_button.setPreferredSize(new Dimension(40, 40));
        button_panel.add(subtract_button);

        one_button = new JButton("1");
        one_button.setPreferredSize(new Dimension(40, 40));
        button_panel.add(one_button);

        two_button = new JButton("2");
        two_button.setPreferredSize(new Dimension(40, 40));
        button_panel.add(two_button);

        three_button = new JButton("3");
        three_button.setPreferredSize(new Dimension(40, 40));
        button_panel.add(three_button);

        add_button = new JButton("+");
        add_button.setPreferredSize(new Dimension(40, 40));
        button_panel.add(add_button);

        zero_button = new JButton("0");
        zero_button.setPreferredSize(new Dimension(40, 40));
        button_panel.add(zero_button);

        dot_button = new JButton(".");
        dot_button.setPreferredSize(new Dimension(40, 40));
        button_panel.add(dot_button);

        equal_button = new JButton("=");
        equal_button.setPreferredSize(new Dimension(40, 40));
        button_panel.add(equal_button);
    }
    public void addEventListener()
    {
        open_bracket.addActionListener(this);
        close_bracket.addActionListener(this);
        clear_button.addActionListener(this);
        division_button.addActionListener(this);
        seven_button.addActionListener(this);
        eight_button.addActionListener(this);
        nine_button.addActionListener(this);
        multiply_button.addActionListener(this);
        four_button.addActionListener(this);
        five_button.addActionListener(this);
        six_button.addActionListener(this);
        subtract_button.addActionListener(this);
        one_button.addActionListener(this);
        two_button.addActionListener(this);
        three_button.addActionListener(this);
        add_button.addActionListener(this);
        zero_button.addActionListener(this);
        dot_button.addActionListener(this);
        del_button.addActionListener(this);
        equal_button.addActionListener(this);
    }
@Override
    public void actionPerformed(ActionEvent e) {
        String new_value=e.getActionCommand();
        String old_value=text_field.getText();
        
        if(new_value.equals("=")){
            String result=cal.calculate(old_value);
            if(result.equals("SE")){
                text_field.setText("Syntax Error");
            }else{
              text_field.setText(result);
            }
        }
        else if(new_value.equals("DELETE")){
            String value=text_field.getText();
            int l=value.length();
            if(l>0){
             text_field.setText(value.substring(0,l-1));
            }
        }
        else if(new_value.equals("CLEAR")){
          text_field.setText("");
        }
        else{
            text_field.setText(old_value+new_value);
        }
        System.out.println(e.getActionCommand());
    }
//    public double calculate(){
//        System.out.println("Calculating.....");
//        return 0.0;
//    }
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BasicCalculator();
            }
        });
    }
}

