/*
    Создайте программу, которая осуществляет шифрование / расшифровку методом простой замены.
    В нем каждый символ незашифрованного текста из исходного алфавита
    заменяется другим из алфавита, символы в каком представлены в соответствии с ключом шифрования.
*/

import java.util.Random;

public class Task13 {

    public static void main(String[] args) {

        String text = "Hello, world!",
                encryptedText,
                decryptedText;
        Random random = new Random();
        int key = random.nextInt(1,10);

        System.out.println("TASK 13");
        System.out.println("Encryption key: " + key);
        encryptedText = encrypt(text, key);
        System.out.println("Encrypted text: " + encryptedText);
        decryptedText = decrypt(encryptedText, key);
        System.out.println("Decrypted text: " + decryptedText);
    }
    public static String encrypt(String text, int key)
    {
        StringBuffer encryptedText = new StringBuffer(text);
        char newChar, curChar;

        for(int i = 0; i < text.length(); i++)
        {
            curChar = encryptedText.charAt(i);
            if(!Character.isLetter(curChar))
                continue;
            if(Character.isUpperCase(curChar))
                newChar = (char) ((curChar + key - 'A') % 26  + 'A');
            else
                newChar = (char) ((curChar + key - 'a') % 26 + 'a');
            encryptedText.setCharAt(i, newChar);
        }
        return encryptedText.toString();
    }
    public static String decrypt(String text, int key)
    {
        key = 26 - key;
        return encrypt(text, key);
    }
}
