package com.cleancode.OCR;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OCRFile {
    public File file;
    public FileReader fileReader;
    public BufferedReader bufferedReader;
    public BufferedWriter bufferedWriter;
    
    public OCRFile(String pathname) throws FileNotFoundException {
        file = new File(pathname);
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
    }

    public char[][] initArrayFromFile() throws IOException {
        int lignSize = getFileLignSize();
        int c = 0;
        int i = 0;
        int j = 0;
        char[][] myArray= new char[lignSize][29];
        while((c = bufferedReader.read()) != -1)
        {
            char character = (char) c;
            myArray[j][i] = (char) c;
            i++;
            if(i == 29){
                i=0;
                j+=1;
            }
        }
        return myArray;
    }
    
    public int getFileLignSize(){
        return (int) (file.length()/27);
    }
    
    public void writeResultFile(List<Integer> resultArray) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter("src/main/java/com/cleancode/OCR/result.txt"));
        int k=0;
        int total;
        boolean isIllisible = false;
        for(Integer a : resultArray){
            if(a == -1){
                bufferedWriter.write("?");
                isIllisible = true;
            }
            else{
                bufferedWriter.write(String.valueOf(a));
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
                        bufferedWriter.write(" ERR");
                    }
                } else {
                    bufferedWriter.write(" ILL");
                }
                bufferedWriter.write("\n");
                isIllisible = false;
            }
        }

        bufferedWriter.close();
    }

    public Integer calculateChecksum(List<Integer> a){
        return (9*a.get(0)+8*a.get(1)+7*a.get(2)+6*a.get(3)+5*a.get(4)+4*a.get(5)+3*a.get(6)+2*a.get(7)+a.get(8))%11;
    }
}
