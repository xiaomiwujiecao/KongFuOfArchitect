时区有好几种表示方式。

- 一种是以GMT或者UTC加时区偏移表示，

例如：GMT+08:00或者UTC+08:00表示东八区。

- 另一种是缩写，

例如，CST表示 `China Standard Time` ，也就是中国标准时间。但是CST也可以表示美国中部时间`Central Standard Time USA`，因此，缩写容易产生混淆，我们尽量不要使用缩写。


最后一种是以洲／城市表示，

例如，Asia/Shanghai，表示上海所在地的时区。

特别注意城市名称不是任意的城市，而是由国际标准组织规定的城市。

因为时区的存在，东八区的2019年11月20日早上8:15，和西五区的2019年11月19日晚上19:15，他们的时刻是相同的：


## 夏令时

时区还不是最复杂的，更复杂的是夏令时。所谓夏令时，就是夏天开始的时候，把时间往后拨1小时，夏天结束的时候，再把时间往前拨1小时。我们国家实行过一段时间夏令时，1992年就废除了，但是矫情的美国人到现在还在使用，所以时间换算更加复杂。

计算夏令时请使用标准库提供的相关类，不要试图自己计算夏令时。

## 本地化

在计算机中，通常使用Locale表示一个国家或地区的日期、时间、数字、货币等格式。Locale由语言_国家的字母缩写构成，例如，zh_CN表示中文+中国，en_US表示英文+美国。语言使用小写，国家使用大写。

对于日期来说，不同的Locale，例如，中国和美国的表示方式如下：

- zh_CN：2016-11-30
- en_US：11/30/2016