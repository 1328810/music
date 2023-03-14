package com.javaclimb.music.service.impl;

import com.javaclimb.music.dao.ConsumerMapper;
import com.javaclimb.music.domain.Consumer;
import com.javaclimb.music.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 前端用户service实现类
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private ConsumerMapper consumerMapper;

    @Override
    public boolean insert(Consumer consumer) {
        return consumerMapper.insert(consumer)>0;
    }

    @Override
    public boolean update(Consumer consumer) {
        return consumerMapper.update(consumer)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return consumerMapper.delete(id)>0;
    }

    @Override
    public ConsumerMapper selectByPrimaryKey(Integer id) {
        return consumerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ConsumerMapper> allConsumer() {
        return consumerMapper.allConsumer();
    }

    /**
     * 修改密码
     *
     * @param username
     * @param password
     */
    @Override
    public boolean verifPassword(String username, String password) {
        return consumerMapper.verifPassword(username,password)>0;
    }

    /**
     * 根据账号查询
     *
     * @param username
     */
    @Override
    public ConsumerMapper getByUsername(String username) {
        return consumerMapper.getByUsername(username);
    }
}
