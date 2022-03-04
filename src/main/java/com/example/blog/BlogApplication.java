package com.example.blog;

import com.gcp.basicproject.util.ToolsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

/**
 * @author Admin
 */
@ComponentScan(basePackages = {"com.gcp.*","com.example.*"})
@SpringBootApplication
public class BlogApplication {
    private static final Logger log = LoggerFactory.getLogger(BlogApplication.class);
    public static void main(String[] args) {
        Environment env = SpringApplication.run(BlogApplication.class, args).getEnvironment();
        String path = "/doc.html";
        log.info("\n----------------------------------------------------------\n\tApplication is running! Access URLs:\n\tLocal: \t\thttp://localhost:{}" + path + "\n\tExternal: \thttp://{}:{}" + path + "\n----------------------------------------------------------",
                env.getProperty("server.port"),
                ToolsUtil.getServerIp(),
                env.getProperty("server.port"));
    }

}
