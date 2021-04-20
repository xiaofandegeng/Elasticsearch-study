# Elasticsearch



## Elasticsearch概述



### Elasticsearch是什么

![Elastic Stack核心](https://github.com/xiaofandegeng/Elasticsearch-study/blob/main/图片/ElasticSearch01.png)





Elaticsearch，简称为 ES，ES 是一个**开源的高扩展的分布式全文搜索引擎，**是整个 Elastic 

Stack 技术栈的核心。它可以近乎实时的存储、检索数据；本身扩展性很好，可以扩展到上

百台服务器，处理 PB 级别的数据。



### Elasticsearch入门

#### 准备工作

##### Elasticsearch 安装

​	Elasticsearch 的官方地址：[点击这里](https://www.elastic.co/cn/)，选择对应的版本安装即可，本文使用版本为**Windows**版本

​	Windows 版的 Elasticsearch 的安装很简单，解压即安装完毕，解压后的 Elasticsearch 的

目录结构如下:

![ElasticSearch目录层级](https://github.com/xiaofandegeng/Elasticsearch-study/blob/main/图片/ElasticSearch 目录层级.png)

| 目录    | 含义           |
| ------- | -------------- |
| bin     | 可执行脚本目录 |
| config  | 配置目录       |
| jdk     | 内置jdk目录    |
| lib     | 类库           |
| logs    | 日志目录       |
| modules | 模块目录       |
| plugins | 插件目录       |

解压后，进入 bin 文件目录，点击 elasticsearch.bat 文件启动 ES 服务![Elasticsearch启动页面](https://github.com/xiaofandegeng/Elasticsearch-study/blob/main/图片/ElasticSearch启动页面.png)

**注意：*9300***端口为 **Elasticsearch** **集群间组件的通信端口，*9200* **端口为浏览器访问的 **http**

**协议** **RESTful** **端口。**

打开浏览器（推荐使用谷歌浏览器），输入地址：http://localhost:9200，测试结果![启动成页面](https://github.com/xiaofandegeng/Elasticsearch-study/blob/main/图片/ElasticSearch启动成功页面.png)

##### postman安装

​	Postman 是一款强大的网页调试工具，提供功能强大的 Web API 和 HTTP 请求调试。

​	Postman 官网：https://www.getpostman.com

​	Postman 下载：https://www.getpostman.com/apps

![potman界面](https://github.com/xiaofandegeng/Elasticsearch-study/blob/main/图片/postman页面截图.png)



##### 数据格式

​	**Elasticsearch** 是面向文档型数据库，一条数据在这里就是一个文档。为了方便大家理解，我们将 **Elasticsearch** 里存储文档数据和关系型数据库 **MySQL** 存储数据的概念进行一个类比

![对比mysql](https://github.com/xiaofandegeng/Elasticsearch-study/blob/main/图片/ElasticSearch与mysql的对比.png)

ES 里的 **Index** 可以看做一个库，而 **Types** 相当于表，**Documents** 则相当于表的行。这里 Types 的概念已经被逐渐弱化，Elasticsearch 6.X 中，一个 index 下已经只能包含一个type，Elasticsearch 7.X 中, Type 的概念已经被删除了。



​	用 JSON 作为文档序列化的格式，比如一条用户信息：

```json
{
 "name" : "John",
 "sex" : "Male",
 "age" : 25,
 "birthDate": "1990/05/01",
 "about" : "I love to go rock climbing",
 "interests": [ "sports", "music" ]
}
```

#### 正式操作

##### 索引相关

###### 创建索引

对比关系型数据库，创建索引就等同于创建数据库

在 Postman 中，向 ES 服务器发 **PUT** 请求 ：http://127.0.0.1:9200/user

![索引-创建](C:\Users\SHL\AppData\Roaming\Typora\typora-user-images\image-20210419173743055.png)

如果重复添加索引，会返回错误信息



![索引-重复创建](https://github.com/xiaofandegeng/Elasticsearch-study/blob/main/图片/ElasticSearch索引-重复创建.png)

###### 查看所有索引

​	在 Postman 中，向 ES 服务器发 **GET** 请求 ：http://127.0.0.1:9200/_cat/indices?v

​	这里请求路径中的_cat 表示查看的意思，indices 表示索引，所以整体含义就是查看当前 ES服务器中的所有索引，就好像 MySQL 中的 show tables 的感觉，服务器响应结果如下

![索引-查看所有的索引](https://github.com/xiaofandegeng/Elasticsearch-study/blob/main/图片/ElasticSearch索引-查看所有的索引.png)

| 表头           | 含义                                                         |
| -------------- | ------------------------------------------------------------ |
| health         | 当前服务器健康状态：**green**(集群完整) **yellow**(单点正常、集群不完整) **red**(单点不正常) |
| status         | 索引打开、关闭状态                                           |
| index          | 索引名                                                       |
| uuid           | 索引唯一编号                                                 |
| pri            | 主分片数量                                                   |
| rep            | 副本数量                                                     |
| docs.count     | 可用文档数量                                                 |
| docs.deleted   | 文档删除状态（逻辑删除）                                     |
| store.size     | 主分片和副分片整体占空间大小                                 |
| pri.store.size | 主分片占空间大小                                             |

###### 查看单个索引

​	在 Postman 中，向 ES 服务器发 **GET** 请求 ：http://127.0.0.1:9200/user

​	查看索引向 ES 服务器发送的请求路径和创建索引是一致的。但是 HTTP 方法不一致。这里可以体会一下 RESTful 的意义，

​	请求后，服务器响应结果如下：

![索引-查看指定的索引](https://github.com/xiaofandegeng/Elasticsearch-study/blob/main/图片/ElasticSearch索引-查看指定的索引.png)

```json
{
  "user"【索引名】: { 
  	"aliases"【别名】: {},
  	"mappings"【映射】: {},
 	"settings"【设置】: {
 		"index"【设置 - 索引】: {
 			"creation_date"【设置 - 索引 - 创建时间】: "1618824974626",
 			"number_of_shards"【设置 - 索引 - 主分片数量】: "1",
 			"number_of_replicas"【设置 - 索引 - 副分片数量】: "1",
 			"uuid"【设置 - 索引 - 唯一标识】: "F9Sea1LdS12QslCzkH1iWQ",
 			"version"【设置 - 索引 - 版本】: {
 				"created": "7080099"
 			},
 			"provided_name"【设置 - 索引 - 名称】: "user"
 		}
 	}
 } 
}
```

###### 删除索引

​	在 Postman 中，向 ES 服务器发 **DELETE** 请求 ：http://127.0.0.1:9200/user

![索引-删除指定的索引](https://github.com/xiaofandegeng/Elasticsearch-study/blob/main/图片/ElasticSearch索引-删除指定索引.png)

##### 文档相关

###### 创建文档

​	索引已经创建好了，接下来我们来创建文档，并添加数据。这里的文档可以类比为关系型数据库中的表数据，添加的数据格式为 JSON 格式

​	在 Postman 中，向 ES 服务器发 **POST** 请求 ：http://127.0.0.1:9200/user/_doc

​	请求体内容为：

```json
{
 "id":"111111",
 "name":"老王",
 "age":25,
 "phone":1511111111
}
```

![文档-创建文档](https://github.com/xiaofandegeng/Elasticsearch-study/blob/main/图片/ElasticSearch文档-创建文档.png)

​	此处发送请求的方式必须为 **POST**，不能是 **PUT**，否则会发生错误



​	上面的数据创建后，由于没有指定数据唯一性标识（ID），默认情况下，ES 服务器会随机生成一个。

​	如果想要自定义唯一性标识，需要在创建时指定：http://127.0.0.1:9200/user/_doc/**1**

![文档-自定义id创建文档](https://github.com/xiaofandegeng/Elasticsearch-study/blob/main/图片/ElasticSearch文档-自定义id创建文档.png)

###### 查看文档

​	查看文档时，需要指明文档的唯一性标识，类似于 MySQL 中数据的主键查询

​	在 Postman 中，向 ES 服务器发 **GET** 请求 ：http://127.0.0.1:9200/user/_doc/1

![文档-根据id查询文档](https://github.com/xiaofandegeng/Elasticsearch-study/blob/main/图片/ElasticSearch文档-根据id查询文档.png)

###### **修改文档**

​	和新增文档一样，输入相同的 URL 地址请求，如果请求体变化，会将原有的数据内容覆盖。

​	在 Postman 中，向 ES 服务器发 **POST** 请求 ：http://127.0.0.1:9200/user/_doc/1

请求体内容为: 

```json
{
 "id":"2222",
 "name":"小李",
 "age":18,
 "phone":15222222222
}
```

​	修改成功后，服务器响应结果：

![文档-全局修改](https://github.com/xiaofandegeng/Elasticsearch-study/blob/main/图片/ElasticSearch文档-全局修改.png)

######    修改字段

​	修改数据时，也可以只修改某一给条数据的局部信息

​	在 Postman 中，向 ES 服务器发 **POST** 请求 ：http://127.0.0.1:9200/user/**_update/1**

​	请求体内容为：

```json
{ 
 "doc": {
 "name":"华仔"
 } 
}
```

​	修改成功后，服务器响应结果：

![文档-局部修改](https://github.com/xiaofandegeng/Elasticsearch-study/blob/main/图片/ElasticSearch文档-局部修改.png)

​	根据唯一性标识，查询文档数据，文档数据已经更新

![文档-根据id查询文档2](https://github.com/xiaofandegeng/Elasticsearch-study/blob/main/图片/ElasticSearch文档-根据id查询文档2.png)

###### **删除文档**

​	删除一个文档不会立即从磁盘上移除，它只是被标记成已删除（逻辑删除）。

​	在 Postman 中，向 ES 服务器发 **DELETE** 请求 ：http://127.0.0.1:9200/user**/_doc/1**

​	删除成功，服务器响应结果：

![文档-根据id删除文档](https://github.com/xiaofandegeng/Elasticsearch-study/blob/main/图片/ElasticSearch文档-根据id删除文档.png)

​	删除后再查询当前文档信息

![文档-根据id删除文档再查询](https://github.com/xiaofandegeng/Elasticsearch-study/blob/main/图片/ElasticSearch文档-根据id删除文档再查询.png)

###### **条件删除文档**

​	一般删除数据都是根据文档的唯一性标识进行删除，实际操作时，也可以根据条件对多条数据进行删除

​	首先分别增加多条数据: 

```json
{
    "id": "222222",
    "name": "小李",
    "age": 18,
    "phone": 1522222222
}
{
    "id": "333333",
    "name": "华仔",
    "age": 35,
    "phone": 1533333333
}
{
    "id": "444444",
    "name": "星爷",
    "age": 25,
    "phone": 1544444444
}
```

​	向 ES 服务器发 **POST** 请求 ：http://127.0.0.1:9200/user/_delete_by_query

```json
{
    "query":{
        "match":{
            "age":18
        }
    }
}
```

#####  **高级查询**

