package com.software.picture.handler;

import com.software.picture.model.BasicDataset;
import org.jfree.data.general.Dataset;

import java.util.List;

public interface IDatasetHandler {

    Dataset addDefaultDataSet(List<? extends BasicDataset> dataSetList);
}
