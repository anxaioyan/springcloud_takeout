package com.jk.service;

import com.jk.model.room.Room;

import java.util.List;

public interface RommService {
    int queryRoomCount();

    List<Room> queryRoom(int start, Integer rows, Room room);
}
