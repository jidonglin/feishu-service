package com.feishu.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author jidonglin
 * @Description:
 * @date 2025/2/13  15:33
 */
@Data
@Schema(title = "字段")
public class Fields {

    private String fieldID;

    private String fieldName;

    private Integer fieldType;

    private Boolean isPrimary;

    private String description;

    private Property property;
}
