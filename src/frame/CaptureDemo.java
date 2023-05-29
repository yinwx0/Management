package frame;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubContrastIJTheme;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class CaptureDemo{
    private static int num = 0;

    public static void main(String[] args) throws IOException, UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(new FlatGitHubContrastIJTheme());
        final Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setFPSDisplayed(true);
        panel.setDisplayDebugInfo(true);
        panel.setImageSizeDisplayed(true);
        panel.setMirrored(true);
        final JFrame window = new JFrame("摄像头");
        window.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e)//关闭时的操作，windowClosed是关闭后的操作
            {
                webcam.close();
                window.dispose();
            }
        });
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//使用 System exit 方法退出应用程序
        final JButton button = new JButton("截图");
        window.add(panel,BorderLayout.CENTER);
        window.add(button,BorderLayout.SOUTH);
        window.setResizable(true);
        window.pack();
        window.setVisible(true);
        button.addActionListener(e->{
            button.setEnabled(false);
            String fileName = "D://" + num;
            WebcamUtils.capture(webcam,fileName,ImageUtils.FORMAT_PNG);
            SwingUtilities.invokeLater(()->{
                JOptionPane.showMessageDialog(null,"截图成功");
                button.setEnabled(true);
                num++;
            });
        });
    }
}
