package currency_converter;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.*;

public class main extends JFrame{

    public static ArrayList<String> currency = new ArrayList<String>();

    public main(){
        super("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setResizable(false);

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

        JComboBox<String> from = new JComboBox<>(new String[]{"Select From Currency","USD", "EUR", "INR", "JPY", "GBP", "AUD","CAD","CHF","CNY","HKD","NZD","SEK","KRW","SGD","NOK","MXN","INR","RUB","ZAR","TRY","BRL","TWD","DKK","PLN","THB","IDR","HUF","CZK","ILS","CLP","PHP","AED","COP","SAR","MYR","RON","CNY","ARS","VND","IQD","QAR","KWD","PKR","EGP","BDT","LKR","NPR","KZT","OMR","TND","UGX","GHS","BYN","AZN","DZD","MAD","UZS","XOF","RSD","KHR","AFN","CUP","CRC","SYP","YER","NAD","MZN","ANG","SDG","TMT","GNF","LAK","MMK","GEL","MDL","BHD","ZMW","MNT","BIF","HTG","MKD","DJF","MOP","XAF","LBP","SZL","TOP","JMD","GMD","FJD","SLL","LRD","SRD","MWK","BZD","SBD","PGK","ETB","GYD","MVR","ERN","XPF","MGA","CVE","BSD","WST","STN","TJS","KGS","LSL","GIP","FKP","XCD","SRG","XDR","MRO","SHP","SOS","SVC","TVD","KID","CNH","IMP","GGP","JEP","ZWL","TMT","ZMW","ZWL","ZWN","ZWR"});
        component.add(from);
        from.setSelectedItem("Select From Currency");
        from.addActionListener(from1 -> {
            String from_country = (String) from.getSelectedItem();
            System.out.println(from_country);
        });
        fromlabel.setLabelFor(from);

        

        JComboBox<String> to = new JComboBox<>(new String[]{"Select to Currency","USD", "EUR", "INR", "JPY", "GBP", "AUD","CAD","CHF","CNY","HKD","NZD","SEK","KRW","SGD","NOK","MXN","INR","RUB","ZAR","TRY","BRL","TWD","DKK","PLN","THB","IDR","HUF","CZK","ILS","CLP","PHP","AED","COP","SAR","MYR","RON","CNY","ARS","VND","IQD","QAR","KWD","PKR","EGP","BDT","LKR","NPR","KZT","OMR","TND","UGX","GHS","BYN","AZN","DZD","MAD","UZS","XOF","RSD","KHR","AFN","CUP","CRC","SYP","YER","NAD","MZN","ANG","SDG","TMT","GNF","LAK","MMK","GEL","MDL","BHD","ZMW","MNT","BIF","HTG","MKD","DJF","MOP","XAF","LBP","SZL","TOP","JMD","GMD","FJD","SLL","LRD","SRD","MWK","BZD","SBD","PGK","ETB","GYD","MVR","ERN","XPF","MGA","CVE","BSD","WST","STN","TJS","KGS","LSL","GIP","FKP","XCD","SRG","XDR","MRO","SHP","SOS","SVC","TVD","KID","CNH","IMP","GGP","JEP","ZWL","TMT","ZMW","ZWL","ZWN","ZWR"});
        from.setSelectedItem("Select to Currency");
        component.add(to);

        JPanel resultpanel = new JPanel(new FlowLayout());
        JLabel resultl = new JLabel();

        JButton convert = new JButton("Convert");
        convert.addActionListener(toConvert -> {
            String amounts = amount.getText();
            if (amounts.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the amount to convert", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double amount1 = Double.parseDouble(amounts);
           
            double result = 0;
            String from1 = (String) from.getSelectedItem();
            String to1 = (String) to.getSelectedItem();

            if(from1.equals("Select From Currency") || to1.equals("Select to Currency")){
             
               
                    
                    JOptionPane.showMessageDialog(this, "Please select currency to convert from to", "Currrency not sellected", JOptionPane.INFORMATION_MESSAGE);
              
            
            }else{
                CurrencyExchange api = new CurrencyExchange(from1, amount1);
                result = api.convertCurrency(to1, amount1);
                
                
               
                resultl.setText("Result: " + result);
                
                System.out.println(result);
            }


        

            
            
        
        });
        component.add(convert);
        resultpanel.add(resultl);
        mainpanel.add(resultpanel);

      
        
       




        

        setVisible(true);
    }

   

    public static void main(String[] args) {
        new main();
    }
    
}
