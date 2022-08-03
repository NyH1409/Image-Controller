package com.example.demo.api;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

public class ImageHandler {
    public static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
    public static BufferedImage changeColor(BufferedImage bufferImg){
        ColorSpace setColor = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        ColorConvertOp conColor = new ColorConvertOp(setColor, null);
        BufferedImage newBufferedImg = conColor.filter(bufferImg, null);
        return  newBufferedImg;
    }
}
