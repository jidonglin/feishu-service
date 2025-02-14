package com.feishu.service.vo;

import com.feishu.service.dto.Fields;
import com.feishu.service.dto.Records;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;


/**
 * @author jidonglin
 * @Description:
 * @date 2025/2/14  14:55
 */
@Data
public class DataRecordVO {

    @Schema(description = "下一页 token")
    private String nextPageToken;

    @Schema(description = "是否还有下一页")
    private Boolean hasMore;

    @Schema(description = "对象数组，记录列表，每一条数据会作为 Base 表的一条记录")
    private List<Records> records;
}
