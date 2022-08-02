package com.example.demo.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


@RestController
public class Controller {

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }
    @PostMapping(value="/image", produces = {MediaType.IMAGE_JPEG_VALUE})
    public @ResponseBody byte[] uploadImage(@RequestBody byte[] imgByte) throws IOException {
        ByteArrayInputStream inpByte = new ByteArrayInputStream(imgByte);
        BufferedImage bufferImg = ImageIO.read(inpByte);
        ColorSpace setColor = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        ColorConvertOp conColor = new ColorConvertOp(setColor, null);
        BufferedImage newBufferedImg = conColor.filter(bufferImg, null);
        ByteArrayOutputStream temp = new ByteArrayOutputStream();
        ImageIO.write(newBufferedImg, "jpg", temp);
        byte[] result = temp.toByteArray();
        return result;
    }
}
