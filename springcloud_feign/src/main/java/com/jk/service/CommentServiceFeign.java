package com.jk.service;

import com.jk.controller.comment.CommentService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("SERVICE-COMMENT")
public interface CommentServiceFeign extends CommentService {

}
