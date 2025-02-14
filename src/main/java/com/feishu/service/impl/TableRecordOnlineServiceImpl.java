package com.feishu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feishu.entity.TableRecordOnline;
import com.feishu.mapper.TableRecordOnlineMapper;
import com.feishu.service.TableRecordOnlineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feishu.service.dto.Records;
import com.feishu.service.dto.TableDTO;
import com.feishu.service.vo.DataRecordVO;
import com.feishu.service.vo.TableRecordVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.ZoneId;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jidonglin
 * @since 2025-02-14
 */
@Service
@Slf4j
public class TableRecordOnlineServiceImpl extends ServiceImpl<TableRecordOnlineMapper, TableRecordOnline> implements TableRecordOnlineService {

    @Resource
    TableRecordOnlineMapper tableRecordOnlineMapper;

    @Override
    public TableRecordVO info(String timeStamp, String nonce, TableDTO tableDTO) {
        log.info("入参：" + JSONObject.toJSONString(tableDTO));
        String params = tableDTO.getParams();
        JSONObject jsonObject = JSONObject.parseObject(params);
        // 获取 datasourceConfig 的值
        String datasourceConfig = jsonObject.getString("datasourceConfig");
        // 再次解析 datasourceConfig 为 JSONObject
        JSONObject datasourceConfigObject = JSONObject.parseObject(datasourceConfig);
        // 获取 systemTag 的值
        String systemTag = datasourceConfigObject.getString("systemTag");

        String transactionID = jsonObject.getString("transactionID");
        String pageToken = jsonObject.getString("pageToken");
        int maxPageSize = jsonObject.getInteger("maxPageSize");

        TableRecordVO tableRecordVO = new TableRecordVO();
        tableRecordVO.setCode(0);

        DataRecordVO dataRecordVO = new DataRecordVO();
        if (StringUtils.equals(systemTag, "online")){
            QueryWrapper<TableRecordOnline> tableRecordOnlineQueryWrapper = new QueryWrapper<>();
            Page page = null;
            if (StringUtils.isEmpty(pageToken)){
                page = Page.of(1, 10);
            }else {
                page = Page.of(Integer.parseInt(pageToken), 10);
            }
            Page<TableRecordOnline> tableRecordOnlinePage = tableRecordOnlineMapper.selectPage(page, tableRecordOnlineQueryWrapper);
            dataRecordVO.setHasMore(false);
            dataRecordVO.setNextPageToken("11");
            List<Records> recordsList = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(tableRecordOnlinePage.getRecords())){

                for (TableRecordOnline tableRecordOnline : tableRecordOnlinePage.getRecords()) {
                    Records records = new Records();
                    Map<String, Object> map = new LinkedHashMap<>();
                    records.setPrimaryID(String.valueOf(tableRecordOnline.getId()));
                    map.put("1", tableRecordOnline.getId());
                    map.put("2", tableRecordOnline.getTaskName());
                    map.put("3", tableRecordOnline.getTaskPropose());
                    map.put("4", tableRecordOnline.getTaskDeal());
                    Instant instant = tableRecordOnline.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant(); // 步骤 3: 转换为 Instant
                    long createTimeMills = instant.toEpochMilli();
                    map.put("5", createTimeMills);
                    records.setData(map);
                    recordsList.add(records);
                }
            }

            dataRecordVO.setRecords(recordsList);
        }
        tableRecordVO.setData(dataRecordVO);
        return tableRecordVO;
    }
}
