/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altar;

/**
 *
 * @author asenturk
 */
public class StringGenerator {
    private static final String capAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String num = "0123456789";
  
    private String  groupCode   = null;
    private int     codeLen     = 9;

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public int getCodeLen() {
        return codeLen;
    }

    public void setCodeLen(int codeLen) {
        this.codeLen = codeLen;
    }
    
    public String generateCode(){
        String code = "";
        StringBuffer buffer = new StringBuffer();
        String characters = capAlpha + num;
        int charactersLength = characters.length();
        int length = codeLen;
        if(groupCode!=null){
            length = codeLen - groupCode.length();
        }
        for (int i = 0; i < length; i++) {
                double index = Math.random() * charactersLength;
                buffer.append(characters.charAt((int) index));
        }
        
        if(groupCode!=null){
            code = groupCode + buffer.toString();
        }else{
            code = buffer.toString();
        }
        return code;
    }
    
    
}
