package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("service-comment")
public interface CommentServiceFeign extends CommentService{

}
