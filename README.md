# FastWord

## 组件介绍
##### 1.为什么会出现fast-word？

文档的导入导出，不管是在ERP，SASS或者诸如一切的其他管理系统，都是必不可少的，而在我实际开发的过程中涉及到的Word是比较多的，我在网上查阅了很多资料，关于Word导出几乎都是模板替换的方式，在word xml中打标签无疑是一件痛苦的事情。于是fast-word应运而生，我给它起名叫“ fast-word”旨在快速，易用，高效的解决我们的问题，节省我们宝贵的时间。

##### 2.fast-word的优势在哪里？

相对于原生poi，我们更简单，同时支持了通过数据生成图片。相对于打标签模板替换的方式，我们更高效，fast-word可以让您只关注业务，您给我们业务数据，只需要三步我们帮您实现从0到1的word生成  快速上手 ，其中包含了图表绘制，表格绘制，文本添加，导出word四大模块。

##### 3.fast-word当前版本是什么？

fastword主程序版本：1.0.5-RELEASES,以下为最新子版本对应关系

| fastword-picture | fastword-annotation | fastword-document |
| ------ | ------ | ------ |
| 0.0.54 | 0.0.1.3 | 0.0.56 |


##使用示例

1.  创建图片
````
private void createPictureExample() throws Exception {
     List<DefaultDataset> list = new ArrayList<>();
     DefaultDataset defaultDataSet = new DefaultDataset("测试",Arrays.asList(new Integer[]{2000, 3444, 4000}), Arrays.asList(new String[]{"清华大学", "北京大学", "山西大学"}));
     list.add(defaultDataSet);
     File file = new DrawBasicLinePicture("各大学人数排序", "学校", "人数") .addDefaultDataSet(list, new DefaultDatasetHandler()).saveAsPNG("d://aa/图片", Report.基础日报);
   }
````
DefaultXYDataset是适用于有x，y轴数据的图表实体（如折线，柱状），需要显式创建，默认构造如下（其他使用请参照PictureTest下示例）：
````
 DefaultXYDataset defaultDataSet = new DefaultXYDataset("折线图", Arrays.asList(new Integer[]{2, 3, 4}), 
                Arrays.asList(new String[]{"水果", "蔬菜", "鸡蛋"}));
````

2.  创建表格
````
private TableBeans getTableBeans() {
      List<List<String>> childBeans = new ArrayList<>();
      childBeans.add(Arrays.asList(new String[]{"张三", "男", "27", "山西大同"}));
      TableBeans bean = new TableBeans(Arrays.asList(new String[]{"姓名", "性别", "年龄", "地址"}), childBeans);
      return bean;
  }
````
3.  导出word文件
````
String docuemntFile = writer.getDocumentFile("动态分析报告","d://aa"); // 返回值为文档所在存储完整路径
````
具体实现如下：
````
 WordFile07Writer writer = new WordFile07Writer();
 writer.addParagraphTableRows(new DefaultTableBeansHandler(this.getTableBeans()), "1、测试标题1");  //TODO 同时添加表格及文本
 writer.addParagraphRows("测试文本")  //TODO 单行文本
 writer.addPicture(new File("D:\\RailReport\\铁科院日报\\2022-05-08\\京广\\上\\2.png")  //TODO 图片及文本
 writer.addParagraphPictureRows(new File("D:\\RailReport\\铁科院日报\\2022-05-08\\京广\\上\\2.png"), "2、测试标题2"); //TODO 同时添加图片及文本
````
更多示例请参阅API
#### 使用说明
该项目已发布到中央仓库

目前支持折线图,柱状图,散点图，饼图绘制，后续版本会不断优化并添加新的受支持的图表
1.构建maven
````
<dependency>
            <groupId>cn.fastword</groupId>
            <artifactId>fastword-document</artifactId>
            <version>0.0.33.1b-RELEASES</version>
        </dependency>
        <dependency>
            <groupId>cn.fastword</groupId>
            <artifactId>fastword-picture</artifactId>
            <version>0.0.53.1b-RELEASES</version>
        </dependency>
````
1.fastword-document为创建word核心jar，包含了常用word添加元素及操作

2.fastword-picture 提供了一系列创建图表的工作 可独立使用

每种都有对应的示例，在gitee源码包中test目录下，您可以在构建完成之后，直接运行即可看到效果，注意：运行临时生成文件路径在D盘




## 无效版本说明
fastword-document自0.0.33.1b-RELEASES，fastword-picture自0.0.53.1b-RELEASES后的版本为正式可用版本，之前为无效版本，请不要使用，谢谢

## 参与贡献



## 联系我
 有任何使用问题或报错请发邮箱 1280381827@qq.com 看到后我会及时回复，开源不易，感谢支持
 
 [![OSCS Status](https://www.oscs1024.com/platform/badge/wanghe199512/FastWord.svg?size=small)](https://www.oscs1024.com/project/wanghe199512/FastWord?ref=badge_small)