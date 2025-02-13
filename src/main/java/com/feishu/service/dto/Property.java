package com.feishu.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author jidonglin
 * @Description:
 * @date 2025/2/13  15:35
 */
@Data
@Schema(title = "字段类型")
public class Property {

    private String formatter;

    private String currencyCode;

    private Integer min;

    private Integer max;

    private Integer color;

    private String symbol;

}
