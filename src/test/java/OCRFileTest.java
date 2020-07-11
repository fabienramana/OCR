import com.cleancode.OCR.OCRFile;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class OCRFileTest {
    
    @Test
    public void test_init_array_should_return_an_array_character_by_character_of_3_in_first_row() throws IOException {
        String pathname = "src/main/java/com/cleancode/OCR/input3.txt";
        
        OCRFile ocr = new OCRFile(pathname);
        
        char[][] c = ocr.initArrayFromFile();
        
        
        Assertions.assertThat(c[0][0]).isEqualTo(' ');
        Assertions.assertThat(c[0][1]).isEqualTo('_');
        Assertions.assertThat(c[0][2]).isEqualTo(' ');
        Assertions.assertThat(c[1][0]).isEqualTo(' ');
        Assertions.assertThat(c[1][1]).isEqualTo('_');
        Assertions.assertThat(c[1][2]).isEqualTo('|');
        Assertions.assertThat(c[2][0]).isEqualTo(' ');
        Assertions.assertThat(c[2][1]).isEqualTo('_');
        Assertions.assertThat(c[2][2]).isEqualTo('|');
    }
    
    @Test
    public void test_getFileLignSize_should_return_4() throws FileNotFoundException {
        String pathname = "src/main/java/com/cleancode/OCR/input3.txt";
        OCRFile ocr = new OCRFile(pathname);
        
        int result = ocr.getFileLignSize();        
        
        int expected =4; // number of lign in input

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_calculateChecksum_should_return_0() throws FileNotFoundException {
        String pathname = "src/main/java/com/cleancode/OCR/input3.txt";
        OCRFile ocr = new OCRFile(pathname);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        int result = ocr.calculateChecksum(list);

        int expected =0;

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_calculateChecksum_should_return_5() throws FileNotFoundException {
        String pathname = "src/main/java/com/cleancode/OCR/input3.txt";
        OCRFile ocr = new OCRFile(pathname);
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(6);
        list.add(0);
        list.add(9);
        list.add(7);
        list.add(0);
        list.add(1);

        int result = ocr.calculateChecksum(list);

        int expected =5;

        Assertions.assertThat(result).isEqualTo(expected);
    }
    
    @Test
    public void test_writeResultFile_should_return_123456789_in_result_file() throws IOException {
        String pathname = "src/main/java/com/cleancode/OCR/input2.txt";
        OCRFile ocr = new OCRFile(pathname);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        
        ocr.writeResultFile(list);
        
        String expected = "123456789";
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/cleancode/OCR/result.txt"));
        String result = br.readLine();
        Assertions.assertThat(result).isEqualTo(expected);
        
        
    }
}
