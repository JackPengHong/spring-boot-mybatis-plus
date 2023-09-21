package com.bxl.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: 白小楼
 * @Description:
 * @Date:Create in 2023/9/6 16:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("device_info")
public class Device {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField
    private String deviceName;

    @TableField
    private String deviceIdentification;

    @TableField
    private String deviceId;

    @TableField
    private Integer status;

    @TableField
    //转换时间格式
    @JsonFormat(pattern = "yyyy-MM-dd",locale = "zh",timezone = "GMT+8")
    private Date createDate;

}
