import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/27 下午2:08
 */


public class Test {

    public static void main(String[] args) {
        ArrayList<Map<String, String>> hotList = new ArrayList<>();
        Map<String, String> hot1 = new HashMap<>();
        hot1.put("name", "尼尔：自动人形");
        hot1.put("score", "9.5");
        hot1.put("update","更新至第三话");
        hot1.put("src","src/assets/images/anime_cover1.avif");
        Map<String, String> hot2 = new HashMap<>();
        hot2.put("name", "鹿乃子乃子乃子虎视眈眈");
        hot2.put("score", "9.5");
        hot2.put("update","更新至第三话");
        hot2.put("src","src/assets/images/anime_cover2.avif");
        hotList.add(new HashMap<>(hot1));
        hotList.add(new HashMap<>(hot2));
        hotList.add(new HashMap<>(hot1));
        hotList.add(new HashMap<>(hot2));
        hotList.add(new HashMap<>(hot1));
        hotList.add(new HashMap<>(hot2));
        int i = 1;
        for(Map<String, String> hotItem: hotList){
            hotItem.put("id", String.valueOf(i));
            i++;
        }
        System.out.println(hotList);
    }

}