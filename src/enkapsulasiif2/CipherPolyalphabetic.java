/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enkapsulasiif2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author bandi
 */
public class CipherPolyalphabetic {
    
    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final ArrayList<String> kunci;
    
    /**
    * Construct CipherPolyalphabetic
    */
    CipherPolyalphabetic(ArrayList<String> listKey){
        this.kunci = listKey;
    }
    
    public String encrypt(String plainText){
        for(String key: this.kunci){
            // menghapus spasi dan menghilangkan redudansi karakter
            StringBuilder finalKey = new StringBuilder();
            key.toUpperCase().replaceAll("\\s","").chars().distinct().forEach(c -> finalKey.append((char) c));

            // membuat tabel kunci
            String keyTable = finalKey+this.alphabet;
            StringBuilder tableFinal = new StringBuilder();
            keyTable.toUpperCase().chars().distinct().forEach(c -> tableFinal.append((char) c));

            String cipherText = "";
            for(int i=0; i < plainText.length();i++) 
            {
                char ch = plainText.toUpperCase().charAt(i);

                if(ch >= 'A' && ch <= 'z')
                    cipherText += tableFinal.charAt(this.alphabet.indexOf(ch));
                else cipherText += " ";
            }
            
            plainText = cipherText;
        }
        
        return plainText;
    }
   
    public String decrypt(String cipherText){
        Collections.reverse(this.kunci);
        for(String key: this.kunci){
            // menghapus spasi dan menghilangkan redudansi karakter
            StringBuilder finalKey = new StringBuilder();
            key.toUpperCase().replaceAll("\\s","").chars().distinct().forEach(c -> finalKey.append((char) c));

            // membuat tabel kunci
            String keyTable = finalKey+this.alphabet;
            StringBuilder tableFinal = new StringBuilder();
            keyTable.toUpperCase().chars().distinct().forEach(c -> tableFinal.append((char) c));
            

            String plainText = "";
            for(int i=0; i < cipherText.length();i++) 
            {
                char ch = cipherText.toUpperCase().charAt(i);

                if(ch >= 'A' && ch <= 'z')
                    plainText += this.alphabet.charAt(tableFinal.indexOf(String.valueOf(ch)));
                else plainText += " ";
            }
            
            cipherText = plainText;
        }
        
        return cipherText;
    }
    
}
