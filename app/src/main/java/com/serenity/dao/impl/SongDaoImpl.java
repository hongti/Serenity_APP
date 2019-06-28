package com.serenity.dao.impl;

import com.serenity.model.Song;
import com.serenity.model.SongSheet;

import java.util.ArrayList;

public interface SongDaoImpl {
    boolean addSongToSongSheet(SongSheet songSheet, Song song);
    String getSinger(Song song);
    String getTitle(Song song);
    String getAlbum(Song song);
    String getAlbumImage(Song song);
    ArrayList<String> getLyric(Song song);
    ArrayList<String> getTime(Song song);

}
