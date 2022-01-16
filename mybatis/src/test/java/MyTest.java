import com.whj.mapper.UserMapper;
import com.whj.pojo.User;
import com.whj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-07 12:37
 * @version: 1.0
 */
public class MyTest {
    @Test
    public void selectUser() {
        SqlSession session = MybatisUtils.getSession();
        //方法一:
        //List<User> users = session.selectList("com.kuang.mapper.UserMapper.selectUser");
        //方法二:
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();

        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }


    @Test
    public void testUpdateUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        user.setPwd("asdfgh");
        int i = mapper.updateUser(user);
        System.out.println(i);
        session.commit(); //提交事务,重点!不写的话不会提交到数据库
        session.close();
    }

    @Test
    public void testAddUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User(5L,"王五","zxcvbn");
        int i = mapper.addUser(user);
        System.out.println(i);
        session.commit(); //提交事务,重点!不写的话不会提交到数据库
        session.close();
    }
    @Test
    public void selectUserByNP() {
        SqlSession session = MybatisUtils.getSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserByNP("小明","123456");

        session.close();
    }
    @Test
    public void selectUserByNP2() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username","小明");
        map.put("pwd","123456");
        User user = mapper.selectUserByNP2(map);

        session.close();
    }
}