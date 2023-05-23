package frame;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatDraculaContrastIJTheme;

import javax.swing.*;
import java.awt.*;

/**
 * @author Zhai Jinpei
 */
public class VectorFrame extends JFrame{
    public int[] x = new int[3];
    public int[] y = new int[3];
    JPanel jPanel = new JPanel(){
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.fillPolygon(x,y,3);
        }
    };

    public VectorFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(0,0,1543,867);
        setVisible(true);
        setContentPane(jPanel);
        jPanel.setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(new FlatDraculaContrastIJTheme());
        SwingUtilities.invokeLater(VectorFrame::new);
    }
}           
