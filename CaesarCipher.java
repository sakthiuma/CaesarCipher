
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caesarcipher;

/**
 *
 * @author Sakthi
 */

import java.util.*;

public class CaesarCipher {

    /**
     * @param args the command line arguments
     */
    static String encrypt(String message,int key)
    {
        StringBuilder cipherText = new StringBuilder();
        char temp = 0;
        int i;
        for(i=0;i<message.length();i++)
        {
            if(Character.isLowerCase(message.charAt(i)))
            {
                temp=(char)(((int)message.charAt(i)+key-97)%26+97);
                
            }
            else if(Character.isUpperCase(message.charAt(i)))
            {
                temp=(char)(((int)message.charAt(i)+key-65)%26+65);
            }
            cipherText.append(temp);
        }
        return cipherText.toString(); 
    }
    
    static String decrypt(String cipherText,int key)
    {
        StringBuilder plainText=new StringBuilder();
        int i;
        char temp = 0;
        for(i=0;i<cipherText.length();i++)
        {
            if(Character.isLowerCase(cipherText.charAt(i)))
            {
                temp=(char)((((int)cipherText.charAt(i)-key)-97)%26+97);
                
            }
            else if(Character.isUpperCase(cipherText.charAt(i)))
            {
                temp=(char)((((int)cipherText.charAt(i)-key)+65)%26+65);
            }
            plainText.append(temp);
        }
        return plainText.toString();
    }
    
    static String cryptanalysis(String message)
    {
        StringBuilder text=new StringBuilder();
        String possible_Text[]={"Hello","Wonderful","cryptography"};
        int key,i;
        char temp = 0;
        for(key=1;key<5;key++)
        {
            for(i=0;i<message.length();i++)
            {
                if(Character.isLowerCase(message.charAt(i)))
                {
                    temp=(char)(((int)message.charAt(i)-key-97)%26+97);
                
                }
                else if(Character.isUpperCase(message.charAt(i)))
                {
                    temp=(char)(((int)message.charAt(i)-key+65)%26+65);
                }
                text.append(temp);
            }
            System.out.println(text);
            for(i=0;i<3;i++)
            {
                if((text.toString()).equals(possible_Text[i]))
                {
                    return text.toString();
                }
            }
            text.delete(0,text.length());
        }
        return "no string found";
                
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int key = 0,choice;
        String message = null,encrypted_message,decrypted_message;
        Scanner s=new Scanner(System.in);
        
        System.out.println("Enter 1.Encryption and Decryption 2.Cryptanalysis");
        choice=s.nextInt();
        switch(choice)
        {
            case 1:
                System.out.println("Enter the message to be crypted in caesar cipher");
                message=s.next();
                System.out.println("Enter the key or displacement");
                key=s.nextInt();
                encrypted_message=encrypt(message,key);
                System.out.println("Encrypted Message"+encrypted_message);
                decrypted_message=decrypt(encrypted_message,key);
                System.out.println("Decrypted message"+decrypted_message);
                break;
            case 2:
                System.out.println("Enter the message to de decrypted in caesar cipher");
                message=s.next();
                decrypted_message=cryptanalysis(message);
                System.out.println("Found string"+decrypted_message);
                //Khoor-Hello
                //Yqpfgthwn-Wonderful
        }
        
    }
}
