package com.jk.Service.shop;


import com.jk.service.shop.ShopService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "provider-shop")
public interface ShopServiceFeign extends ShopService {

}
