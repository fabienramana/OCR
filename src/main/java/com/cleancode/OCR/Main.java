package com.cleancode.OCR;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main { 
    public static void main(String[] args) {
        String pathname = "";
        try {
            OCRFile ocr = new OCRFile(pathname);
            
            char[][] myArray = ocr.initArrayFromFile();

            RecognizeNumber rn = new RecognizeNumber();
            rn.recognizeNumberFromArray(myArray);
            ocr.writeResultFile(rn.resultArray);
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
  
}
