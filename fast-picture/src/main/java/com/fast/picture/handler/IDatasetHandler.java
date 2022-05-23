package com.fast.picture.handler;

import com.fast.picture.model.BasicDataset;
import org.jfree.data.general.Dataset;

import java.util.List;

/**
 * 图表数据处理器接口
 *
 * @author wanghe
 */
public interface IDatasetHandler {

    Dataset handler(List<? extends BasicDataset> dataSetList, Class<?> cls) throws IllegalAccessException, InstantiationException;

}
