ʹ��˵��:

����Ŀ����Eclipse,����Ŀ���е�product.sql�ļ��������ݿ���,
������Դ�ļ��е�properties�е����ݿ���Ϣ,Ȼ����Ŀ��webapps�ļ�Ŀ¼������TOMCAT��conf�����SERVER.xml�ļ���
����TOMCAT,һ��OK��.
��������, ����ϵQQ:925550944  
��Ŀʹ�õ���JDK1.8



��ĿĿ¼�ļ���
��  .classpath  ��Ŀ������Ϣ
��  .project    ��Ŀ��Ϣ
��
����.settings  ���������ļ������ʽ��Ϣ
��      org.eclipse.core.resources.prefs  
��      org.eclipse.jdt.core.prefs
��
����resource  ��Դ�ļ�
��      dbcp.properties
��      keywords.txt
��
����src
��  ����domain  
��  ��      Person.java	��Ʒʵ��
��  ��      Product.java  ��¼��¼�û�ʵ��
��  ��
��  ����MyUtils
��  ��      FilterUtils.java	����������
��  ��      ImageIOToResponseOutputStream.java	ͼƬ�������
��  ��      JDBCTemplate.java	��ģ��DBUTILS����
��  ��      MyDBUtils.java	���ݿ����ӹ���
��  ��      RandomCodeUtils.java	��֤�빤��
��  ��      StringUtils.java	�ַ�������
��  ��      TokenUtils.java	���ƹ���
��  ��
��  ����productDao
��  ��      ProductDao.java	��ƷDAO
��  ��
��  ����productDaoImpl
��  ��      ProductDaoImpl.java	��Ʒʵ����
��  ��      ReHandler.java	��ѯ�������
��  ��
��  ����query
��  ��      BaseObjectQuery.java	�߼���ѯ����
��  ��      IQuery.java		��ѯʵ�ֽӿ�
��  ��      PageList.java		��ҳ�����װ
��  ��      ProductObjectQuery.java	�߼���ѯ������װ��
��  ��
��  ����web
��      ����filter
��      ��      CharacterEncodingFilter.java	���������
��      ��      CheckLoginFilter.java		��¼Ȩ�޹���
��      ��      MessageFilter.java		��Ϣ/ �ؼ���/Υ���ʹ���
��      ��
��      ����request
��      ��      MyHttpServletRequestWapper.java    �û��������Ϣ/ �ؼ���/Υ���ʹ��� ������
��      ��
��      ����servlet
��          ��  AddServlet.java		������Ʒ������Servlet,�����ڱ���ʾ֮��
��          ��  ListProductServlet.java	��Ʒ�Ĵ���Servlet
��          ��  LogoutServlet.java	ע��Servlet
��          ��  LogServlet.java		��¼Servlet
��          ��  RandomCode.java		��֤������Servlet
��          ��
��          ����image
��                  BackgroudServlet.java	����ͼƬ����Servlet
��
����webapps
    ��  login.jsp	��¼ҳ��
    ��
    ����images	ͼƬ�ļ��ļ���
    ��      xxx.jpg	
    ��
    ����WEB-INF	
        ��  add.jsp	 ������Ʒ(��)
        ��  list.jsp	 ��Ʒ�б�
        ��  update.jsp	 ��Ʒ����
        ��  web.xml	 Tomcat�����ļ�
        ����lib
        ��      commons-dbcp2-2.2.0.jar
	��				         >>>>  DBCP��jar��
        ��      commons-pool2-2.5.0.jar 
	��      lombok.jar			��������getter/setter���߰�
        ��       
	��      commons-logging-1.2.jar		��־��¼jar
        ��      el-api.jar	----------------------------		
        ��      jsp-api.jar				   |
        ��      servlet-api.jar				   |---------------5��javaweb�������jar
        ��      taglibs-standard-impl-1.2.5.jar		   |
        ��      taglibs-standard-spec-1.2.5.jar -------------
	�� 
	��      mysql-connector-java-5.1.45-bin.jar    mysql ������
        ��
        ����views
                page.jsp   
