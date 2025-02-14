package com.feishu.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Map;

/**
 * @author jidonglin
 * @Description:
 * @date 2025/2/14  14:20
 */
@Data
public class Records {

    @Schema(description = "主键 id，在同步表中能唯一标识一条记录")
    private String primaryID;

    @Schema(description = "记录数据， key 为对应的 fieldID，value 根据 field type 确定")
    private Map data;
}
