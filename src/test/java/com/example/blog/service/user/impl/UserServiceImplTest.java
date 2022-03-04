package com.example.blog.service.user.impl;

import com.example.blog.BlogApplicationTests;
import com.example.blog.dto.user.request.AddAccountReqDto;
import com.example.blog.service.user.AccountService;
import com.example.blog.service.user.UserService;
import org.junit.Test;

import javax.annotation.Resource;

public class UserServiceImplTest extends BlogApplicationTests {

    @Resource
    private UserService userService;

    @Resource
    private AccountService accountService;

    @Test
    public void addUser() {

        for (int i = 0; i < 50; i++) {
            AddAccountReqDto reqDto = new AddAccountReqDto();
//            reqDto.setBirthday(LocalDate.now().minusDays(i));
//            reqDto.setName("测试"+i);
//            reqDto.setAreaName("测试地址"+i);
//            reqDto.setRealName("测试用户"+i);
//            reqDto.setSex(0);
//            reqDto.setAreaCode(0);
//            reqDto.setCityCode(0);
//            reqDto.setProvinceCode(0);
//            reqDto.setSynopsis("测试备注"+i);
//            reqDto.setPicUrl("www.baidu.com");
            reqDto.setAccount("测试" + i);
            reqDto.setPassword("123456");
            reqDto.setQqNumber("2020230" + i);
            reqDto.setWeChat("gcp" + i);
            reqDto.setPhone("152162" + i);
            reqDto.setRoleId("12315646");
            accountService.addAccount(reqDto);
//        }
        }
    }

}