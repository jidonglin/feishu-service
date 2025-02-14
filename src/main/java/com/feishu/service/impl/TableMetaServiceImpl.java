package com.feishu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.feishu.entity.TableMeta;
import com.feishu.mapper.TableMetaMapper;
import com.feishu.service.TableMetaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feishu.service.dto.Fields;
import com.feishu.service.dto.TableDTO;
import com.feishu.service.vo.DataVO;
import com.feishu.service.vo.TableMetaVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
@Slf4j
public class TableMetaServiceImpl extends ServiceImpl<TableMetaMapper, TableMeta> implements TableMetaService {

    @Resource
    TableMetaMapper tableMetaMapper;

    @Override
    public TableMetaVO info(String timeStamp, String nonce, TableDTO tableDTO) {
        log.info("入参：" + JSONObject.toJSONString(tableDTO));
        String params = tableDTO.getParams();
        JSONObject jsonObject = JSONObject.parseObject(params);
        // 获取 datasourceConfig 的值
        String datasourceConfig = jsonObject.getString("datasourceConfig");
        // 再次解析 datasourceConfig 为 JSONObject
        JSONObject datasourceConfigObject = JSONObject.parseObject(datasourceConfig);
        // 获取 systemTag 的值
        String systemTag = datasourceConfigObject.getString("systemTag");
        QueryWrapper<TableMeta> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotEmpty(systemTag), "system_tag", systemTag);
        List<TableMeta> tableMetas = tableMetaMapper.selectList(queryWrapper);
        List<Fields> fieldsList = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(tableMetas)){
            for (TableMeta t : tableMetas) {
                Fields fields = new Fields();
                fields.setFieldID(t.getFieldId());
                fields.setFieldName(t.getFieldName());
                fields.setFieldType(t.getFieldType());
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
