package com.jk.service;

import com.jk.service.personal.mypersonaltree.MyPersonalTreeApiService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-Takeaway")
public interface Personal extends MyPersonalTreeApiService {
}
