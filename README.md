# FastWord

#### 介绍
无需任何XML模板，通过几步即可生成包含图片及表格的Word文件

#### 软件架构
软件架构说明
无


#### 使用示例

1.  创建图片
````
private void createPictureExample() throws Exception {
     List<DefaultDataset> list = new ArrayList<>();
     DefaultDataset defaultDataSet = new DefaultDataset("测试",Arrays.asList(new Integer[]{2000, 3444, 4000}), Arrays.asList(new String[]{"清华大学", "北京大学", "山西大学"}));
     list.add(defaultDataSet);
     File file = new DrawBasicLinePicture("各大学人数排序", "学校", "人数") .addDefaultDataSet(list, new DefaultDatasetHandler()).saveAsPNG("d://aa/图片", Report.基础日报);
   }
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
new DiseaseReport().getWord2007("动态分析报告","d://aa");
````
其中DiseaseReport对象 extends自 AbstractIBasicWord，覆盖reportWriter()方法，如下添加：
````
this.addParagraphTableRows(new DefaultTableBeansHandler(this.getTableBeans()), "1、测试标题1");  //TODO 同时添加表格及文本
this.addParagraphRows("测试文本")  //TODO 单行文本
this.addPicture(new File("D:\\RailReport\\铁科院日报\\2022-05-08\\京广\\上\\2.png")  //TODO 图片及文本
this.addParagraphPictureRows(new File("D:\\RailReport\\铁科院日报\\2022-05-08\\京广\\上\\2.png"), "2、测试标题2"); //TODO 同时添加图片及文本
````
更多示例请参阅API
#### 使用说明

目前支持折线图及柱状图绘制，后续版本会不断优化并添加新的受支持的图表

1.  关于创建table，默认使用DefaultTableBeansHandler，如根据业务自定义请继承相应接口并实现对应方法
2.  关于图片生成 前缀均以DrawBasic开头,例如: DrawBasicLinePicture ，如我们提供的图表不受支持，自定义其他图表需继承AbstractDrawBasicPicture
3.  此开源插件暂未上架中央仓库，可以使用nexus私有仓库进行管理，上不上取决于使用的人数多少，如果对您有帮助，请点个star吧

#### 参与贡献

#### 联系我
 有任何使用问题或报错请发邮箱 1280381827@qq.com 看到后我会及时回复，开源不易，感谢支持