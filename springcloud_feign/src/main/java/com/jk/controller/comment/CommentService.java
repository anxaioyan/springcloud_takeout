package com.jk.controller.comment;


import com.jk.model.Comment;
import com.jk.utils.responseComment;
import org.springframework.web.bind.annotation.*;

public interface CommentService {

    @RequestMapping(value = "queryComment" , method = RequestMethod.POST)
    @ResponseBody
    responseComment queryComment(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows);

    @RequestMapping(value = "saveComment" , method = RequestMethod.POST)
    @ResponseBody
    void saveComment(@RequestBody Comment comment);


}
