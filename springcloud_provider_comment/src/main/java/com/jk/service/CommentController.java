package com.jk.service;

import com.jk.model.Comment;
import com.jk.utils.PageUtil;
import com.jk.utils.responseComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController{

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/queryComment")
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




}
