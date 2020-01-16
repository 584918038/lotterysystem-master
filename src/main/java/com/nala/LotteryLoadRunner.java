package com.nala;

import com.nala.entity.Constants;
import com.nala.entity.User;
import org.apache.tomcat.util.bcel.Const;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.io.File;
import java.util.ArrayList;

/**
 * @author oyj
 * @date 2020-01-16 14:39
 * @description
 */
public class LotteryLoadRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        File file = new File("src/main/resources/user.xml");
        SAXReader read = new SAXReader();
        Document doc = null;
        try {
            doc = read.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();
        ArrayList<User> list = new ArrayList<>();
        for (Object element : root.elements()) {
            User user = new User();
            Element e = (Element) element;
            user.setUserName(e.element("userName").getTextTrim());
            user.setCarNumber(e.element("carNumber").getTextTrim());
            user.setPhoneNumber(e.element("phoneNumber").getTextTrim());
            Constants.USER_MAP.put(user.getPhoneNumber(),user);
        }
    }
}
