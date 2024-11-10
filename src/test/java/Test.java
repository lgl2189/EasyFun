import com.easyfun.json.LocalDateTimeDeserializer;
import com.easyfun.json.LocalDateTimeSerializer;
import com.easyfun.json.LocalTimeDeserializer;
import com.easyfun.json.LocalTimeSerializer;
import com.easyfun.pojo.Video;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/27 下午2:08
 */


public class Test {

    public static void main(String[] args) {
        Video video = new Video();
        video.setVid(225L);
        video.setVideoPath("1");
        video.setTitle("Mr.");
        video.setPublisherId(199L);
        video.setPublisherName("Ikeda Eita");
        video.setLikeNum(64);
        video.setCoinNum(869);
        video.setFavoriteNum(675);
        video.setShareNum(738);
        video.setViewNum(501);
        video.setDanmakuNum(null);
        video.setCommentNum(107);
        video.setPublishDatetime(LocalDateTime.of(2024, 10, 24, 22, 17, 56));
        video.setIsOriginal(false);
        video.setIntroduction("JDBUNQVKDA");
        video.setVideoDuration(LocalTime.of(11, 12, 29));
        video.setCoverPath("0tYWLQnYwK");
        video.setTagList("{}");
        video.setCommentList(null);
        video.setDanmakuList(null);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
                .registerTypeAdapter(LocalTime.class, new LocalTimeSerializer())
                .registerTypeAdapter(LocalTime.class, new LocalTimeDeserializer())
                .create();

        String json = gson.toJson(video);
        System.out.println(json);
    }

}