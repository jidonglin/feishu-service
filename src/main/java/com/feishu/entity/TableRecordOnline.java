package com.feishu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zyd.framework.boot.config.base.BaseEntity;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
* <p>
* 
* </p>
*
* @author jidonglin
* @since 2025-02-14
*/
@Data
@TableName("t_table_record_online")
@Schema(title = "")
public class TableRecordOnline extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @Schema(description = "任务名称")
    @TableField("task_name")
    private String taskName;

    @Schema(description = "提出人")
    @TableField("task_propose")
    private String taskPropose;

    @Schema(description = "处理人")
    @TableField("task_deal")
    private String taskDeal;




}
