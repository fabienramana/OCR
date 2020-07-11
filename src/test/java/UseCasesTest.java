import com.cleancode.OCR.OCRFile;
import com.cleancode.OCR.RecognizeNumber;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class UseCasesTest {
    @Test
    public void should_return_content_of_input_with_error_on_second_lign() throws IOException {
        String pathname = "src/main/java/com/cleancode/OCR/input.txt";
        
        OCRFile ocr = new OCRFile(pathname);

        char[][] myArray = ocr.initArrayFromFile();

        RecognizeNumber rn = new RecognizeNumber();
        rn.recognizeNumberFromArray(myArray);
        ocr.writeResultFile(rn.resultArray);

        String first_lign_expected = "123456789";
        String second_lign_expected = "238071956 ERR";
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/cleancode/OCR/result.txt"));
        String first_lign_result = br.readLine();
        Assertions.assertThat(first_lign_result).isEqualTo(first_lign_expected);
        String second_lign_result = br.readLine();
        Assertions.assertThat(second_lign_result).isEqualTo(second_lign_expected);
    }

    @Test
    public void should_return_content_of_input_2_with_no_error() throws IOException {
        String pathname = "src/main/java/com/cleancode/OCR/input2.txt";

        OCRFile ocr = new OCRFile(pathname);

        char[][] myArray = ocr.initArrayFromFile();

        RecognizeNumber rn = new RecognizeNumber();
        rn.recognizeNumberFromArray(myArray);
        ocr.writeResultFile(rn.resultArray);

        String first_lign_expected = "123456789";
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/cleancode/OCR/result.txt"));
        String first_lign_result = br.readLine();
        Assertions.assertThat(first_lign_result).isEqualTo(first_lign_expected);
    }

    @Test
    public void should_return_content_of_input_3_with_error() throws IOException {
        String pathname = "src/main/java/com/cleancode/OCR/input3.txt";

        OCRFile ocr = new OCRFile(pathname);

        char[][] myArray = ocr.initArrayFromFile();

        RecognizeNumber rn = new RecognizeNumber();
        rn.recognizeNumberFromArray(myArray);
        ocr.writeResultFile(rn.resultArray);

        String first_lign_expected = "356609701 ERR";
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/cleancode/OCR/result.txt"));
        String first_lign_result = br.readLine();
        Assertions.assertThat(first_lign_result).isEqualTo(first_lign_expected);
    }

    @Test
    public void should_return_content_of_input_4_with_error_on_2nd_lign_and_ill_on_3rd() throws IOException {
        String pathname = "src/main/java/com/cleancode/OCR/input4.txt";

        OCRFile ocr = new OCRFile(pathname);

        char[][] myArray = ocr.initArrayFromFile();

        RecognizeNumber rn = new RecognizeNumber();
        rn.recognizeNumberFromArray(myArray);
        ocr.writeResultFile(rn.resultArray);

        String first_lign_expected = "457508000";
        String second_lign_expected = "664371495 ERR";
        String third_lign_expected = "12?13678? ILL";
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/cleancode/OCR/result.txt"));
        String first_lign_result = br.readLine();
        Assertions.assertThat(first_lign_result).isEqualTo(first_lign_expected);
        String second_lign_result = br.readLine();
        Assertions.assertThat(second_lign_result).isEqualTo(second_lign_expected);
        String third_lign_result = br.readLine();
        Assertions.assertThat(third_lign_result).isEqualTo(third_lign_expected);
    }
}
