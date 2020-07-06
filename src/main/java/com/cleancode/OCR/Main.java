package com.cleancode.OCR;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main { //Mettre variable en francais ou en anglais

    public static void main(String[] args) {
        String pathname = "src/main/java/com/cleancode/OCR/input4.txt";
        try {
            File myObj = new File(pathname);
            int lignSize = (int) (myObj.length()/27);
            char[][] myArray= new char[lignSize][29];
            List<Integer> resultArray = new ArrayList<>();

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
            //RECONNAISSANCE DES NUMEROS
            for(i = 0;i<lignSize;i++){
                for(j=0;j<29;j++){
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
            for(Integer a : resultArray){
                System.out.println(a);
            }

            int total = calculateChecksum(resultArray);

            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/com/cleancode/OCR/result.txt"));
            int k=0;
            boolean isIllisible = false;
            for(Integer a : resultArray){
                if(a == -1){
                    writer.write("?");
                    isIllisible = true;
                }
                else{
                    writer.write(String.valueOf(a));    
                }
                
                k++;
                if(k%9 == 0){
                    if(isIllisible == false){
                        List<Integer> subArray = new ArrayList<>();
                        subArray.add(resultArray.get(k-9));
                        subArray.add(resultArray.get(k-8));
                        subArray.add(resultArray.get(k-7));
                        subArray.add(resultArray.get(k-6));
                        subArray.add(resultArray.get(k-5));
                        subArray.add(resultArray.get(k-4));
                        subArray.add(resultArray.get(k-3));
                        subArray.add(resultArray.get(k-2));
                        subArray.add(resultArray.get(k-1));
                        
                        total = calculateChecksum(subArray);
                        if(total != 0){
                            writer.write(" ERR");
                        }
                    } else {
                        writer.write(" ILL");
                    }
                    writer.write("\n");
                    isIllisible = false;
                }
            }
            
            writer.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static Integer calculateChecksum(List<Integer> a){
        return (9*a.get(0)+8*a.get(1)+7*a.get(2)+6*a.get(3)+5*a.get(4)+4*a.get(5)+3*a.get(6)+2*a.get(7)+a.get(8))%11;
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
        if(c[ligne][colonne] == ' ' && c[ligne][colonne+1] == ' ' &&  c[ligne][colonne+2] == ' ' 
                && c[ligne+1][colonne] == ' ' && c[ligne+1][colonne+1] == ' ' && c[ligne+1][colonne+2] == '|' 
                && c[ligne+2][colonne] == ' ' && c[ligne+2][colonne+1] == ' ' && c[ligne+2][colonne+2] == '|'){
            return true;
        }
        return false;
    }

    public static boolean isTwo(char[][] c, int ligne, int colonne){
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

    public static boolean isThree(char[][] c, int ligne, int colonne){
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

    public static boolean isFour(char[][] c, int ligne, int colonne){
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

    public static boolean isFive(char[][] c, int ligne, int colonne){
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

    public static boolean isSix(char[][] c, int ligne, int colonne){
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

    public static boolean isSeven(char[][] c, int ligne, int colonne){
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

    public static boolean isEight(char[][] c, int ligne, int colonne){
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

    public static boolean isNine(char[][] c, int ligne, int colonne){
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

    public static boolean isZero(char[][] c, int ligne, int colonne){
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
