package cn.fastword.picture.handler;

import cn.fastword.picture.model.DefaultEChartsDataset;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 图表数据处理器接口
 *
 * @author wanghe
 */
public interface IDatasetHandler<T> {

    T handler() throws Exception;

}
