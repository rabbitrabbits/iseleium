package com.hogwarts.webui;

import java.io.*;
import java.util.Properties;

/**
 * @author cgx
 * @version 1.0
 * @Description
 * @date 2022/6/10 15:07
 */
public class Test {
    @org.junit.jupiter.api.Test
    void testBrower(){
        System.out.println(System.getenv("currentBrowser"));
    }

    @org.junit.jupiter.api.Test
    void testResource(){
        String propFileName = "iselenium.properties";
        Properties prop = loadFromEnvProperties(propFileName);
        System.out.println(prop.getProperty("CHROME_PATH"));
    }

    //加载配置文件
    private Properties loadFromEnvProperties(String propFileName) {
        Properties prop = null;

        String path = System.getProperty("user.home");
//        String path = this.getClass().getClassLoader().getResource("").getPath();

        //读入envProperties属性文件
        try {
            prop = new Properties();
            InputStream in = new BufferedInputStream(
                    new FileInputStream(path + File.separator + propFileName));
            prop.load(in);
            in.close();
        } catch (IOException ioex) {
            /*logger.error(ioex.getMessage());
            logger.error("Load config file fail, please check " + path + " to confirm if the "
                    + propFileName + " file exist!");*/
        }

        return prop;
    }
}
