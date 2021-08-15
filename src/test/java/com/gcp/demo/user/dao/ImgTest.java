package com.gcp.demo.user.dao;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ImgTest {

    @Test
    void insertUser() throws IOException {
        File file = new File("src/pic/p1.jpg");
        System.out.println("文件的名称为："+file.getName());
        System.out.println("文件的相对路径为："+file.getPath());
        System.out.println("文件的绝对路径为："+file.getAbsolutePath());
        //Image image = ImageIO.read(new FileInputStream("pic/p1.jpg"));
        //System.out.println(image);
        Image image = new ImageIcon("pic/p1.jpg").getImage();
        System.out.println(image);
    }
}