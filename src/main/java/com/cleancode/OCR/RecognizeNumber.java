package com.cleancode.OCR;

import java.util.ArrayList;
import java.util.List;

public class RecognizeNumber {
    public List<Integer> resultArray;
    
    public RecognizeNumber(){
        this.resultArray = new ArrayList<>();
    }
    
    public void recognizeNumberFromArray(char[][] myArray){
        for(int i = 0;i<myArray.length;i++){
            for(int j=0;j<myArray[0].length;j++){
                if(i==0 || i%4 == 0) {
                    if (j == 27) {
                        continue;
                    }
                    if (j == 0 || j % 3 == 0) {
                        resultArray.add(guessNumber(myArray, i, j));
                    }
                }
            }
        }
    }

    public int guessNumber(char[][] c, int ligne, int colonne){
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

    public boolean isOne(char[][] c, int ligne, int colonne){
        if(ligne+2 >= c.length || colonne+2 >= c[0].length){
            return false;
        }
        if(c[ligne][colonne] == ' ' && c[ligne][colonne+1] == ' ' &&  c[ligne][colonne+2] == ' '
                && c[ligne+1][colonne] == ' ' && c[ligne+1][colonne+1] == ' ' && c[ligne+1][colonne+2] == '|'
                && c[ligne+2][colonne] == ' ' && c[ligne+2][colonne+1] == ' ' && c[ligne+2][colonne+2] == '|'){
            return true;
        }
        return false;
    }

    public boolean isTwo(char[][] c, int ligne, int colonne){
        if(ligne+2 >= c.length || colonne+2 >= c[0].length){
            return false;
        }
        if(c[ligne][colonne] == ' ' && c[ligne][colonne+1] == '_' && c[ligne][colonne+2] == ' '
                && c[ligne+1][colonne] == ' ' && c[ligne+1][colonne+1] == '_' && c[ligne+1][colonne+2] == '|'
                && c[ligne+2][colonne] == '|' && c[ligne+2][colonne+1] == '_' && c[ligne+2][colonne+2] == ' '){
            return true;
        }
        return false;
    }

    public boolean isThree(char[][] c, int ligne, int colonne){
        if(ligne+2 >= c.length || colonne+2 >= c[0].length){
            return false;
        }
        if(c[ligne][colonne] == ' ' && c[ligne][colonne+1] == '_' && c[ligne][colonne+2] == ' '
                && c[ligne+1][colonne] == ' ' && c[ligne+1][colonne+1] == '_' && c[ligne+1][colonne+2] == '|'
                && c[ligne+2][colonne] == ' ' && c[ligne+2][colonne+1] == '_' && c[ligne+2][colonne+2] == '|'){
            return true;
        }
        return false;
    }

    public boolean isFour(char[][] c, int ligne, int colonne){
        if(ligne+2 >= c.length || colonne+2 >= c[0].length){
            return false;
        }
        if(c[ligne][colonne] == ' ' && c[ligne][colonne+1] == ' ' && c[ligne][colonne+2] == ' '
                && c[ligne+1][colonne] == '|' && c[ligne+1][colonne+1] == '_' && c[ligne+1][colonne+2] == '|'
                && c[ligne+2][colonne] == ' ' && c[ligne+2][colonne+1] == ' ' && c[ligne+2][colonne+2] == '|'){
            return true;
        }
        return false;
    }

    public boolean isFive(char[][] c, int ligne, int colonne){
        if(ligne+2 >= c.length || colonne+2 >= c[0].length){
            return false;
        }
        if(c[ligne][colonne] == ' ' && c[ligne][colonne+1] == '_' && c[ligne][colonne+2] == ' '
                && c[ligne+1][colonne] == '|' && c[ligne+1][colonne+1] == '_' && c[ligne+1][colonne+2] == ' '
                && c[ligne+2][colonne] == ' ' && c[ligne+2][colonne+1] == '_' && c[ligne+2][colonne+2] == '|'){
            return true;
        }
        return false;
    }

    public boolean isSix(char[][] c, int ligne, int colonne){
        if(ligne+2 >= c.length || colonne+2 >= c[0].length){
            return false;
        }
        if(c[ligne][colonne] == ' ' && c[ligne][colonne+1] == '_' && c[ligne][colonne+2] == ' '
                && c[ligne+1][colonne] == '|' && c[ligne+1][colonne+1] == '_' && c[ligne+1][colonne+2] == ' '
                && c[ligne+2][colonne] == '|' && c[ligne+2][colonne+1] == '_' && c[ligne+2][colonne+2] == '|'){
            return true;
        }
        return false;
    }

    public boolean isSeven(char[][] c, int ligne, int colonne){
        if(ligne+2 >= c.length || colonne+2 >= c[0].length){
            return false;
        }
        if(c[ligne][colonne] == ' ' && c[ligne][colonne+1] == '_' && c[ligne][colonne+2] == ' '
                && c[ligne+1][colonne] == ' ' && c[ligne+1][colonne+1] == ' ' && c[ligne+1][colonne+2] == '|'
                && c[ligne+2][colonne] == ' ' && c[ligne+2][colonne+1] == ' ' && c[ligne+2][colonne+2] == '|'){
            return true;
        }
        return false;
    }

    public boolean isEight(char[][] c, int ligne, int colonne){
        if(ligne+2 >= c.length || colonne+2 >= c[0].length){
            return false;
        }
        if(c[ligne][colonne] == ' ' && c[ligne][colonne+1] == '_' && c[ligne][colonne+2] == ' '
                && c[ligne+1][colonne] == '|' && c[ligne+1][colonne+1] == '_' && c[ligne+1][colonne+2] == '|'
                && c[ligne+2][colonne] == '|' && c[ligne+2][colonne+1] == '_' && c[ligne+2][colonne+2] == '|'){
            return true;
        }
        return false;
    }

    public boolean isNine(char[][] c, int ligne, int colonne){
        if(ligne+2 >= c.length || colonne+2 >= c[0].length){
            return false;
        }
        if(c[ligne][colonne] == ' ' && c[ligne][colonne+1] == '_' && c[ligne][colonne+2] == ' '
                && c[ligne+1][colonne] == '|' && c[ligne+1][colonne+1] == '_' && c[ligne+1][colonne+2] == '|'
                && c[ligne+2][colonne] == ' ' && c[ligne+2][colonne+1] == '_' && c[ligne+2][colonne+2] == '|'){
            return true;
        }
        return false;
    }

    public boolean isZero(char[][] c, int ligne, int colonne){
        if(ligne+2 >= c.length || colonne+2 >= c[0].length){
            return false;
        }
        if(c[ligne][colonne] == ' ' && c[ligne][colonne+1] == '_' && c[ligne][colonne+2] == ' '
                && c[ligne+1][colonne] == '|' && c[ligne+1][colonne+1] == ' ' && c[ligne+1][colonne+2] == '|'
                && c[ligne+2][colonne] == '|' && c[ligne+2][colonne+1] == '_' && c[ligne+2][colonne+2] == '|'){
            return true;
        }
        return false;
    }
}
