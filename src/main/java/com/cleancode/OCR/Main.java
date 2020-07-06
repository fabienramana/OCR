package com.cleancode.OCR;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Main { //Mettre variable en francais ou en anglais

    public static void main(String[] args) {
        String pathname = "src/main/java/com/cleancode/OCR/input.txt";
        try {
            File myObj = new File(pathname);
            int lignSize = (int) (myObj.length()/27);
            char[][] myArray= new char[lignSize][29];
            int[] resultArray = new int[9];
            for(int k=0;k<9;k++){
                resultArray[k] = -1;
            }

            FileReader fr = new FileReader(myObj);
            BufferedReader br=new BufferedReader(fr);

            // MISE EN FORME DU TABLEAU
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
            int result = 9;
            for(i = 0;i<lignSize;i++){
                for(j=0;j<29;j++){
                    if(i==0 || i%4 == 0) {
                        if (j == 27) {
                            continue;
                        }
                        if (j == 0 || j % 3 == 0) {
                            System.out.println(guessNumber(myArray, i, j));
                        }
                    }
                }
            }
            
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public static int guessNumber(char[][] c, int ligne, int colonne){
        if(isEight(c,ligne,colonne)){
            return 8;
        }
        if(isNine(c,ligne,colonne)){
            return 9;
        }
        if(isThree(c,ligne,colonne)){
            return 3;
        }
        if(isZero(c,ligne,colonne)){
            return 0;
        }
        if(isSeven(c,ligne,colonne)){
            return 7;
        }
        if(isSix(c,ligne,colonne)){
            return 6;
        }
        if(isFive(c,ligne,colonne)){
            return 5;
        }
        if(isFour(c,ligne,colonne)){
            return 4;
        }
        if(isTwo(c,ligne,colonne)){
            return 2;
        }
        if(isOne(c,ligne,colonne)){                     //switch ?
            return 1;
        }

        return -1;
    }

    public static boolean isOne(char[][] c, int ligne, int colonne){
        if(ligne+2 >= c.length || colonne+2 >= c[0].length){
            return false;
        }
        if(c[ligne+1][colonne+2] == '|' && c[ligne+2][colonne+2] == '|'){
            return true;
        }
        return false;
    }

    public static boolean isTwo(char[][] c, int ligne, int colonne){
        if(ligne+1 >= c.length || ligne+2 >= c.length || colonne+1 >= c[0].length){
            return false;
        }
        if(c[ligne][colonne+1] == '_' && c[ligne+1][colonne+2] == '|'
                && c[ligne+1][colonne+1] == '_' && c[ligne+2][colonne] == '|' && c[ligne+2][colonne+1] == '_'){
            return true;
        }
        return false;
    }

    public static boolean isThree(char[][] c, int ligne, int colonne){
        if(ligne+1 >= c.length || ligne+2 >= c.length || colonne+1 >= c[0].length){
            return false;
        }
        if(c[ligne][colonne+1] == '_' && c[ligne+1][colonne+2] == '|'
                && c[ligne+1][colonne+1] == '_' && c[ligne+2][colonne+2] == '|' && c[ligne+2][colonne+1] == '_'){
            return true;
        }
        return false;
    }

    public static boolean isFour(char[][] c, int ligne, int colonne){
        if(ligne+1 >= c.length || colonne+2 >= c[0].length || colonne+1 >= c[0].length){
            return false;
        }
        if(c[ligne+1][colonne] == '|' && c[ligne+1][colonne+1] == '_'
                && c[ligne+1][colonne+2] == '|' && c[ligne+2][colonne+2] == '|'){
            return true;
        }
        return false;
    }

    public static boolean isFive(char[][] c, int ligne, int colonne){
        if(ligne+1 >= c.length || ligne+2 >= c.length || colonne+1 >= c[0].length){
            return false;
        }
        if(c[ligne][colonne+1] == '_' && c[ligne+1][colonne] == '|'
                && c[ligne+1][colonne+1] == '_' && c[ligne+2][colonne+2] == '|' && c[ligne+2][colonne+1] == '_'){
            return true;
        }
        return false;
    }

    public static boolean isSix(char[][] c, int ligne, int colonne){
        if(ligne+1 >= c.length || ligne+2 >= c.length || colonne+1 >= c[0].length){
            return false;
        }
        if(c[ligne][colonne+1] == '_' && c[ligne+1][colonne] == '|'
                && c[ligne+1][colonne+1] == '_' && c[ligne+2][colonne] == '|' && c[ligne+2][colonne+1] == '_' && c[ligne+2][colonne+2] == '|'){
            return true;
        }
        return false;
    }

    public static boolean isSeven(char[][] c, int ligne, int colonne){
        if(ligne+1 >= c.length || ligne+2 >= c.length || colonne+1 >= c[0].length){
            return false;
        }
        if(c[ligne][colonne+1] == '_' && c[ligne+1][colonne+2] == '|'
                && c[ligne+2][colonne+2] == '|'){
            return true;
        }
        return false;
    }

    public static boolean isEight(char[][] c, int ligne, int colonne){
        if(ligne+1 >= c.length || ligne+2 >= c.length || colonne+1 >= c[0].length){
            return false;
        }
        if(c[ligne][colonne+1] == '_' && c[ligne+1][colonne] == '|'
                && c[ligne+1][colonne+1] == '_' && c[ligne+1][colonne+2] == '|'
                && c[ligne+2][colonne] == '|' && c[ligne+2][colonne+1] == '_' && c[ligne+2][colonne+2] == '|'){
            return true;
        }
        return false;
    }

    public static boolean isNine(char[][] c, int ligne, int colonne){
        if(ligne+1 >= c.length || ligne+2 >= c.length || colonne+1 >= c[0].length){
            return false;
        }
        if(c[ligne][colonne+1] == '_' && c[ligne+1][colonne] == '|'
                && c[ligne+1][colonne+1] == '_' && c[ligne+1][colonne+2] == '|'
                && c[ligne+2][colonne+1] == '_' && c[ligne+2][colonne+2] == '|'){
            return true;
        }
        return false;
    }

    public static boolean isZero(char[][] c, int ligne, int colonne){
        if(ligne+1 >= c.length || ligne+2 >= c.length || colonne+1 >= c[0].length){
            return false;
        }
        if(c[ligne][colonne+1] == '_' && c[ligne+1][colonne] == '|'
                && c[ligne+1][colonne+2] == '|' && c[ligne+2][colonne+1] == '|' ){
            return true;
        }
        return false;
    }

    public static int getPlaceInArray(int colonne){
        if(colonne >=0 && colonne <=3){
            return 0;
        }
        if(colonne >=4 && colonne <=6){
            return 1;
        }
        if(colonne >=7 && colonne <=9){
            return 2;
        }
        if(colonne >=10 && colonne <=12){
            return 3;
        }
        if(colonne >=13 && colonne <=15){
            return 4;
        }
        if(colonne >=16 && colonne <=18){
            return 5;
        }
        if(colonne >=19 && colonne <=21){
            return 6;
        }
        if(colonne >=22 && colonne <=23){
            return 7;
        }
        if(colonne >=24 && colonne <=27){
            return 8;
        }
        return -1;
    }

    public static boolean checkIfArrayPlaceIsEmpty(int[] resultArray,int colonne){
        int placeToCheck = getPlaceInArray(colonne);
        if(placeToCheck > 0){
            if(resultArray[placeToCheck] == -1){
                return true;
            }
        }
        return false;
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
