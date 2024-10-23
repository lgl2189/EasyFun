import com.alibaba.druid.sql.ast.statement.SQLPurgeTemporaryOutputStatement;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/10/23 下午4:52
 */


public class MybatisGenerator {

    private static boolean flag = false;

    public static void main(String[] args) throws Exception {
        if(flag){
            List<String> warnings = new ArrayList<>();
            boolean overwrite = true;
            InputStream is = MybatisGenerator.class.getResourceAsStream("/mybatisGeneratorConfig.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(is);
            is.close();
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            for(String warning:warnings){
                System.out.println(warning);
            }
        }
        else{
            System.out.println("启动MybatisGenerator时未进行安全检查！这会导致pojo和mapper中类被覆盖！");
            System.out.println("建议在另一个空项目中运行生成程序！本程序仅做备份！");
            System.out.println("请将标识符修改为true后，重新启动MybatisGenerator");
        }
    }

}