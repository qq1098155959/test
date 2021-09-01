package cn.hwm.test.dao;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        //提取用户名
        Collection<String> transform = Collections2.transform(userList, new Function<User, String>() {
            @Nullable
            @Override
            public String apply(@Nullable User input) {
                return input.getName();
            }
        });
        //Java8写法
        //取List中单一数据存放在新的List当中
        List<String> list = userList.stream().map(User::getName).collect(Collectors.toList());

        //返回格式多包一层
        Map<String,List<User>> maplist = new HashMap<>();
        maplist.put("list",userList);

        //Java8forEach写法
        list.forEach(data -> {

        });

        //分割list为String。格式：a,b,c,d,e
        Joiner.on(",").join(list);
    }
}
