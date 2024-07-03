
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class tictaktoe extends JFrame{
    
    public boolean turn = true;
    
    public int matches = 0; 
    public int player1 = 0;
    public int player2 = 0;

    public tictaktoe(){
       // Create a frame with a title
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        
        
        JPanel header=new JPanel(new FlowLayout()); 

        JLabel label = new JLabel("Tic Tac Toe");
        this.add(label);

        JLabel label2 = new JLabel("Player 1: X");  
        header.add(label2);

        JLabel label3 = new JLabel("Player 2: O");
        header.add(label3);

        add(header, BorderLayout.NORTH);
        JPanel panel = new JPanel(new GridLayout(3, 3));
        
        // Create an array of buttons
        JButton[] buttons = new JButton[9];
        // Create a for loop to add buttons to the panel
        for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            panel.add(buttons[i]);
            buttons[i].addActionListener(e -> {
                JButton button = (JButton) e.getSource();
                if(turn){
                    button.setText("X");
                }else{
                    button.setText("O");
                }
                turn = !turn;
                button.setEnabled(false);
                check(buttons);
            });
        }
       
        this.add(panel, BorderLayout.CENTER);
        
        
       
        setVisible(true);

    }



   
  

    private void check(JButton[] buttons) {
        // TODO: Auto-generated method stub
        String b1 = buttons[0].getText();
        String b2 = buttons[1].getText();
        String b3 = buttons[2].getText();
        String b4 = buttons[3].getText();
        String b5 = buttons[4].getText();
        String b6 = buttons[5].getText();
        String b7 = buttons[6].getText();
        String b8 = buttons[7].getText();
        String b9 = buttons[8].getText();
    
       // This code snippet is checking if the buttons in the first row of the Tic Tac Toe board have
       // the same text (either "X" or "O") and are not empty. If all three buttons have the same text
       // and are not empty, it means a player has won the game by completing a row. In this case, a
       // message dialog is displayed indicating which player has won (the text on the winning
       // buttons), and the `reset()` method is called to reset the game board.
        if(b1.equals(b2) && b2.equals(b3) && !b1.equals("")){
            JOptionPane.showMessageDialog(this, b1 + " wins");
            reset(buttons);


        }
        if(b4.equals(b5) && b5.equals(b6) && !b4.equals("")){
            JOptionPane.showMessageDialog(this, b4 + " wins");
            reset(buttons);
        }
        if(b7.equals(b8) && b8.equals(b9) && !b7.equals("")){
            JOptionPane.showMessageDialog(this, b7 + " wins");
            reset(buttons);
        }
        if(b1.equals(b4) && b4.equals(b7) && !b1.equals("")){
            JOptionPane.showMessageDialog(this, b1 + " wins");
            reset(buttons);
        }
        if(b2.equals(b5) && b5.equals(b8) && !b2.equals("")){
            JOptionPane.showMessageDialog(this, b2 + " wins");
            reset(buttons);
        }
        if(b3.equals(b6) && b6.equals(b9) && !b3.equals("")){
            JOptionPane.showMessageDialog(this, b3 + " wins");
            reset(buttons);
        }
        if(b1.equals(b5) && b5.equals(b9) && !b1.equals("")){
            JOptionPane.showMessageDialog(this, b1 + " wins");
            reset(buttons);
        }
        if(b3.equals(b5) && b5.equals(b7) && !b3.equals("")){
            JOptionPane.showMessageDialog(this, b3 + " wins");
            reset(buttons);
        }
        if(!b1.equals("") && !b2.equals("") && !b3.equals("") && !b4.equals("") && !b5.equals("") && !b6.equals("") && !b7.equals("") && !b8.equals("") && !b9.equals("")){
            JOptionPane.showMessageDialog(this, "Draw");
            reset(buttons);
        }



    }
    private void reset(JButton[] buttons) {
        for(int i=0;i<9;i++){
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
    }




    public static void main(String[] args){
        new tictaktoe();
        
       

    }
}
