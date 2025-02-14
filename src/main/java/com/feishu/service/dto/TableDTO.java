package com.feishu.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author jidonglin
 * @Description:
 * @date 2025/2/13  14:29
 */
@Data
public class TableDTO {

    @Schema(description = "查询参数，值为 json 字符串，结构：" +
            "{" +
            "datasourceConfig: string // 用户在数据源配置页面选择的配置信息，也就是前端调用前端sdk bitable.saveConfigAndGoNext(configData: Record<string, any>)保存的信息，" +
            "值由开发者定义，服务端在请求插件服务接口时透传" +
            "}")
    @NotEmpty(message = "查询参数不能为空")
    private String params;

    @Schema(description = "- 系统参数，值为 json 字符串，结构：{\n" +
            "    bitable: {" +
            "        token: string; //  Base token\n" +
            "        logID: string; // 请求日志 id\n" +
            "    }," +
            "    packID: string;\n" +
            "    fieldType: string， // 插件类型： script、plugin\n" +
            "    tenantKey: string, // 租户标识\n" +
            "    userTenantKey: string; // 用户所属租户的租户标识\n" +
            "    bizInstanceID: string // 插件业务实例ID, 当值为0时，代表在还没有创建的情况下请求 表结构接口\n" +
            "    scriptArgs: {\n" +
            "        projectURL: string\n" +
            "        baseOpenID: string, // 用户身份标识，也就是通过前端sdk bitable.getUserId()拿到的id\n" +
            "   }" )
    @NotEmpty(message = "系统参数不能为空")
    private String context;

}
