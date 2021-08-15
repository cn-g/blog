package com.gcp.demo.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gcp.demo.blog.entity.Blog;
import com.gcp.demo.sort.entity.Sort;
import com.gcp.demo.user.entity.User;
import com.gcp.demo.blog.service.BlogService;
import com.gcp.demo.sort.service.SortService;
import com.gcp.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
@RequestMapping("")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private SortService sortService;

    @RequestMapping({"/tologin",""})
    public String tologin(){
        return "login";
    }

    @RequestMapping("first")
    public String first(Model model){
        return "/blog/first";
    }

    @RequestMapping("slinux")
    public String slinux(Model model){
        Sort sort = sortService.queryBySid(3);
        List<Blog> slinux = blogService.queryOneSort(sort);
        model.addAttribute("slinux",slinux);
        return "/blog/slinux";
    }

    @RequestMapping("sjava")
    public String sjava(Model model){
        Sort sort = sortService.queryBySid(1);
        List<Blog> sjava = blogService.queryOneSort(sort);
        model.addAttribute("sjava",sjava);
        return "/blog/sjava";
    }

    @RequestMapping("sweb")
    public String sweb(Model model){
        Sort sort = sortService.queryBySid(2);
        List<Blog> sweb = blogService.queryOneSort(sort);
        model.addAttribute("sweb",sweb);
        return "/blog/sweb";
    }

    @RequestMapping("/login")
    public String login(String usercode, String password, Model model,HttpSession session){
        User user = userService.findByUname(usercode,password);
        //判断是否用户登录
        if (user!=null&&usercode!=null&&password!=null){
            model.addAttribute("pa", true);
            model.addAttribute("username",user.getUname());
            model.addAttribute("imgurl",user.getUimg());
            model.addAttribute("uid",user.getUid());
            session.setAttribute("uid",user.getUid());
            return "blog/index";
        }
        else if(usercode==null){
            model.addAttribute("usermessage","用户账号不能为空");
            return "/login";
        }
        else if(password==null){
            model.addAttribute("pwdmessage","密码不能为空");
            return "/login";
        }
        else{
            model.addAttribute("usermessage","用户账号或密码不正确");
            model.addAttribute("pwdmessage","请认真检查一遍");
            return "redirect:/login";
        }
    }

    @RequestMapping("/toregister")
    public String toregister(){
        return "/register";
    }

    @RequestMapping("/register")
    public String register(User user,Model model){
        String uimg = "../imgfile/p1.jpg";
        String ucode = userService.randomNum();
        user.setUimg(uimg);
        user.setUcode(ucode);
        userService.addUser(user);
        model.addAttribute("user",user);
        System.out.println(user);
        return "/common/registermsg";
    }

    @RequestMapping("/index")
    public String toindex(Model model, HttpSession session){
        return "/blog/index";
    }

    @RequestMapping("/toimg")
    public String myimg(){
        //System.out.println(uimg);
        return "/img";
    }

    @RequestMapping("/img")
    public String myimg(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) throws IOException {

        //获取文件名称
        String fileOrigName = file.getOriginalFilename();
        System.out.println(fileOrigName);
        //设置文件存储路径
        String filepath = "D:/idea/blog/src/main/resources/static/imgfile/"+fileOrigName;
        try{
            File targetFile = new File(filepath);
            if(targetFile.exists()){
                //判断该文件是否存在
                System.out.println("exists!!!");
                return "/img";
            }
            //判断文件目录是否存在
            if(!targetFile.getParentFile().exists()){
                //文件路径不存在就创建路径
                targetFile.getParentFile().mkdirs();
                System.out.println("mkdir file");
            }
            try {
                if (!targetFile.exists()){
                    //再次判断,写入文件
                    targetFile.createNewFile();
                    FileOutputStream outputStream = new FileOutputStream(targetFile);
                    byte[] bytes = file.getBytes();
                    outputStream.write(bytes);
                    outputStream.close();
                }
                else{
                    System.out.println("img is exists!!!");
                }
                System.out.println(filepath);
            }catch (IOException e){
                e.printStackTrace();
            }
            return "/img";
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "/img";
    }

    @RequestMapping("/toedit/{id}")
    public String toedit(@PathVariable("id") int id, Model model,HttpSession session){
        model.addAttribute("uid",id);
        return "/edittext";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id,Blog blog,Model model,HttpSession session){
        User user = userService.findByUid(id);
        model.addAttribute("blog",blog);
        model.addAttribute("user",user);
        session.setAttribute("sblog",blog);
        session.setAttribute("suser",user);
        return "/blog/blogdec";
    }

    @RequestMapping("/publish")
    public String topblog(Sort sort, Model model, HttpSession session){
        Object b = session.getAttribute("sblog");
        Object u = session.getAttribute("suser");
        //将object类型转化为实体类型
        Blog blog = new ObjectMapper().convertValue(b,Blog.class);
        User user = new ObjectMapper().convertValue(u,User.class);
        blogService.addBlog(blog,user,sort);
        model.addAttribute("message","发布成功");
        model.addAttribute("uid",user.getUid());
        return "/common/message";
    }

    @RequestMapping("/toindex/{uid}")
    public String toindex(@PathVariable("uid") int uid, Model model, HttpSession session){
        User user = userService.findByUid(uid);
        model.addAttribute("pa", true);
        model.addAttribute("username",user.getUname());
        model.addAttribute("imgurl",user.getUimg());
        model.addAttribute("uid",user.getUid());
        return "/blog/index";
    }

}
