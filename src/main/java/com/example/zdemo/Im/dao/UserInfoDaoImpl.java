package com.example.zdemo.Im.dao;

import com.example.zdemo.Im.domain.UserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {

    private Map<Long,UserInfo> map = new HashMap<>();

    /**
     * 这里使用死数据，不使用数据库
     */
    @Override
    public void loadUserInfo() {
        // 设置用户基本信息，共9个用户
        UserInfo userInfo1 = new UserInfo(101L, "Member001", "001", "static/img/avatar/Member001.jpg");
        UserInfo userInfo2 = new UserInfo(102L, "Member002", "002", "static/img/avatar/Member002.jpg");
        UserInfo userInfo3 = new UserInfo(103L, "Member003", "003", "static/img/avatar/Member003.jpg");
        UserInfo userInfo4 = new UserInfo(104L, "Member004", "004", "static/img/avatar/Member004.jpg");
        UserInfo userInfo5 = new UserInfo(105L, "Member005", "005", "static/img/avatar/Member005.jpg");
        UserInfo userInfo6 = new UserInfo(106L, "Member006", "006", "static/img/avatar/Member006.jpg");
        UserInfo userInfo7 = new UserInfo(107L, "Member007", "007", "static/img/avatar/Member007.jpg");
        UserInfo userInfo8 = new UserInfo(108L, "Member008", "008", "static/img/avatar/Member008.jpg");
        UserInfo userInfo9 = new UserInfo(109L, "Member009", "009", "static/img/avatar/Member009.jpg");

        map.put(101L, userInfo1);
        map.put(102L, userInfo2);
        map.put(103L, userInfo3);
        map.put(104L, userInfo4);
        map.put(105L, userInfo5);
        map.put(106L, userInfo6);
        map.put(107L, userInfo7);
        map.put(108L, userInfo8);
        map.put(109L, userInfo9);
    }

    @Override
    public UserInfo getByUserId(Long userId) {
        return map.get(userId);
    }
    
    @Override
    public UserInfo getByUsername(String username) {
        UserInfo result = null;
        Iterator<Entry<Long, UserInfo>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<Long, UserInfo> entry = iterator.next();
            if (entry.getValue().getUsername().equals(username)) {
                result = entry.getValue();
                break;
            }
        }
        return result;
    }
    
}
