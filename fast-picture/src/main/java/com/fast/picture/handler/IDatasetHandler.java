package com.fast.picture.handler;

import com.fast.picture.model.BasicDataset;
import org.jfree.data.general.Dataset;

import java.util.List;

public interface IDatasetHandler {

    Dataset addDefaultDataSet(List<? extends BasicDataset> dataSetList);
}
