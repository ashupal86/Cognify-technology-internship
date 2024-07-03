package currency_converter;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class main extends JFrame{

    public main(){
        super("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel header = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Currency Converter");
        header.add(label);
        add(header, BorderLayout.NORTH);

        JPanel mainpanel = new JPanel();
        add(mainpanel, BorderLayout.CENTER);
        
        // JPanel amo

        setVisible(true);
    }

    public static void main(String[] args) {
        new main();
    }
    
}
