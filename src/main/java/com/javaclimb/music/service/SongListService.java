package com.javaclimb.music.service;

import com.javaclimb.music.domain.SongList;

import javax.annotation.Resource;
import java.util.List;

/*
歌单service接口
 */
@Resource
public interface SongListService {
    /*
     * 增加
     * */
    public boolean insert(SongList songList);
    /*
     * 修改
     * */
    public boolean update(SongList songList);
    /*
     * 删除
     * */
    public boolean delete(Integer id);
    /*
     * 根据主键查询所有歌单
     * */
    public SongList selectByPrimaryKey(Integer id);
    /*
     * 查询所有歌单
     * */
    public List<SongList> allSongList();
    /*
     * 根据歌单标题模糊查询列表
     * */
    public List<SongList> likeTitle(String title);
    /*
     * 根据歌单风格模糊查询列表
     * */
    public List<SongList> likeStyle(String style);
    /*
     * 根据歌单标题查询列表
     * */
    public List<SongList> songOfTitle(String title);
}
