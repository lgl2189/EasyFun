import com.easyfun.config.SpringConfig;
import com.easyfun.mapper.TokenMapper;
import com.easyfun.pojo.Token;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/27 下午2:08
 */


public class Test {

    public static void main(String[] args) {
        // 初始化 Spring 应用上下文
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        // 从 Spring 上下文中获取 TokenMapper 实例
        TokenMapper tokenMapper = context.getBean(TokenMapper.class);
        System.out.println("TokenMapper instance: " + tokenMapper);

        // 调用 Mapper 方法
        Token token = tokenMapper.selectByPrimaryKey("113");
        if (token != null) {
            System.out.println("Token found: " + token);
        } else {
            System.out.println("No token found with ID '123'.");
        }
    }

}