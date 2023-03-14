package com.javaclimb.music.service;

import com.javaclimb.music.domain.Song;

import javax.annotation.Resource;
import java.util.List;
@Resource
public interface SongService {
    /*
     * 增加
     * */
    public boolean insert(Song song);
    /*
     * 修改
     * */
    public boolean update(Song song);
    /*
     * 删除
     * */
    public boolean delete(Integer id);
    /*
     * 根据主键查询所有歌曲
     * */
    public Song selectByPrimaryKey(Integer id);
    /*
     * 查询所有歌曲
     * */
    public List<Song> allSong();
    /*
     * 根据歌曲名字查询列表
     * */
    public List<Song> songOfName(String name);
    /*
     * 根据歌受id查询列表
     * */
    public List<Song> songOfSingerId(Integer singerId);
}
