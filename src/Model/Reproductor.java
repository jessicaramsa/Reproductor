/*
 * Reproductor.java
 * 21 Marzo 2017
 * Reproductor de música
 * RAMIREZ SANCHEZ JESSICA
 */

package Model;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Reproductor {
    final String images = "src/imgs/";
    
    AudioClip               enReproduccion;
    int                     a;              // cancion actual en reproduccion
    int                     actual[];
    boolean                 tocando;        // en reproduccion o en pausa
    JFrame                  ventana;        // reproductor
    JPanel                  panel;          
    JButton                 anterior;       // cancion anterior
    JButton                 siguiente;      // siguiente cancion
    JButton                 plause;         // play / pause
    JLabel                  imagenF;
    ArrayList<String>       canciones;
    
    public static void main(String[] args) {
        Reproductor play = new Reproductor();
        play.show();
    }
    
    void show(){
        crear();
        configurar();
        correr();
    }
    
    void crear() {
        tocando        = false;
        ventana        = new JFrame();
        panel          = new JPanel();
        anterior       = new JButton();
        siguiente      = new JButton();
        plause         = new JButton();
        imagenF        = new JLabel();
        canciones      = new ArrayList<>();
    }
    
    void configurar() {
        ventana.setSize(400, 400);
        ventana.setTitle("Reprodructor de musica");
        ventana.setLocationRelativeTo(null);
        ventana.setIconImage(new ImageIcon(images + "Logo.png").getImage());
        
        imagenF.setIcon(new ImageIcon(images + "Boston.jpg"));
        imagenF.setBounds(0, 0, 400, 400);
        imagenF.setVisible(true);
        
        canciones.add("01  More Than A Feeling");
        canciones.add("02  Peace Of Mind");
        canciones.add("03  Foreplay,Long Time");
        canciones.add("04  Rock & Roll Band");
        canciones.add("05  Smokin'");
        canciones.add("06  Hitch A Ride");
        canciones.add("07  Something About You");
        canciones.add("08  Let Me Take You Home Tonight");
        
        anterior.setIcon(new ImageIcon(images + "anterior.png"));
        anterior.setBorderPainted(false);
        anterior.setContentAreaFilled(false);
        anterior.setFocusable(false);
        anterior.setBounds(92, 289, 68, 32);
        anterior.addActionListener(new BotonDerecho());
        
        plause.setIcon(new ImageIcon(images + "plause1.png"));
        plause.setBorderPainted(false);
        plause.setContentAreaFilled(false);
        plause.setFocusable(false);
        plause.setBounds(170, 275, 60, 60);
        plause.addActionListener(new BotonDerecho());
        
        siguiente.setIcon(new ImageIcon(images + "siguiente.png"));
        siguiente.setBorderPainted(false);
        siguiente.setContentAreaFilled(false);
        siguiente.setFocusable(false);
        siguiente.setBounds(240, 289, 68, 32);
        siguiente.addActionListener(new BotonDerecho());
        
        panel.setLayout(null);
        panel.add(anterior);
        panel.add(plause);
        panel.add(siguiente);
        panel.add(imagenF);
    }
    
    void correr() {
        ventana.getContentPane().add(panel);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    class BotonDerecho implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == anterior) {
                if(tocando == true){
                    enReproduccion.stop();
                    if(a == 0)
                        a = 7;
                    else
                        a = a - 1;
                    ventana.setTitle(canciones.get(a));
                    imagenF.setIcon(new ImageIcon(images + "Boston1.jpg"));
                    plause.setIcon(new ImageIcon(images + "plause2.png"));
                    enReproduccion = Applet.newAudioClip(Reproductor.class.
                            getResource(canciones.get(a) + ".wav"));
                    enReproduccion.play();
                    tocando = true;
                } else {
                    if(a == 0)
                        a = 7;
                    else
                        a = a - 1;
                    ventana.setTitle(canciones.get(a));
                    imagenF.setIcon(new ImageIcon(images + "Boston1.jg"));
                    plause.setIcon(new ImageIcon(images + "plause2.png"));
                    enReproduccion = Applet.newAudioClip(Reproductor.class.
                            getResource(canciones.get(a) + ".wav"));
                    enReproduccion.play();
                    tocando = true;
                }
            } else if(e.getSource() == siguiente) {
                if(tocando == true){
                    enReproduccion.stop();
                    if(a == 7)
                        a = 0;
                    else
                        a = a + 1;
                    ventana.setTitle(canciones.get(a));
                    imagenF.setIcon(new ImageIcon(images + "Boston1.jpg"));
                    plause.setIcon(new ImageIcon(images + "plause2.png"));
                    enReproduccion = Applet.newAudioClip(Reproductor.class.
                            getResource(canciones.get(a) + ".wav"));
                    enReproduccion.play();
                    tocando = true;
                } else {
                    if(a == 7)
                        a = 0;
                    else
                        a = a + 1;
                    ventana.setTitle(canciones.get(a));
                    imagenF.setIcon(new ImageIcon(images + "Boston1.jpg"));
                    plause.setIcon(new ImageIcon(images + "plause2.png"));
                    enReproduccion = Applet.newAudioClip(Reproductor.class.
                            getResource(canciones.get(a) + ".wav"));
                    enReproduccion.play();
                    tocando = true;
                }
            } else if(e.getSource() == plause) {
                if(tocando == true) {
                    enReproduccion.stop();
                    ventana.setTitle("Reproductor de música");
                    imagenF.setIcon(new ImageIcon(images + "Boston.jpg"));
                    plause.setIcon(new ImageIcon(images + "plause1.png"));
                    tocando = false;
                } else {
                    ventana.setTitle(canciones.get(a));
                    imagenF.setIcon(new ImageIcon(images + "Boston1.jpg"));
                    plause.setIcon(new ImageIcon(images + "plause2.png"));
                    enReproduccion = Applet.newAudioClip(Reproductor.class.
                            getResource(canciones.get(a) + ".wav"));
                    enReproduccion.play();
                    tocando = true;
                }
            }
        }
    }
}
