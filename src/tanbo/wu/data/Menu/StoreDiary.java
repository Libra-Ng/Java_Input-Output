package tanbo.wu.data.Menu;

import java.io.IOException;

/**
 * @Author:2017110342_吴谭波
 * @Description:实现存储日记接口
 * @Date: 2019/11/14
 * @Modified By:2017110342_吴谭波
 */
public interface StoreDiary {
    void storeDiary();
    void readDiary() throws IOException;
}
