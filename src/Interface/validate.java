/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.regex.Pattern;


/**
 *
 * @author hjp
 */
public class validate {
    public static boolean isWord(String word){
        return Pattern.matches("[a-zA-Z_\\s]+",word);
    }
    public static boolean isPhNumber(String in){ 
       return Pattern.matches("[0-9]+", in);
    }
    public static boolean isItemid(String word){
        return Pattern.matches("[a-z_0-9]+",word);
    }
    public static boolean isEmail(String word){
        return Pattern.matches("[a-zA-Z]+[a-zA-Z_0-9]+@+[a-zA-Z]+\\.+[a-zA-Z]+",word);
    } 
 }