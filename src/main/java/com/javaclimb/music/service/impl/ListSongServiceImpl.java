package com.javaclimb.music.service.impl;

import com.javaclimb.music.dao.ListSongMapper;
import com.javaclimb.music.dao.SongMapper;
import com.javaclimb.music.domain.ListSong;
import com.javaclimb.music.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 歌单里面的歌曲service实现类
 */
@Service
public class ListSongServiceImpl implements ListSongService {

    @Autowired
    private ListSongMapper ListSongMapper;


    @Override
    public boolean insert(ListSong listSong) {
        return ListSongMapper.insert(listSong)>0;
    }

    @Override
    public boolean update(ListSong listSong) {
        return ListSongMapper.update(listSong)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return ListSongMapper.delete(id)>0;
    }

    @Override
    public boolean deleteBySongIdAndSongListId(Integer songId,Integer songListId){
        return ListSongMapper.deleteBySongIdAndSongListId(songId,songListId)>0;
    }

    @Override
    public ListSong selectByPrimaryKey(Integer id) {
        return ListSongMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ListSong> allListSong() {
        return ListSongMapper.allListSong();
    }

    @Override
    public List<ListSong> listSongOfSongListId(Integer songListId) {
        return ListSongMapper.listSongOfSongListId(songListId);
    }
}
