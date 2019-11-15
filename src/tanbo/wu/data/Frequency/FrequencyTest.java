package tanbo.wu.data.Frequency;

import java.io.File;
import java.util.Scanner;

/**
 * @Author:2017110342_吴谭波
 * @Description:实现测试功能
 * @Date: 2019/11/13
 * @Modified By:2017110342_吴谭波
 */
public class FrequencyTest {
    public static void main(String[] args){
        File file = new File("D:/Passage.txt");
        LetterFrequencyCounter letterFrequencyCounter = new LetterFrequencyCounter();
        letterFrequencyCounter.loadFile(file);
        letterFrequencyCounter.loadFile("D:/Passage.txt");
        System.out.printf("请输入需要查询的字母:");
        Scanner input = new Scanner(System.in);
        String a = input.next();
        System.out.print(a + "出现的频率是:");
        System.out.printf("%.1f",letterFrequencyCounter.getFrequency(a.charAt(0))*100);
        System.out.println("%");
        letterFrequencyCounter.printFrequencies();
    }
}
