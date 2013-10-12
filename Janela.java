/**
 * GITHUB - LUCASOLIVEIRA94
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.Timer;  

public class Janela extends JFrame implements ActionListener{
    
    Game jogo;
    JLabel lblGame;
    JButton btnNext, btnPlay, btnStop, btnSobre;
    Timer t;
    
    Janela(){
        jogo = new Game();
        lblGame = new JLabel();
        //jogo.setPxMorto("-");
        //jogo.setPxVivo("#");
        autoReproduzir();
    }
    
    public void executar(){
        montarJanela();
        montarTexto(jogo.inicializar());
    }
    
    private void montarJanela(){
        this.setTitle("JOGO DA VIDA");
        this.setSize(230, 320);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);      
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        
        btnNext = new JButton("Next >>");
        btnNext.setSize(80, 25);
        btnNext.setLocation(25, 225);
        btnNext.addActionListener(this);
        this.add(btnNext);
        
        btnPlay = new JButton("Play");
        btnPlay.setSize(80, 25);
        btnPlay.setLocation(115, 225);
        btnPlay.addActionListener(this);
        this.add(btnPlay);
        
        btnStop = new JButton("Stop");
        btnStop.setSize(80, 25);
        btnStop.setLocation(25, 255);
        btnStop.addActionListener(this);
        this.add(btnStop);
        
        btnSobre = new JButton("Sobre");
        btnSobre.setSize(80, 25);
        btnSobre.setLocation(115, 255);
        btnSobre.addActionListener(this);
        this.add(btnSobre);
        
        lblGame.setText("");
        lblGame.setLocation(20, 5);
        lblGame.setSize(180, 300);
        lblGame.setVerticalAlignment(lblGame.TOP);
        lblGame.setVerticalTextPosition(lblGame.TOP);
        lblGame.setFont(new Font("Courier New", Font.BOLD, 16));
        this.add(lblGame);
    }
    
    private void montarTexto(String[][] m){
   
        String matriz[][] = m;
        String txt = "<html>";
        
        for (int a = 0; a < jogo.getX(); a++){
            for (int b = 0; b < jogo.getY(); b++){
                txt += matriz[a][b];
            }
            txt += "<br />";
        }
        txt += "</html>";

        lblGame.setText(txt);
        
    }
    
    private void autoReproduzir() {  
        ActionListener action = new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                lblGame.setText("");
                montarTexto(jogo.reproduzir());
            }  
        };  
        t = new Timer(700, action);
    }
    
    public void actionPerformed(ActionEvent e){
       
        if (e.getSource() == btnNext){
            lblGame.setText("");
            montarTexto(jogo.reproduzir());
            t.stop();
        }else
        if (e.getSource() == btnPlay){
            if (!t.isRunning()){
                t.start();
            }
        }else
        if (e.getSource() == btnStop){
            if (t.isRunning()){
                t.stop();
                montarTexto(jogo.inicializar());
            }
        }
        
    }
   
}
