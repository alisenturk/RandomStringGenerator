/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altar;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

/**
 *
 * @author asenturk
 */
public class FXMLStringGeneratorController implements Initializable {
    
    @FXML
    private TextField couponCode;
    @FXML
    private TextField couponCount;
    @FXML
    private TextField fileExportPath;
    @FXML
    private TextField codeLen;
    @FXML
    private Label txtResult;
    @FXML
    private ProgressBar progressbar;
    
    private Set<String> codeList = new HashSet<String>();
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try{
            StringGenerator sg = new StringGenerator();
            sg.setCodeLen(Integer.valueOf(codeLen.getText()));
            sg.setGroupCode(couponCode.getText());
            int count = Integer.valueOf(couponCount.getText());
            String code = "";
            
            for(int i=0;i<count;i++){
              code = sg.generateCode();
                
              if(codeList.contains(code))i--;
              else{
                codeList.add(code);              
                progressbar.setProgress((i+1)/count);
              }
            }

            File dir = new File(fileExportPath.getText());
            if(!dir.exists())dir.mkdirs();
            String fileName = fileExportPath.getText() + couponCode.getText() +"_"+Util.getTodayDate("yyyymmddhhmi") +".csv";
            FileWriter fw = new FileWriter(fileName);
            
            int codeCout = codeList.size();
            for(String strCode:codeList){
                fw.write(strCode + "\n");
            }
            fw.flush();;
            fw.close();
            txtResult.setText(codeCout + " adet kod " + fileName + " isimli dosya kayıt edildi!");
        }catch(Exception e){
            txtResult.setText("HATA : " + e.getMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
