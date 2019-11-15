    /**
     * @Author:2017110342_吴谭波
     * @Description:实现简单的写日记功能
     * @Date: 2019/10/18
     * @Modified By:2017110342_吴谭波
     */

    package tanbo.wu.data.Menu;

    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
    import java.io.IOException;

    enum Weather{
        sunny,rainy,cloudy,windy,snowy
    }

    enum Mood{
        happy,sad,normal
    }

    public class Diary implements StoreDiary{
        private Date date;  //日期
        private Weather weather;  //天气
        private Mood mood;  //心情
        private String title;  //标题
        private String content;  //内容
        private int countDiary = 0;  //日记的篇数

        Diary(Date date, Weather weather, Mood mood, String title, String content) {
            this.date = date;
            this.weather = weather;
            this.mood = mood;
            this.title = title;
            this.content = content;
        }

        Diary() {

        }

        public Date getDate() {
            return date;
        }

        String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        @Override
        public String toString(){
            return "时间是：" + date.getDate() + "\n"
                    + "天气是：" + weather + "\n"
                    + "心情是：" + mood + "\n"
                    + "日记标题是:" + title + "\n"
                    + "日记内容是：" + content;
        }

        @Override
        public void storeDiary() {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("D:/DiaryContent.txt");
               // FileOutputStream fileOutputStream1 = new FileOutputStream("D:/DiaryNumber.txt");
                String string = this.toString();
                byte[] words = string.getBytes();
                fileOutputStream.write(words,0,words.length);
                countDiary++;
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        @Override
        public void readDiary() throws IOException {
            try (FileInputStream fileInputStream = new FileInputStream("D:/DiaryContent.txt")) {
                fileInputStream.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
