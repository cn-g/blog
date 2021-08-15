package com.gcp.demo.common;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Randomnumber {

    //生成十位随机数字
    public static StringBuilder getrandom(){
        String code = "0123456789";
        StringBuilder number = new StringBuilder();//创建StringBuilder对象
        Random random = new Random();
        for(int i = 0;i < 10;i++){
            //charAt()用于返回指定索引处的字符, 索引的范围是0~length()-1
            //随机索引code中的值，将其拼接到number中
            number.append(code.charAt(random.nextInt(10)));
        }
        return number;
    }
}
