package com.jk.mapper;

import com.jk.model.room.Room;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@MapperScan
@Mapper
@Repository
public interface RommMapper1 {

    int queryRoomCount();

    List<Room> queryRoom(HashMap<String, Object> object);
}
