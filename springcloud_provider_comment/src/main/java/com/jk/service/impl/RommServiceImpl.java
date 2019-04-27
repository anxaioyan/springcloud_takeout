/**
 * Copyright (C), 2019, 金科
 * FileName:
 * Author:   赵传明
 * Date:
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.jk.mapper.RommMapper1;
import com.jk.model.room.Room;
import com.jk.service.RommService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author 琪
 * @create 2019/4/23
 * @since 1.0.0
 */
@Service
public class RommServiceImpl implements RommService {

    @Resource
    private RommMapper1 rommMapper;
    @Override
    public int queryRoomCount() {
        return rommMapper.queryRoomCount();
    }

    @Override
    public List<Room> queryRoom(int start, Integer rows, Room room) {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("start",start);
        objectObjectHashMap.put("rows",rows);
        return rommMapper.queryRoom(objectObjectHashMap);
    }
}
