package panel;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author Zhai Jinpei
 */
@EqualsAndHashCode(callSuper=true)
@Data
public class MenuPanel extends JPanel{
    JFileChooser jFileChooser = new JFileChooser();

    public MenuPanel(){
        setSize(600,600);
        setLayout(null);
        setBorder(BorderFactory.createRaisedBevelBorder());
        jFileChooser.setBounds(10,10,500,520);
        add(jFileChooser);
        jFileChooser.setVisible(true);
        jFileChooser.addActionListener(e->{
            File file = new File(jFileChooser.getSelectedFile().getAbsolutePath());
            if(!Desktop.isDesktopSupported()){
                System.out.println("Desktop is not supported");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            if(file.exists()){
                try{
                    desktop.open(file);
                }catch(IOException ex){
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
