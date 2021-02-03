package com.example.hello.shiro.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_sys_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("menu_id")
    private String menuId;

    @TableField("menu_code")
    private String menuCode;

    @TableField("menu_name")
    private String menuName;

    @TableField("parent_menu_id")
    private String parentMenuId;

    @TableField("menu_type")
    private String menuType;

    @TableField("menu_url")
    private String menuUrl;

    @TableField("show_flag")
    private String showFlag;

    @TableField("delete_flag")
    private String deleteFlag;

}
