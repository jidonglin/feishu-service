package com.feishu.controller;


import com.feishu.service.TableRecordOnlineService;
import com.feishu.service.dto.TableDTO;
import com.feishu.service.vo.TableMetaVO;
import com.feishu.service.vo.TableRecordVO;
import com.zyd.framework.utils.annotation.Auth;
import com.zyd.framework.utils.enums.AuthType;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jidonglin
 * @since 2025-02-14
 */
@RestController
@RequestMapping("/table-record")
public class TableRecordOnlineController {

    @Autowired
    TableRecordOnlineService tableRecordOnlineService;

    @PostMapping(value = "/info")
    @Operation(summary = "表记录数据")
    @Auth(value = AuthType.NONE)
    public TableRecordVO info(@RequestHeader(name = "X-Base-Request-Timestamp", required = false)String timeStamp,
                              @RequestHeader(name = "X-Base-Request-Nonce", required = false)String nonce,
                              @RequestBody TableDTO tableDTO) {
        return tableRecordOnlineService.info(timeStamp, nonce, tableDTO);

    }
}
