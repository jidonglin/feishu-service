package com.feishu.service.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author jidonglin
 * @Description:
 * @date 2025/2/14  14:36
 */
@Data
public class TableRecordVO {

    @Schema(description = "0 代表成功，非 0 则是异常错误码，规定的错误码场景")
    private int code;

    /**
     * 注意：msg 的格式为 json 字符串，里面需要包含 中英文的错误信息，
     * 当发生异常时，开发者需要同时返回这两种语言的信息，这样连接器会根据用户的语言环境展示不同的错误信息
     */
    @Schema(description = "异常时，填写错误信息，会透传到 Base 表格页面显示")
    private String msg;

    @Schema(description = "数据实体")
    private DataVO data;
}
