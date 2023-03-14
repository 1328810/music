package com.javaclimb.music.service.impl;

import com.javaclimb.music.dao.SongListMapper;
import com.javaclimb.music.domain.SongList;
import com.javaclimb.music.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
歌单service实现类
 */
@Service
public class SongListServiceImpl implements SongListService {

    @Autowired
    private SongListMapper SongListMapper;


    @Override
    public boolean insert(SongList songList) {
        return SongListMapper.insert(songList)>0;
    }

    @Override
    public boolean update(SongList songList) {
        return SongListMapper.update(songList)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return SongListMapper.delete(id)>0;
    }

    @Override
    public SongList selectByPrimaryKey(Integer id) {
        return SongListMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SongList> allSongList() {
        return SongListMapper.allSongList();
    }

    @Override
    public List<SongList> likeTitle(String title) {
        return SongListMapper.likeTitle(title);
    }

    @Override
    public List<SongList> likeStyle(String style) {
        return SongListMapper.likeStyle(style);
    }

    @Override
    public List<SongList> songOfTitle(String title) {
        return SongListMapper.songListOfTitle(title);
    }
}
