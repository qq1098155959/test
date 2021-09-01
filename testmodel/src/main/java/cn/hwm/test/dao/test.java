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


        //将查询内容取出单独Id存放在一个List中，再根据List去查询对象中所有数据。再把返回的List对象封装在Map中，for循环中需要取数据就根据Key在map中取
//        List<Integer> communityIdlist = hotPage.getResult().stream().map(AppCommunityHot::getCommunityId).collect(Collectors.toList());
//        List<AppCommunity> appCommunityList = communityDao.getAppCommunityListByIds(communityIdlist);
//        if (CollectionUtils.isEmpty(appCommunityList)){
//            resp.setCode(YYErrorCode.FAIL);
//            resp.setMessage("社区列表为空");
//            return resp;
//        }
//        Map<Integer, AppCommunity> communityMap = appCommunityList.stream().collect(Collectors.toMap(AppCommunity::getId, Function.identity(), (k1, k2) -> k1));

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
