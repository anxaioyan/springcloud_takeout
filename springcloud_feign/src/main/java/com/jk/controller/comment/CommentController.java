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
package com.jk.controller.comment;

import com.jk.model.comment.Comment;
import com.jk.model.room.Room;
import com.jk.service.CommentServiceFeign;
import com.jk.utils.ResponseLayui;
import com.jk.utils.responseComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈a〉
 *
 * @author 琪
 * @create 2019/4/21
 * @since 1.0.0
 */
@Controller
public class CommentController {

    @Autowired
    private CommentServiceFeign commentServcieFeign;


    //分页查询评论
    @PostMapping ("queryComment")
    @ResponseBody
    public responseComment queryComment(@RequestParam("page") Integer page, @RequestParam("limit") Integer rows){
        responseComment responseComment = commentServcieFeign.queryComment(page, rows);
        return responseComment;
    }

    //新增评论评分
    @RequestMapping("saveComment")
    @ResponseBody
    public void saveComent(Comment comment){
        comment.setCommentdate(new Date());//new一个当前时间

        commentServcieFeign.saveComment(comment);
    }

    //分页查询骑手列表
    @RequestMapping("queryRoom")
    @ResponseBody
    public ResponseLayui queryRoom(@RequestParam("page") Integer page, @RequestParam("limit") Integer rows, Room room){
        ResponseLayui responseLayui = commentServcieFeign.queryRoom(page, rows, room);
        return responseLayui;
    }
}
