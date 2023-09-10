package org.sdsds222.testtlias.controller;


import lombok.extern.slf4j.Slf4j;
import org.sdsds222.testtlias.aop.TimeLog;
import org.sdsds222.testtlias.pojo.Dept;
import org.sdsds222.testtlias.pojo.Result;
import org.sdsds222.testtlias.service.DeptService;
import org.sdsds222.testtlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j//    private static Logger log = LoggerFactory.getLogger(DeptController.class);
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;
    //@RequestMapping(value = "/depts",method = RequestMethod.GET)//指定请求方式为GET

    @TimeLog
    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");
        //调用Service查询数据
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    //删除部门
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门:{}", id);
        //调用Service删除部门
        deptService.delete(id);
        return Result.success();
    }

    //新增部门
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门:{}", dept);
        //调用Service新增部门
        deptService.add(dept);
        return Result.success();
    }

    //根据id查询部门
    @GetMapping("/{id}")
    public Result select(@PathVariable String id) {
        log.info("根据id:{}查询部门", id);
        return Result.success(deptService.select(id));
    }

    //修改部门
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("根据id:{}修改部门", dept.getId());
        deptService.update(dept);
        return Result.success();
    }
}
