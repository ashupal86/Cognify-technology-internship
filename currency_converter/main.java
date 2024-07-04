package currency_converter;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class main extends JFrame{

    public main(){
        super("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel header = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Currency Converter");
        header.add(label);
        add(header, BorderLayout.NORTH);

        


        JPanel mainpanel = new JPanel(new GridLayout(2,1,10,10));
        
        add(mainpanel, BorderLayout.CENTER);


        JPanel component =new JPanel(new GridLayout(6,1,0,10));
        mainpanel.add(component);
        
        JTextField amount = new JTextField();
        
        component.add(amount);

        JLabel fromlabel = new JLabel("From : ");
        
        component.add(fromlabel);

        JComboBox<String> from = new JComboBox<>(new String[]{"USD", "EUR", "INR", "JPY", "GBP"});
        component.add(from);
        fromlabel.setLabelFor(from);

        JLabel tolabel = new JLabel("To : ");
        component.add(tolabel);

        JComboBox<String> to = new JComboBox<>(new String[]{"USD", "EUR", "INR", "JPY", "GBP"});
        component.add(to);
        tolabel.setLabelFor(to);

        JButton convert = new JButton("Convert");
        convert.addActionListener(toConvert -> {
            double amount1 = Double.parseDouble(amount.getText());
            double result = 0;
            String from1 = (String) from.getSelectedItem();
            String to1 = (String) to.getSelectedItem();


            // TODO: API calling is done but conversion of json into hashtable is not done
            CurrencyExchange api = new CurrencyExchange(from1, to1, amount1);

            
            
        
        });
        component.add(convert);

        JPanel result = new JPanel(new FlowLayout());
        mainpanel.add(result);
        
        JLabel resultl = new JLabel("Result: ");
        result.add(resultl);




        

        setVisible(true);
    }

    public static void main(String[] args) {
        new main();
    }
    
}
