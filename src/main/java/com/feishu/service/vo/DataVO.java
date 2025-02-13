package com.feishu.service.vo;

import com.feishu.entity.TableMeta;
import com.feishu.service.dto.Fields;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;


/**
 * @author jidonglin
 * @Description:
 * @date 2025/2/13  14:55
 */
@Data
public class DataVO {

    @Schema(description = "表名")
    private String tableName;

    @Schema(description = "表结构")
    private List<Fields> fields;
}
