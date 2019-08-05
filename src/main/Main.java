package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Main {
    JFrame mainFrame = new JFrame();
    JPanel panel = new JPanel();
    JTextPane poem  = new JTextPane();
    JButton submit = new JButton("Submit");
    Map<Integer, Character> map;
    public static void main(String[] args){
        Main main = new Main();
        main.runJFrame();
    }
    private void runJFrame(){
        map = new HashMap<>();

        panel.add(poem, Component.CENTER_ALIGNMENT);
        panel.add(submit);
        mainFrame.add(panel);
        mainFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        mainFrame.setVisible(true);
        submit.addActionListener(e -> lookInPoem());

    }

    private void lookInPoem(){
        int i = 0;
        String[] text = poem.getText().split(" ");

        for(String word : text){
            if(word.toCharArray()[0]== System.getProperty("line.separator").toCharArray()[0]){
                word.replace(System.getProperty("line.separator").toCharArray()[0],' ');
            }
            try {
                if(map.get(i) != word.toCharArray()[0]){
                    i=0;
                }
            }catch (NullPointerException ignored){

            }

            i++;

            map.put(i, word.toCharArray()[0]);
            System.out.println(i + "|" +word.toCharArray()[0]);
            //if i > 2 = allieration

            if((word.toCharArray()[word.length()-1]) == System.getProperty("line.separator").toCharArray()[0] && !(word.contains(",") || word.contains("."))){
                System.out.println("Enjabement");

            }
        }
    }
}
