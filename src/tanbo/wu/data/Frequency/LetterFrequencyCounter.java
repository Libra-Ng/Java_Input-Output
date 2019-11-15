package tanbo.wu.data.Frequency;

import java.io.*;
import java.util.*;
import java.lang.String;

/**
 * @Author:2017110342_吴谭波
 * @Description:实现统计频率的类
 * @Date: 2019/11/14
 * @Modified By:2017110342_吴谭波
 */
public class LetterFrequencyCounter {
    Map<Character,Double> map = new HashMap<>();
    int sumLetter = 0;

    public boolean loadFile(File file) {
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
            int item;
            char letter;
            while ((item = fileInputStream.read())!=-1){
                if ((char)item >= 'A' && (char)item <= 'z'){
                    sumLetter++;
                    letter = Character.toLowerCase((char)item);
                    if (map.get(letter) == null){
                        map.put(letter,1.0);
                    }else {
                        double letterNum = map.get(letter);
                        letterNum++;
                        map.put(letter,letterNum);
                    }
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("文件不存在！");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


    boolean loadFile(String filename) {
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("D:/Passage.txt");
            int item;
            char letter;
            while ((item = fileInputStream.read())!=-1){
                if ((char)item >= 'A' && (char)item <= 'z'){
                    sumLetter++;
                    letter = Character.toLowerCase((char)item);
                    if (map.get(letter) == null){
                        map.put(letter,1.0);
                    }else {
                        double letterNum = map.get(letter);
                        letterNum++;
                        map.put(letter,letterNum);
                    }
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("文件不存在！");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    //获取某个字母出现的频率
    double getFrequency(char a){
        return map.get(a) / sumLetter;
    }

    //打印所有字母出现的频率
    void printFrequencies(){
        for (Map.Entry<Character,Double> entry: map.entrySet()){
            System.out.print(entry.getKey() + "出现的频率是:");
            System.out.printf("%.1f",entry.getValue()/sumLetter*100);
            System.out.println("%");
        }
    }
}
