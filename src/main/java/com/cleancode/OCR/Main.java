package com.cleancode.OCR;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String pathname = "src/main/java/com/cleancode/OCR/input.txt";
        try {
            File myObj = new File(pathname);
            char[][] myArray= new char[4][29];
           /* Scanner myReader = new Scanner(myObj);
            int i=0;
            while (myReader.hasNext()) {
                String data = myReader.next();
                System.out.print(data);
                i++;
                if(i == 27){
                    System.out.println(" ");
                    i=0;
                }
            }
            myReader.close();*/

            FileReader fr = new FileReader(myObj);
            BufferedReader br=new BufferedReader(fr);  //Creation of BufferedReader object
            int c = 0;
            int i = 0;
            int j = 0;
            while((c = br.read()) != -1)
            {
                char character = (char) c;
                myArray[j][i] = (char) c;
                System.out.print(character);
                i++;
                if(i == 29){
                    i=0;
                    j+=1;
                }
            }
            System.out.println("fini");

            
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    public int guessNumber(char[][] c, int ligne, int colonne){
        return 1;
    }
}
/*
  0 < 1er nombre < 3
  4 < 2e nombre < 6
  7 < 3e nombre < 9
  10 < 4e nombre < 12
  13 < 5e nombre < 15
  16 < 6e nombre < 18
  19 < 7e nombre < 21
  22 < 8e nombre < 24
  25 < 9e nombre < 27
*/
