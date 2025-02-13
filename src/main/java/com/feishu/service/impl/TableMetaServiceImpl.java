package com.feishu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feishu.entity.TableMeta;
import com.feishu.mapper.TableMetaMapper;
import com.feishu.service.TableMetaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feishu.service.dto.Fields;
import com.feishu.service.dto.TableMetaDTO;
import com.feishu.service.vo.DataVO;
import com.feishu.service.vo.TableMetaVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 表结构管理 服务实现类
 * </p>
 *
 * @author jidonglin
 * @since 2025-02-13
 */
@Service
public class TableMetaServiceImpl extends ServiceImpl<TableMetaMapper, TableMeta> implements TableMetaService {

    @Resource
    TableMetaMapper tableMetaMapper;

    @Override
    public TableMetaVO info(String timeStamp, String nonce, TableMetaDTO tableMetaDTO) {

        QueryWrapper<TableMeta> queryWrapper = new QueryWrapper<>();
        List<TableMeta> tableMetas = tableMetaMapper.selectList(queryWrapper);
        List<Fields> fieldsList = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(tableMetas)){
            for (TableMeta t : tableMetas) {
                Fields fields = new Fields();
                fields.setFieldID(String.valueOf(t.getId()));
                fields.setFieldName(t.getName());
                fields.setFieldType(t.getType());
                fields.setDescription(t.getDescription());
                fields.setIsPrimary(t.getIsPrimary());
//                fields.setProperty();
                fieldsList.add(fields);
            }
        }

        TableMetaVO tableMetaVO = new TableMetaVO();
        tableMetaVO.setCode(0);
        DataVO dataVO = new DataVO();
        dataVO.setTableName("online定时任务表");
        dataVO.setFields(fieldsList);
        tableMetaVO.setData(dataVO);
        return tableMetaVO;
    }
}
