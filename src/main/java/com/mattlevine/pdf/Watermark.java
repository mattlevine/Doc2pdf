package com.mattlevine.pdf;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Watermark  
{

    public void create(String outputFilePath, String text, int width, int height) {

        try {
            // Step 1: Create a BufferedImage with transparency
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            
            // Step 2: Get the Graphics2D object to draw on the image
            Graphics2D g2d = image.createGraphics();
            
            // Step 3: Set the background color to transparent (alpha = 0)
            g2d.setColor(new Color(0, 0, 0, 0));
            g2d.fillRect(0, 0, width, height);
            
            // Step 4: Set the font and color for the text
            Font font = new Font("Arial", Font.BOLD, 24);
            g2d.setFont(font);
            g2d.setColor(Color.BLACK);
            
            // Step 5: Calculate the position to center the text on the image
            FontMetrics fontMetrics = g2d.getFontMetrics();
            int textWidth = fontMetrics.stringWidth(text);
            int textHeight = fontMetrics.getHeight();
            int x = (width - textWidth) / 2;
            int y = (height - textHeight) / 2 + fontMetrics.getAscent();
            
            // Step 6: Draw the text on the image
            g2d.drawString(text, x, y);
            
            // Step 7: Dispose of the Graphics2D object
            g2d.dispose();
            
            // Step 8: Save the image to the specified file
            File outputImageFile = new File(outputFilePath);
            ImageIO.write(image, "png", outputImageFile);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
