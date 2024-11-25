import com.easyfun.enumeration.ImageFormatEnum;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/24 下午6:02
 */


public class Test {

    public static void main(String[] args) {
        ImageFormatEnum[] values = ImageFormatEnum.values();
        for (ImageFormatEnum value : values){
            System.out.println(value.getFormatStr());
        }
    }

}