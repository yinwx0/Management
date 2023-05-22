package frame;

import chrriis.dj.nativeswing.swtimpl.NativeComponent;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserAdapter;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Zhai Jinpei
 */
public class MainView extends JFrame{
    @Serial
    private static final long serialVersionUID = 1L;
    final static StringBuffer jsDimension;

    static{
        jsDimension = new StringBuffer();
        jsDimension.append("var width = 0;");
        jsDimension.append("var height = 0;");
        jsDimension.append("if(document.body.scrollWidth) {");
        jsDimension.append("  width = Math.max(width, document.body.scrollWidth);");
        jsDimension.append("  height = Math.max(height, document.body.scrollHeight);");
        jsDimension.append("}");
        jsDimension.append("return width + ':' + height;");
    }

    public MainView(String htmlFileName,String pngFileName) throws IOException{
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024,768);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JWebBrowser webbrowser = new JWebBrowser();
        webbrowser.setBounds(0,0,1024,768);
        String html = Files.readString(Paths.get(htmlFileName));
        webbrowser.setHTMLContent(html);
        webbrowser.navigate("https://blog.csdn.net/redlevin");
        webbrowser.setButtonBarVisible(false);
        webbrowser.setMenuBarVisible(false);
        webbrowser.setBarsVisible(false);
        webbrowser.setStatusBarVisible(false);
        webbrowser.addWebBrowserListener(new WebBrowserAdapter(){
            public void loadingProgressChanged(WebBrowserEvent e){
                JWebBrowser b = e.getWebBrowser();
                if(b.getLoadingProgress() == 100){
                    String result = (String)b.executeJavascriptWithResult(jsDimension.toString());
                    String[] resultWidthHeight = result.split(":");
                    NativeComponent nativeComponent = b.getNativeComponent();
                    Dimension imageSize = new Dimension(Integer.parseInt(resultWidthHeight[0]),
                            Integer.parseInt(resultWidthHeight[1]));
                    nativeComponent.setSize(imageSize);
                    BufferedImage image = new BufferedImage(imageSize.width,imageSize.height,
                            BufferedImage.TYPE_INT_RGB);
                    nativeComponent.paintComponent(image);
                    try{
                        ImageIO.write(image,"png",new File(pngFileName));
                    }catch(IOException ex){
                        ex.printStackTrace();
                    }
                    System.exit(0);
                }
            }
        });
        contentPane.add(webbrowser);
    }

    public static void main(String[] args){
        if(args.length >= 2){
            NativeInterface.open();
            SwingUtilities.invokeLater(()->{
                try{
                    MainView frame = new MainView(args[0],args[1]);
                    frame.invalidate();
                    frame.pack();
                    frame.setVisible(false);
                }catch(Exception e){
                    e.printStackTrace();
                }
            });
            NativeInterface.runEventPump();
        }
    }
}
