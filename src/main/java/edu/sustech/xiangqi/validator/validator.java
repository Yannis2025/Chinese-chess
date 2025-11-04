package edu.sustech.xiangqi.validator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class validator {
    public static boolean validate(String username, String password, File userFile){
        try(BufferedReader reader=new BufferedReader(new FileReader(userFile))){
            String line;
            //逐一比对输入信息与txt中的用户名与密码是否匹配,直到最后一行
            while ((line=reader.readLine())!=null){
                if (line.equals(username+","+password))
                    //要求txt文件中的用户信息每行都以"username,password"格式储存
                    return true;
            }
        }catch (IOException e){
            return false;
        }
        return false;//没一行匹配就return false
    }
}
