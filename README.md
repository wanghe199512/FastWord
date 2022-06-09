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

## 写在前面

开发设计之初就以最简单快速为主，为了方便小伙伴使用，正好有时间，写一个比较详细的文档。
同时我是一个有代码洁癖的人，后续的版本在优化代码时，部分API可能会有变动，但我扔尽最大的努力向下兼容，感谢支持。
未来fastword将主攻文档相关的操作，组件中目前使用了一些第三方框架，最新版本中已经包含了word和pdf的导出，虽说重复的轮子没必要再造，但我不知道目前是否有第三方基于PDF的开源实现封装，在本组件中，word与pdf都使用同样的创建方式以及基于我个人开发一整套的数据处理方式，
方便其他人使用。废话不多说，下面进入正题



## 无效版本说明
fastword-document自0.0.33.1b-RELEASES，fastword-picture自0.0.53.1b-RELEASES后的版本为正式可用版本，之前为无效版本，请不要使用，谢谢

## 参与贡献



## 联系我
 有任何使用问题或报错请发邮箱 1280381827@qq.com 看到后我会及时回复，开源不易，感谢支持
 
 [![OSCS Status](https://www.oscs1024.com/platform/badge/wanghe199512/FastWord.svg?size=small)](https://www.oscs1024.com/project/wanghe199512/FastWord?ref=badge_small)