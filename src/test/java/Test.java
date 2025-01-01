import com.easyfun.mapper.SearchMapper;
import com.easyfun.util.VideoThumbnailGenerator;
import com.easyfun.util.VideoUtil;
import org.apache.ibatis.session.SqlSession;
import org.bytedeco.javacv.FFmpegFrameGrabber;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/24 下午6:02
 */


public class Test {

    public static void main(String[] args) {
        String videoFilePath = "C:\\Users\\12145\\Desktop\\Easy_Fun\\测试视频\\01.青春百万円Part001.mp4";
        String duration = VideoUtil.getVideoDurationStr(videoFilePath);
        System.out.println(duration);
    }
}