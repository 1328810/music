package com.javaclimb.music.dao;

import com.javaclimb.music.domain.Consumer;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 前端用户Dao
 */
@Repository
public interface ConsumerMapper {
    /*
     * 增加
     * */
    public int insert(Consumer consumer);
    /*
     * 修改
     * */
    public int update(Consumer consumer);
    /*
     * 删除
     * */
    public int delete(Integer id);
    /*
     * 根据主键查询所有用户
     * */
    public ConsumerMapper selectByPrimaryKey (Integer id);
    /*
     * 查询所有用户
     * */
    public List<ConsumerMapper> allConsumer();
    /**
     * 修改密码
     */
    public int verifPassword(String username,String password);
    /**
     * 根据账号查询
     */
    public ConsumerMapper getByUsername(String username);
}
