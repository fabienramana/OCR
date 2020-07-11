import com.cleancode.OCR.RecognizeNumber;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RecognizeNumberTest{
    
    @Test
    public void test_guess_number_should_return_1(){
        char[][] array = { {' ', ' ', ' '}, {' ', ' ', '|'}, {' ', ' ', '|'}, {' ', ' ', ' '} };
        RecognizeNumber  rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        int result = rn.guessNumber(array,row,column);
        
        int expected = 1;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_guess_number_should_return_2(){
        char[][] array = { {' ', '_', ' '}, {' ', '_', '|'}, {'|', '_', ' '}, {' ', ' ', ' '} };
        RecognizeNumber  rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        int result = rn.guessNumber(array,row,column);

        int expected = 2;
        Assertions.assertThat(result).isEqualTo(expected);
    }
    @Test
    public void test_guess_number_should_return_3(){
        char[][] array = { {' ', '_', ' '}, {' ', '_', '|'}, {' ', '_', '|'}, {' ', ' ', ' '} };
        RecognizeNumber  rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        int result = rn.guessNumber(array,row,column);

        int expected = 3;
        Assertions.assertThat(result).isEqualTo(expected);
    }
    @Test
    public void test_guess_number_should_return_4(){
        char[][] array = { {' ', ' ', ' '}, {'|', '_', '|'}, {' ', ' ', '|'}, {' ', ' ', ' '} };
        RecognizeNumber  rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        int result = rn.guessNumber(array,row,column);

        int expected = 4;
        Assertions.assertThat(result).isEqualTo(expected);
    }
    @Test
    public void test_guess_number_should_return_5(){
        char[][] array = { {' ', '_', ' '}, {'|', '_', ' '}, {' ', '_', '|'}, {' ', ' ', ' '} };
        RecognizeNumber  rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        int result = rn.guessNumber(array,row,column);

        int expected = 5;
        Assertions.assertThat(result).isEqualTo(expected);
    }
    @Test
    public void test_guess_number_should_return_6(){
        char[][] array = { {' ', '_', ' '}, {'|', '_', ' '}, {'|', '_', '|'}, {' ', ' ', ' '} };
        RecognizeNumber  rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        int result = rn.guessNumber(array,row,column);

        int expected = 6;
        Assertions.assertThat(result).isEqualTo(expected);
    }
    @Test
    public void test_guess_number_should_return_7(){
        char[][] array = { {' ', '_', ' '}, {' ', ' ', '|'}, {' ', ' ', '|'}, {' ', ' ', ' '} };
        RecognizeNumber  rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        int result = rn.guessNumber(array,row,column);

        int expected = 7;
        Assertions.assertThat(result).isEqualTo(expected);
    }
    @Test
    public void test_guess_number_should_return_8(){
        char[][] array = { {' ', '_', ' '}, {'|', '_', '|'}, {'|', '_', '|'}, {' ', ' ', ' '} };
        RecognizeNumber  rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        int result = rn.guessNumber(array,row,column);

        int expected = 8;
        Assertions.assertThat(result).isEqualTo(expected);
    }
    @Test
    public void test_guess_number_should_return_9(){
        char[][] array = { {' ', '_', ' '}, {'|', '_', '|'}, {' ', '_', '|'}, {' ', ' ', ' '} };
        RecognizeNumber  rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        int result = rn.guessNumber(array,row,column);

        int expected = 9;
        Assertions.assertThat(result).isEqualTo(expected);
    }
    @Test
    public void test_guess_number_should_return_0(){
        char[][] array = { {' ', '_', ' '}, {'|', ' ', '|'}, {'|', '_', '|'}, {' ', ' ', ' '} };
        RecognizeNumber  rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        int result = rn.guessNumber(array,row,column);

        int expected = 0;
        Assertions.assertThat(result).isEqualTo(expected);
    }
    
    @Test
    public void test_recognize_number_from_array_should_return_1234(){
        char[][] array = {
                {' ', ' ', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', ' ', ' '},
                {' ', ' ', '|', ' ', '_', '|', ' ', '_', '|', '|', '_', '|'},
                {' ', ' ', '|', '|', '_', ' ', ' ', '_', '|', ' ', ' ', '|'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
        };
        RecognizeNumber  rn = new RecognizeNumber();
        
        rn.recognizeNumberFromArray(array);

        int expected_first_row = 1;
        int expected_second_row = 2;
        int expected_third_row = 3;
        int expected_fourth_row = 4;
        Assertions.assertThat(rn.resultArray.get(0)).isEqualTo(expected_first_row);
        Assertions.assertThat(rn.resultArray.get(1)).isEqualTo(expected_second_row);
        Assertions.assertThat(rn.resultArray.get(2)).isEqualTo(expected_third_row);
        Assertions.assertThat(rn.resultArray.get(3)).isEqualTo(expected_fourth_row);
    }

    @Test
    public void test_recognize_number_from_array_should_return_minus_1(){
        char[][] array = {
                {' ', ' ', '|'},
                {' ', ' ', '|'},
                {' ', ' ', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber  rn = new RecognizeNumber();

        rn.recognizeNumberFromArray(array);
    
        int expected_first_row = -1;    
        Assertions.assertThat(rn.resultArray.get(0)).isEqualTo(expected_first_row);
    }

    @Test
    public void test_recognize_number_from_array_should_return_5967(){
        char[][] array = {
                {' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' ', ' ', '_', ' '},
                {'|', '_', ' ', '|', '_', '|', '|', '_', ' ', ' ', ' ', '|'},
                {' ', '_', '|', ' ', '_', '|', '|', '_', '|', ' ', ' ', '|'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        };
        RecognizeNumber  rn = new RecognizeNumber();

        rn.recognizeNumberFromArray(array);

        int expected_first_row = 5;
        int expected_second_row = 9;
        int expected_third_row = 6;
        int expected_fourth_row = 7;
        Assertions.assertThat(rn.resultArray.get(0)).isEqualTo(expected_first_row);
        Assertions.assertThat(rn.resultArray.get(1)).isEqualTo(expected_second_row);
        Assertions.assertThat(rn.resultArray.get(2)).isEqualTo(expected_third_row);
        Assertions.assertThat(rn.resultArray.get(3)).isEqualTo(expected_fourth_row);
    }
    
    @Test
    public void test_isOne_should_return_true(){
        char[][] array = {
                {' ', ' ', ' '},
                {' ', ' ', '|'},
                {' ', ' ', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;
        
        boolean result = rn.isOne(array,row,column);
        
        boolean expected = true;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isOne_should_return_false(){
        char[][] array = {
                {' ', ' ', '|'},
                {' ', ' ', '|'},
                {' ', ' ', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        boolean result = rn.isOne(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isOne_should_return_false_due_to_array_length(){
        char[][] array = {
                {' ', ' ', ' '},
                {' ', ' ', '|'},
                {' ', ' ', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 1;
        int column = 1;

        boolean result = rn.isOne(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isTwo_should_return_true(){
        char[][] array = {
                {' ', '_', ' '},
                {' ', '_', '|'},
                {'|', '_', ' '},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        boolean result = rn.isTwo(array,row,column);

        boolean expected = true;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isTwo_should_return_false(){
        char[][] array = {
                {' ', '_', '_'},
                {' ', '_', '|'},
                {'|', '_', ' '},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        boolean result = rn.isTwo(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isTwo_should_return_false_due_to_array_length(){
        char[][] array = {
                {' ', '_', ' '},
                {' ', '_', '|'},
                {'|', '_', ' '},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 1;
        int column = 1;

        boolean result = rn.isTwo(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isThree_should_return_true(){
        char[][] array = {
                {' ', '_', ' '},
                {' ', '_', '|'},
                {' ', '_', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        boolean result = rn.isThree(array,row,column);

        boolean expected = true;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isThree_should_return_false(){
        char[][] array = {
                {' ', '_', '_'},
                {' ', '_', '|'},
                {' ', '_', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        boolean result = rn.isThree(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isThree_should_return_false_due_to_array_length(){
        char[][] array = {
                {' ', '_', ' '},
                {' ', '_', '|'},
                {' ', '_', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 1;
        int column = 1;

        boolean result = rn.isThree(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isFour_should_return_true(){
        char[][] array = {
                {' ', ' ', ' '},
                {'|', '_', '|'},
                {' ', ' ', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        boolean result = rn.isFour(array,row,column);

        boolean expected = true;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isFour_should_return_false(){
        char[][] array = {
                {' ', ' ', '_'},
                {'|', '_', '|'},
                {' ', ' ', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        boolean result = rn.isFour(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isFour_should_return_false_due_to_array_length(){
        char[][] array = {
                {' ', ' ', ' '},
                {'|', '_', '|'},
                {' ', ' ', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 1;
        int column = 1;

        boolean result = rn.isFour(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isFive_should_return_true(){
        char[][] array = {
                {' ', '_', ' '},
                {'|', '_', ' '},
                {' ', '_', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        boolean result = rn.isFive(array,row,column);

        boolean expected = true;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isFive_should_return_false(){
        char[][] array = {
                {' ', '_', '_'},
                {'|', '_', ' '},
                {' ', '_', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        boolean result = rn.isFive(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isFive_should_return_false_due_to_array_length(){
        char[][] array = {
                {' ', '_', ' '},
                {'|', '_', ' '},
                {' ', '_', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 1;
        int column = 1;

        boolean result = rn.isFive(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isSix_should_return_true(){
        char[][] array = {
                {' ', '_', ' '},
                {'|', '_', ' '},
                {'|', '_', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        boolean result = rn.isSix(array,row,column);

        boolean expected = true;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isSix_should_return_false(){
        char[][] array = {
                {' ', '_', '_'},
                {'|', '_', ' '},
                {'|', '_', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        boolean result = rn.isSix(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isSix_should_return_false_due_to_array_length(){
        char[][] array = {
                {' ', '_', ' '},
                {'|', '_', ' '},
                {'|', '_', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 1;
        int column = 1;

        boolean result = rn.isSix(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isSeven_should_return_true(){
        char[][] array = {
                {' ', '_', ' '},
                {' ', ' ', '|'},
                {' ', ' ', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        boolean result = rn.isSeven(array,row,column);

        boolean expected = true;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isSeven_should_return_false(){
        char[][] array = {
                {' ', '_', '_'},
                {' ', ' ', '|'},
                {' ', ' ', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        boolean result = rn.isSeven(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isSeven_should_return_false_due_to_array_length(){
        char[][] array = {
                {' ', '_', ' '},
                {' ', ' ', '|'},
                {' ', ' ', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 1;
        int column = 1;

        boolean result = rn.isSeven(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isEight_should_return_true(){
        char[][] array = {
                {' ', '_', ' '},
                {'|', '_', '|'},
                {'|', '_', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        boolean result = rn.isEight(array,row,column);

        boolean expected = true;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isEight_should_return_false(){
        char[][] array = {
                {' ', '_', '_'},
                {'|', '_', '|'},
                {'|', '_', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        boolean result = rn.isEight(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isEight_should_return_false_due_to_array_length(){
        char[][] array = {
                {' ', '_', ' '},
                {'|', '_', '|'},
                {'|', '_', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 1;
        int column = 1;

        boolean result = rn.isEight(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isNine_should_return_true(){
        char[][] array = {
                {' ', '_', ' '},
                {'|', '_', '|'},
                {' ', '_', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        boolean result = rn.isNine(array,row,column);

        boolean expected = true;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isNine_should_return_false(){
        char[][] array = {
                {' ', '_', '_'},
                {'|', '_', '|'},
                {' ', '_', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        boolean result = rn.isNine(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isNine_should_return_false_due_to_array_length(){
        char[][] array = {
                {' ', '_', ' '},
                {'|', '_', '|'},
                {' ', '_', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 1;
        int column = 1;

        boolean result = rn.isNine(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isZero_should_return_true(){
        char[][] array = {
                {' ', '_', ' '},
                {'|', ' ', '|'},
                {'|', '_', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        boolean result = rn.isZero(array,row,column);

        boolean expected = true;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isZero_should_return_false(){
        char[][] array = {
                {' ', '_', '_'},
                {'|', ' ', '|'},
                {'|', '_', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 0;
        int column = 0;

        boolean result = rn.isZero(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_isZero_should_return_false_due_to_array_length(){
        char[][] array = {
                {' ', '_', ' '},
                {'|', ' ', '|'},
                {'|', '_', '|'},
                {' ', ' ', ' '},
        };
        RecognizeNumber rn = new RecognizeNumber();
        int row = 1;
        int column = 1;

        boolean result = rn.isZero(array,row,column);

        boolean expected = false;
        Assertions.assertThat(result).isEqualTo(expected);
    }
    
}