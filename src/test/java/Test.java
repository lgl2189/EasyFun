import com.easyfun.enumeration.ImageFormatEnum;
import com.easyfun.util.PasswordHasher;

import java.security.NoSuchAlgorithmException;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/24 下午6:02
 */


public class Test {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(PasswordHasher.hashPassword("1111"));
    }

}