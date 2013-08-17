/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetwork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Van
 */
public class ValidateData {

    public ValidateData() {
    }

    static boolean validateUserName(String userName) {
        Pattern pattern = Pattern.compile("^\\w{5,}$");
        Matcher matcher = pattern.matcher(userName);
        return  matcher.find();
    }
    
    static boolean validatePassword(char[] pwd){
        if(pwd.length>=6){
            return true;
        }
        return false;
    }
    
    static boolean validateName(String name){
        Pattern pattern = Pattern.compile("^.{1,}$");
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }
    static boolean validateEmail(String email){
        Pattern pattern = Pattern.compile("^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\\.([a-zA-Z])+([a-zA-Z])+$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
