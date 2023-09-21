package com.bxl.plus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bxl.plus.entity.Device;
import com.bxl.plus.service.DeviceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 白小楼
 * @Description:
 * @Date:Create in 2023/9/7 10:50
 */

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Resource
    private DeviceService deviceService;

    /**
     * 新增
     * @param device
     * @return
     */
    @PostMapping("/add")
    public String addDevice(@RequestBody Device device){
        deviceService.save(device);
        return "Device新增成功!";
    }

    /**
     * 根据Id查询Device
     * @return
     */
    @GetMapping("/{id}")
    public Device getDeviceById(@PathVariable Integer id){
        return deviceService.getById(id);
    }

    /**
     * Page分页查询
     * @param page 页号-默认1
     * @param pageSize 步长-默认10
     * @return
     */
    @GetMapping("/page")
    public IPage<Device> getPageDevice(@RequestParam(name = "page",defaultValue = "1",required = false) Integer page,
                                      @RequestParam(name = "pageSize",defaultValue = "10",required = false)Integer pageSize){
        IPage<Device> devicePage = deviceService.page(new Page(page,pageSize),null);
        return devicePage;
    }


    /**
     * 根据Id修改
     * @param device
     * @return
     */
    @PutMapping("/update")
    public String updateById(@RequestBody Device device){
        deviceService.updateById(device);   //修改
        return "修改成功";
    }

    /**
     * 根据Id删除
     * @return
     */
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Integer id){
        deviceService.removeById(id);
        return "删除成功!";
    }


    /**
     * excel表格导出
     * 方法待完善
     */
    @GetMapping("/excel/export")
    public void excelExport(){
        List<Device> deviceList = deviceService.list();
        deviceList.stream().forEach(System.out::println);

    }
}
