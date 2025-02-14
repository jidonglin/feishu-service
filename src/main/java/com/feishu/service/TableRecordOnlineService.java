package com.feishu.service;

import com.feishu.entity.TableRecordOnline;
import com.baomidou.mybatisplus.extension.service.IService;
import com.feishu.service.dto.TableDTO;
import com.feishu.service.vo.TableRecordVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jidonglin
 * @since 2025-02-14
 */
public interface TableRecordOnlineService extends IService<TableRecordOnline> {

    TableRecordVO info(String timeStamp, String nonce, TableDTO tableDTO);
}
