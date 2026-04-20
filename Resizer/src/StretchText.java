import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;

public class StretchText {

    public static void main(String[] args) throws Exception {
        // used to stretch the graphics instance sideways
        AffineTransform stretch = new AffineTransform();
        AffineTransform shrink = new AffineTransform();

        int w = 640; // image width
        int h = 200; // image height
        int f = 21; // Font size in px
        String s = "The quick brown fox jumps over the lazy dog.";

        final BufferedImage bi = new BufferedImage(
                w,h,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        g.setFont(new Font("Serif",Font.PLAIN,f));
        g.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING, 
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // paint BG
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, w, h);
        g.setColor(Color.BLACK);

        for (int i=0; (i*f)+f<=h; i++) {
            g.drawString(s, 0, (i*f)+f);
            // stretch
            stretch.concatenate(
                    AffineTransform.getScaleInstance(1.18, 1d));
            g.setTransform(stretch);
            
            shrink.concatenate(
                    AffineTransform.getScaleInstance(1.18, 1d));
            g.setTransform(shrink);

            // fade
            Color c = g.getColor();
            g.setColor(new Color (
                    c.getRed(),
                    c.getGreen(),
                    c.getBlue(),
                    (int)(c.getAlpha()*.75)));
            
            
        }

        g.dispose();

        ImageIO.write(bi, "png", new File(
                new File(System.getProperty("user.home")), 
                "StretchText.png"));
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JLabel gui = new JLabel(new ImageIcon(bi));
                JOptionPane.showMessageDialog(null, gui);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}