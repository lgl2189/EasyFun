import com.easyfun.util.VideoTranscoder;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/27 下午2:08
 */


public class VideoTransTest {

    public static void main(String[] args) {
        try {
            String inputPath = "C:\\Users\\12145\\Desktop\\sample.mp4";
            // 低清晰度 (360p, 400kbps)
            VideoTranscoder.transcode(inputPath, "C:\\Users\\12145\\Desktop\\360.mp4", 640, 360, 400 * 1000);
            // 中等清晰度 (480p, 800kbps)
            VideoTranscoder.transcode(inputPath, "C:\\Users\\12145\\Desktop\\480.mp4", 854, 480, 800 * 1000);
            // 高清晰度 (720p, 1500kbps)
            VideoTranscoder.transcode(inputPath, "C:\\Users\\12145\\Desktop\\720.mp4", 1280, 720, 1500 * 1000);
            // 高清晰度 (720p, 1500kbps)
            VideoTranscoder.transcode(inputPath, "C:\\Users\\12145\\Desktop\\720.mp4", 1920, 1080, 1500 * 1000);
            // 超高清晰度 (1080p, 3000kbps)
            VideoTranscoder.transcode(inputPath, "C:\\Users\\12145\\Desktop\\1080.mp4", 1920, 1080, 3000 * 1000);
            System.out.println("Transcoding completed successfully.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}