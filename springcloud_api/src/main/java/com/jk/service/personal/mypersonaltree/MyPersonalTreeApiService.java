package com.jk.service.personal.mypersonaltree;


import com.jk.model.personal.mypersonaltree.MyPersonalTreeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface MyPersonalTreeApiService {


    @GetMapping("treeListMy")
    @ResponseBody
    List<MyPersonalTreeBean> treeListMy();
}
