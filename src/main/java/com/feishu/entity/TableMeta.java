package com.feishu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zyd.framework.boot.config.base.BaseEntity;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
* <p>
* 表结构管理
* </p>
*
* @author jidonglin
* @since 2025-02-13
*/
@Data
@TableName("t_table_meta")
@Schema(title = "表结构管理")
public class TableMeta extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @Schema(description = "字段名称")
    @TableField("name")
    private String name;

    @Schema(description = "字段类型")
    @TableField("type")
    private Integer type;

    @Schema(description = "是否索引列 1是 0否")
    @TableField("is_primary")
    private Boolean isPrimary;

    @Schema(description = "字段描述")
    @TableField("description")
    private String description;

    @Schema(description = "字段类型结构")
    @TableField("property")
    private String property;




}
