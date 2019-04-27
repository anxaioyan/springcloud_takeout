package com.jk.service;

import com.jk.model.comment.Comment;
import com.jk.model.room.Room;
import com.jk.utils.PageUtil;
import com.jk.utils.ResponseLayui;
import com.jk.utils.responseComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentController{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private RommService rommService;

    @PostMapping("/queryComment")
    @ResponseBody
    public responseComment queryComment(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows) {

        Query query = new Query();
        long total = mongoTemplate.count(query, Comment.class);
        int start = (page-1)*rows;
        query.skip(start).limit(rows);
        List<Comment> list = mongoTemplate.find(query,Comment.class);
        responseComment responseComment = new responseComment();
        PageUtil pageUtil = new PageUtil(""+page,""+rows);
        Integer count = Math.toIntExact(total);
        pageUtil.setTotalCount(count);
        responseComment.setList(list);
        responseComment.setPageUtil(pageUtil);
        return responseComment;
    }

    @PostMapping("/saveComment")
    @ResponseBody
    public void saveComment(@RequestBody Comment comment) {
        mongoTemplate.save(comment);
    }


    //分页查询骑手
    @PostMapping("/queryRoom")
    @ResponseBody
    public ResponseLayui queryRoom(Integer page, Integer rows, @RequestBody Room room) {
        //查询总条数
        int total = rommService.queryRoomCount();
        //分页查询
        int start = (page-1)*rows;
        List<Room> list = rommService.queryRoom(start,rows,room);
        ResponseLayui responseLayui = new ResponseLayui();
        responseLayui.setCode(0);
        responseLayui.setCount(total);
        responseLayui.setData(list);
        responseLayui.setMsg("");
        return responseLayui;
    }



}
