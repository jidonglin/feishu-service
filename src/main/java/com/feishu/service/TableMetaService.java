package com.feishu.service;

import com.feishu.entity.TableMeta;
import com.baomidou.mybatisplus.extension.service.IService;
import com.feishu.service.dto.TableMetaDTO;
import com.feishu.service.vo.TableMetaVO;

/**
 * <p>
 * 表结构管理 服务类
 * </p>
 *
 * @author jidonglin
 * @since 2025-02-13
 */
public interface TableMetaService extends IService<TableMeta> {

    TableMetaVO info(String timeStamp, String nonce, TableMetaDTO tableMetaDTO);
}
