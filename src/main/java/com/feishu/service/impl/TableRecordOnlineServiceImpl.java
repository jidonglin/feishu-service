package com.feishu.service.impl;

import com.feishu.entity.TableRecordOnline;
import com.feishu.mapper.TableRecordOnlineMapper;
import com.feishu.service.TableRecordOnlineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feishu.service.dto.TableDTO;
import com.feishu.service.vo.TableRecordVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jidonglin
 * @since 2025-02-14
 */
@Service
public class TableRecordOnlineServiceImpl extends ServiceImpl<TableRecordOnlineMapper, TableRecordOnline> implements TableRecordOnlineService {

    @Resource
    TableRecordOnlineMapper tableRecordOnlineMapper;

    @Override
    public TableRecordVO info(String timeStamp, String nonce, TableDTO tableDTO) {
        return null;
    }
}
