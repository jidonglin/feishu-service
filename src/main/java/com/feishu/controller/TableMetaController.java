package com.feishu.controller;


import com.feishu.service.TableMetaService;
import com.feishu.service.dto.TableDTO;
import com.feishu.service.vo.TableMetaVO;
import com.zyd.framework.utils.annotation.Auth;
import com.zyd.framework.utils.enums.AuthType;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 表结构管理 前端控制器
 * </p>
 *
 * @author jidonglin
 * @since 2025-02-13
 */
@RestController
@RequestMapping("/table-meta")
public class TableMetaController {

    @Autowired
    TableMetaService tableMetaService;

    @PostMapping(value = "/info")
    @Operation(summary = "表结构数据")
    @Auth(value = AuthType.NONE)
    public TableMetaVO info(@RequestHeader(name = "X-Base-Request-Timestamp", required = false)String timeStamp,
                            @RequestHeader(name = "X-Base-Request-Nonce", required = false)String nonce,
                            @RequestBody TableDTO tableDTO) {
        return tableMetaService.info(timeStamp, nonce, tableDTO);

    }
}
