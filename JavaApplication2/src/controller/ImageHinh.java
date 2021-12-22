/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;

/**
 *
 * @author Admin
 */
public class ImageHinh {
    public static Image resize(Image originalImage, int targetWidth, int targetHight){ 
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHight, Image.SCALE_SMOOTH); 
        return  resultingImage ;
    } 
     
 public static byte[] toByteArray(Image img , String type) throws IOException{ 
     BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB); 
     Graphics2D g = bimage.createGraphics(); 
     g.drawImage(img, 0, 0, null); 
     g.dispose(); 
      
     ByteArrayOutputStream baos =new ByteArrayOutputStream(); 
     ImageIO.write(bimage, type, baos); 
     byte[] imageInByte = baos.toByteArray(); 
      
     return imageInByte;
 }  
  
 public static Image createImageFromByteArray(byte[] data, String type) throws IOException{ 
     ByteArrayInputStream bis =new ByteArrayInputStream(data); 
     BufferedImage bImage2 = ImageIO.read(bis); 
      
     Image img = bImage2.getScaledInstance(bImage2.getWidth(), bImage2.getHeight(), Image.SCALE_SMOOTH); 
     return img ;
 }
}
