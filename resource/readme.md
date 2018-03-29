使用说明:

将项目导入Eclipse,将项目包中的product.sql文件导入数据库中,
配置资源文件中的properties中的数据库信息,然后将项目的webapps文件目录配置在TOMCAT的conf下面的SERVER.xml文件中
启动TOMCAT,一切OK了.
如有疑问, 请联系QQ:925550944  
项目使用的是JDK1.8



项目目录文件树
│  .classpath  项目编译信息
│  .project    项目信息
│
├─.settings  编译器和文件编码格式信息
│      org.eclipse.core.resources.prefs  
│      org.eclipse.jdt.core.prefs
│
├─resource  资源文件
│      dbcp.properties
│      keywords.txt
│
├─src
│  ├─domain  
│  │      Person.java	商品实体
│  │      Product.java  登录登录用户实体
│  │
│  ├─MyUtils
│  │      FilterUtils.java	过滤器工具
│  │      ImageIOToResponseOutputStream.java	图片输出工具
│  │      JDBCTemplate.java	简单模拟DBUTILS工具
│  │      MyDBUtils.java	数据库连接工具
│  │      RandomCodeUtils.java	验证码工具
│  │      StringUtils.java	字符串工具
│  │      TokenUtils.java	令牌工具
│  │
│  ├─productDao
│  │      ProductDao.java	商品DAO
│  │
│  ├─productDaoImpl
│  │      ProductDaoImpl.java	商品实现类
│  │      ReHandler.java	查询结果处理集
│  │
│  ├─query
│  │      BaseObjectQuery.java	高级查询基类
│  │      IQuery.java		查询实现接口
│  │      PageList.java		分页对象封装
│  │      ProductObjectQuery.java	高级查询条件封装类
│  │
│  └─web
│      ├─filter
│      │      CharacterEncodingFilter.java	编码过滤器
│      │      CheckLoginFilter.java		登录权限过滤
│      │      MessageFilter.java		消息/ 关键字/违禁词过滤
│      │
│      ├─request
│      │      MyHttpServletRequestWapper.java    用户请求的消息/ 关键字/违禁词过滤 处理类
│      │
│      └─servlet
│          │  AddServlet.java		增加商品的令牌Servlet,产生于表单显示之间
│          │  ListProductServlet.java	商品的处理Servlet
│          │  LogoutServlet.java	注销Servlet
│          │  LogServlet.java		登录Servlet
│          │  RandomCode.java		验证码生成Servlet
│          │
│          └─image
│                  BackgroudServlet.java	背题图片产生Servlet
│
└─webapps
    │  login.jsp	登录页面
    │
    ├─images	图片文件文件夹
    │      xxx.jpg	
    │
    └─WEB-INF	
        │  add.jsp	 增加商品(表单)
        │  list.jsp	 商品列表
        │  update.jsp	 商品更改
        │  web.xml	 Tomcat配置文件
        ├─lib
        │      commons-dbcp2-2.2.0.jar
	│				         >>>>  DBCP的jar包
        │      commons-pool2-2.5.0.jar 
	│      lombok.jar			快速生成getter/setter工具包
        │       
	│      commons-logging-1.2.jar		日志记录jar
        │      el-api.jar	----------------------------		
        │      jsp-api.jar				   |
        │      servlet-api.jar				   |---------------5个javaweb最基础的jar
        │      taglibs-standard-impl-1.2.5.jar		   |
        │      taglibs-standard-spec-1.2.5.jar -------------
	│ 
	│      mysql-connector-java-5.1.45-bin.jar    mysql 驱动包
        │
        └─views
                page.jsp   
