package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("service-user")
public interface UserServiceFeign extends UserService {
}
