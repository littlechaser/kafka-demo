package com.allen.test;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * @author yang_tao@<yangtao.letzgo.com.cn>
 * @version 1.0
 * @date 2018-04-17 17:58
 */
public class ResourceUtil {

    public static Properties loadProperties(String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            throw new IllegalArgumentException("文件名称不能为空");
        }
        String fullName = fileName;
        if (!fileName.endsWith(".properties")) {
            fullName = fileName.concat(".properties");
        }
        ClassLoader classLoader = ResourceUtil.class.getClassLoader();
        ClassPathResource resource = new ClassPathResource(fullName, classLoader);
        Properties prop = new Properties();
        try {
            prop.load(resource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

}
