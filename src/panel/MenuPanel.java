package panel;

import javax.swing.*;

/**
 * @author Zhai Jinpei
 */
public class MenuPanel extends JPanel{
    JFileChooser jFileChooser = new JFileChooser();
    public MenuPanel(){
        setSize(600,600);
        setLayout(null);
        setBorder(BorderFactory.createRaisedBevelBorder());
        jFileChooser.setBounds(10,10,500,520);
        add(jFileChooser);
        jFileChooser.setVisible(true);
    }
}
