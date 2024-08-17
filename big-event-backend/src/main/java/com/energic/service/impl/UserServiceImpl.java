package com.energic.service.impl;

import com.energic.mapper.UserMapper;
import com.energic.pojo.User;
import com.energic.service.UserService;
import com.energic.utils.Md5Util;
import com.energic.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(final String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void register(final String username, final String password) {
        final String md5String = Md5Util.getMD5String(password);
        userMapper.add(username, md5String);
    }

    @Override
    public void update(final User user) {
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(final String url) {
        final Map<String, Object> map = ThreadLocalUtil.get();
        final Integer id = (Integer) map.get("id");
        userMapper.updateAvatar(url, id);
    }

    @Override
    public void updatePwd(final String newPwd) {
        final String md5String = Md5Util.getMD5String(newPwd);
        final Map<String, Object> map = ThreadLocalUtil.get();
        final Integer id = (Integer) map.get("id");
        userMapper.updatePwd(md5String, id);
    }
}
