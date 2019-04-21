package com.jk.service.personal.mypersonaltree;





import com.jk.model.personal.myMaterial.MyPersonalBean;
import com.jk.model.personal.myMaterial.MyResideBean;
import com.jk.model.personal.mypersonaltree.MyPersonalTreeBean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface MyPersonalTreeApiService {



    @GetMapping("treeListMy")
    @ResponseBody
    List<MyPersonalTreeBean> treeListMy();

    @GetMapping("findMyReside")
    @ResponseBody
    List<MyResideBean> findMyReside();

    @DeleteMapping("deleteMyReside/{id}")
    @ResponseBody
    void deleteMyReside(@PathVariable("id") Integer id);


    @PostMapping("addMyReside")
    @ResponseBody
    void addMyReside(@RequestBody MyResideBean myResideBean);

    @GetMapping("findUpdeMyResideById/{id}")
    @ResponseBody
    MyResideBean findUpdeMyResideById(@PathVariable("id") Integer id);

    @PostMapping("upDateMyReside")
    @ResponseBody
    void upDateMyReside(@RequestBody MyResideBean myResideBean);

    @GetMapping("findMyPersonal/{id}")
    @ResponseBody
    MyPersonalBean findMyPersonal(@PathVariable("id") Integer id);

    @PostMapping("upDatePersonal")
    @ResponseBody
    void upDatePersonal(@RequestBody MyPersonalBean myPersonalBean);
}
