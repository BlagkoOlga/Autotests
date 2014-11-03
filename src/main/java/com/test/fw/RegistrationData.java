package com.test.fw;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by admin on 02.11.14.
 */
public class RegistrationData {
    public String generateRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }

    public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomAlphaNumeric(int length){
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public String generateStringWithAllobedSplChars(int length, String allowdSplChrs){
        String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
                //"1234567890" +   //numbers
                allowdSplChrs;
        return RandomStringUtils.random(length, allowedChars);

    }
    public String generateUserName(int length){
        String allowedChars="abcdefghijklmnopqrstuvwxyz"+  //alphabets
                "1234567890";  //numbers
        //"_-.";   //special characters
        String userName="";
        String temp=RandomStringUtils.random(length,allowedChars);

        userName= "zasx" + temp.substring(temp.length() - 5);
        return userName;
    }

    public String generateEmail(int length) {
        String allowedChars="abcdefghijklmnopqrstuvwxyz"+  //alphabets
                "1234567890";  //numbers
        //"_-.";   //special characters
        String email="";
        String temp=RandomStringUtils.random(length,allowedChars);
        email="zasx"+temp.substring(0,+temp.length()-5)+"@tc.com";
        return email;
    }
}
