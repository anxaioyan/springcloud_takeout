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

import com.jk.model.Comment;
import com.jk.service.CommentServiceFeign;
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


    @PostMapping ("queryComment")
    @ResponseBody
    public responseComment queryComment(@RequestParam("page") Integer page, @RequestParam("limit") Integer rows){
        return commentServcieFeign.queryComment(page, rows);
    }

    @RequestMapping("saveComment")
    @ResponseBody
    public void saveComent(Comment comment){
        comment.setCommentdate(new Date());
        comment.setCommentname("321");
        commentServcieFeign.saveComment(comment);
    }
}
