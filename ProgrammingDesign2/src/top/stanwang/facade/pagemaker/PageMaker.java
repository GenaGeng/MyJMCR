package top.stanwang.facade.pagemaker;

import javax.xml.crypto.Data;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PageMaker {
    private PageMaker(){

    }
    public static void makeWelcomePage(String mailaddr,String fileName){
        try {
            Properties mailprop = Database.getProperties("maildata");
            String username = mailprop.getProperty(mailaddr);
            HTMLWriter writer= new HTMLWriter(new FileWriter(fileName));
            writer.title("Welcome to "+username + "'s page");
            writer.paragraph(username + " 欢迎来到 " + username + " 的主页");
            writer.paragraph("等着你的邮件哦");
            writer.mailto(mailaddr,username);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeLinkPage(String filename){
        try{
            HTMLWriter writer = new HTMLWriter(new FileWriter(filename));
            writer.title("Link Page");
            Properties mailprop = Database.getProperties("maildata");
            Enumeration en = mailprop.propertyNames();
            while (en.hasMoreElements()){
                String mailaddr = (String)en.nextElement();
                String username = mailprop.getProperty(mailaddr,"");
                writer.mailto(mailaddr,username);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
