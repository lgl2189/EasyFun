import com.easyfun.entity.DataWrapper;
import com.easyfun.entity.LoginInfo;
import com.google.gson.Gson;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/27 下午2:08
 */


public class Test {

    public static void main(String[] args) {
        DataWrapper data = new DataWrapper(new LoginInfo("123", "456", "789", "000"));
        System.out.println(new Gson().toJson(data));
    }

}