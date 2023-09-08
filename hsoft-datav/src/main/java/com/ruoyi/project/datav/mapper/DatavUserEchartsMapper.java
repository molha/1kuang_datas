package com.ruoyi.project.datav.mapper;

import java.util.List;
import com.ruoyi.project.datav.domain.DatavUserEcharts;

public interface DatavUserEchartsMapper {
    /**
     * 查询用户收藏echarts素材关联
     *
     * @param id 用户收藏echarts素材关联ID
     * @return 用户收藏echarts素材关联
     */
    public DatavUserEcharts selectDatavUserEchartsById(Long id);

    /**
     * 查询用户收藏echarts素材关联列表
     *
     * @param datavUserEcharts 用户收藏echarts素材关联
     * @return 用户收藏echarts素材关联集合
     */
    public List<DatavUserEcharts> selectDatavUserEchartsList(DatavUserEcharts datavUserEcharts);

    /**
     * 新增用户收藏echarts素材关联
     *
     * @param datavUserEcharts 用户收藏echarts素材关联
     * @return 结果
     */
    public int insertDatavUserEcharts(DatavUserEcharts datavUserEcharts);

    /**
     * 修改用户收藏echarts素材关联
     *
     * @param datavUserEcharts 用户收藏echarts素材关联
     * @return 结果
     */
    public int updateDatavUserEcharts(DatavUserEcharts datavUserEcharts);

    /**
     * 删除用户收藏echarts素材关联
     *
     * @param id 用户收藏echarts素材关联ID
     * @return 结果
     */
    public int deleteDatavUserEchartsById(Long id);

    /**
     * 批量删除用户收藏echarts素材关联
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDatavUserEchartsByIds(Long[] ids);

    /**
     * 删除用户收藏
     * @param datavUserEcharts
     * @return
     */
    int delDatavUserEcharts(DatavUserEcharts datavUserEcharts);
}