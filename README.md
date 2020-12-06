# spring-course
Spring-course学习笔记

spring的第一个核心功能 ioc

IoC (Inversion of Control) : 控制反转， 是一个理论，概念，思想。
 描述的：把对象的创建，赋值，管理工作都交给代码之外的容器实现， 也就是对象的创建是有其它外部资源完成。

控制： 创建对象，对象的属性赋值，对象之间的关系管理。
反转： 把原来的开发人员管理，创建对象的权限转移给代码之外的容器实现。 由容器代替开发人员管理对象。创建对象，
        给属性赋值。

正转：由开发人员在代码中，使用new 构造方法创建对象， 开发人员主动管理对象。
       public static void main(String args[]){
            Student student = new Student(); // 在代码中， 创建对象。--正转。

		 }

容器：是一个服务器软件， 一个框架（spring）

为什么要使用 ioc ： 目的就是减少对代码的改动， 也能实现不同的功能。 实现解耦合。 

java中创建对象有哪些方式：
  1. 构造方法 ， new Student（）
  2. 反射
  3. 序列化
  4. 克隆
  5. ioc ：容器创建对象
  6. 动态代理


ioc的体现： 
   servlet  1： 创建类继承HttpServelt 
	         2:  在web.xml 注册servlet ， 使用<servlet-name> myservlet </servlet-name>
				                                 <servelt-class>com.bjpwernode.controller.MyServlet1</servlet-class>

            3. 没有创建 Servlet对象， 没有 MyServlet myservlet = new MyServlet()

				4. Servlet 是Tomcat服务器它能你创建的。 Tomcat也称为容器
				   Tomcat作为容器：里面存放的有Servlet对象， Listener ， Filter对象


IoC的技术实现 ， 
  DI 是ioc的技术实现，  
  DI（Dependency Injection） :依赖注入， 只需要在程序中提供要使用的对象名称就可以， 至于对象如何在容器中创建，
                              赋值，查找都由容器内部实现。

spring是使用的di实现了ioc的功能， spring底层创建对象，使用的是反射机制。

spring是一个容器，管理对象，给属性赋值， 底层是反射创建对象。



spring-conetxt 和 spring-webmvc是spring中的两个模块

spring-context：是ioc功能的，创建对象的。
spring-webmvc做web开发使用的， 是servlet的升级。 
spring-webmvc中也会用到spring-context中创建对象的功能的。


junit : 单元测试， 一个工具类库，做测试方法使用的。
  单元：指定的是方法， 一个类中有很多方法，一个方法称为单元。

  使用单元测试
   1.需要加入junit依赖。
	  <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>

  2.创建测试作用的类：叫做测试类
    src/test/java目录中创建类

  3.创建测试方法

    1）public 方法
	 2）没有返回值 void 
	 3）方法名称自定义，建议名称是test + 你要测试方法名称
	 4）方法没有参数
	 5）方法的上面加入 @Test ,这样的方法是可以单独执行的。 不用使用main方法。

---------------------------------------------------------------------------------------------

1. 多个配置优势
  1.每个文件的大小比一个文件要小很多。效率高
  2.避免多人竞争带来的冲突。

  如果你的项目有多个模块（相关的功能在一起） ，一个模块一个配置文件。
  学生考勤模块一个配置文件，  张三
  学生成绩一个配置文件，      李四

  多文件的分配方式：
  1. 按功能模块，一个模块一个配置文件
  2. 按类的功能，数据库相关的配置一个文件配置文件， 做事务的功能一个配置文件， 做service功能的一个配置文件等


2.基于注解的di： 通过注解完成java对象创建，属性赋值。
  使用注解的步骤：
   1.加入maven的依赖 spring-context ，在你加入spring-context的同时， 间接加入spring-aop的依赖。
	  使用注解必须使用spring-aop依赖
	
	2.在类中加入spring的注解（多个不同功能的注解）

	3.在spring的配置文件中，加入一个组件扫描器的标签，说明注解在你的项目中的位置

   学习的注解：
	 1.@Component
	 2.@Respotory
	 3.@Service
	 4.@Controller
	 5.@Value
	 6.@Autowired
	 7.@Resource

用户处理请求：
   用户form ,参数name ，age-----Servlet(接收请求name，age)---Service类（处理name，age操作）---dao类（访问数据库的）---mysql


==============================================================================================
第三章 aop面向切面编程

1.动态代理
  实现方式：jdk动态代理，使用jdk中的Proxy，Method，InvocaitonHanderl创建代理对象。
             jdk动态代理要求目标类必须实现接口

  cglib动态代理：第三方的工具库，创建代理对象，原理是继承。 通过继承目标类，创建子类。
             子类就是代理对象。 要求目标类不能是final的， 方法也不能是final的

2.动态代理的作用：
   1）在目标类源代码不改变的情况下，增加功能。
	2）减少代码的重复
	3）专注业务逻辑代码
	4）解耦合，让你的业务功能和日志，事务非业务功能分离。

3.Aop:面向切面编程， 基于动态代理的，可以使用jdk，cglib两种代理方式。
  Aop就是动态代理的规范化， 把动态代理的实现步骤，方式都定义好了， 
  让开发人员用一种统一的方式，使用动态代理。

4. AOP（Aspect Orient Programming）面向切面编程
  Aspect: 切面，给你的目标类增加的功能，就是切面。 像上面用的日志，事务都是切面。
          切面的特点： 一般都是非业务方法，独立使用的。
  Orient：面向， 对着。
  Programming：编程

  oop: 面向对象编程

  怎么理解面向切面编程 ？ 
   1）需要在分析项目功能时，找出切面。
	2）合理的安排切面的执行时间（在目标方法前， 还是目标方法后）
	3）合理的安全切面执行的位置，在哪个类，哪个方法增加增强功能

  术语：
   1）Aspect:切面，表示增强的功能， 就是一堆代码，完成某个一个功能。非业务功能，
	          常见的切面功能有日志， 事务， 统计信息， 参数检查， 权限验证。

   2）JoinPoint:连接点 ，连接业务方法和切面的位置。 就某类中的业务方法
	3）Pointcut : 切入点 ，指多个连接点方法的集合。多个方法
	4）目标对象： 给哪个类的方法增加功能， 这个类就是目标对象
	5）Advice:通知，通知表示切面功能执行的时间。

	说一个切面有三个关键的要素：
	1）切面的功能代码，切面干什么
	2）切面的执行位置，使用Pointcut表示切面执行的位置
	3）切面的执行时间，使用Advice表示时间，在目标方法之前，还是目标方法之后。

 5.aop的实现
   aop是一个规范，是动态的一个规范化，一个标准
	aop的技术实现框架：
	1.spring：spring在内部实现了aop规范，能做aop的工作。
	          spring主要在事务处理时使用aop。
				 我们项目开发中很少使用spring的aop实现。 因为spring的aop比较笨重。


   2.aspectJ: 一个开源的专门做aop的框架。spring框架中集成了aspectj框架，通过spring就能使用aspectj的功能。
	  aspectJ框架实现aop有两种方式：
	   1.使用xml的配置文件 ： 配置全局事务
		2.使用注解，我们在项目中要做aop功能，一般都使用注解， aspectj有5个注解。


 6.学习aspectj框架的使用。 
   1）切面的执行时间， 这个执行时间在规范中叫做Advice(通知，增强)
	   在aspectj框架中使用注解表示的。也可以使用xml配置文件中的标签
		1）@Before
		2）@AfterReturning
		3）@Around
		4）@AfterThrowing
		5）@After

   2）表示切面执行的位置，使用的是切入点表达式。

		com.service.impl
		com.bjpowrnode.service.impl
		cn.crm.bjpowernode.service


      execution(* *..service.*.*(..))


====================================================================
第四章： 把mybatis框架和spring集成在一起，向一个框架一样使用。

用的技术是：ioc 。
为什么ioc：能把mybatis和spring集成在一起，像一个框架， 是因为ioc能创建对象。
 可以把mybatis框架中的对象交给spring统一创建， 开发人员从spring中获取对象。
 开发人员就不用同时面对两个或多个框架了， 就面对一个spring


mybatis使用步骤，对象
1.定义dao接口 ，StudentDao
2.定义mapper文件 StudentDao.xml
3.定义mybatis的主配置文件 mybatis.xml
4.创建dao的代理对象， StudentDao dao = SqlSession.getMapper(StudentDao.class);

   List<Student> students  = dao.selectStudents();


要使用dao对象，需要使用getMapper()方法，
怎么能使用getMapper()方法，需要哪些条件
1.获取SqlSession对象， 需要使用SqlSessionFactory的openSession()方法。
2.创建SqlSessionFactory对象。 通过读取mybatis的主配置文件，能创建SqlSessionFactory对象

需要SqlSessionFactory对象， 使用Factory能获取SqlSession ，有了SqlSession就能有dao ， 目的就是获取dao对象
Factory创建需要读取主配置文件

我们会使用独立的连接池类替换mybatis默认自己带的， 把连接池类也交给spring创建。


主配置文件：
 1.数据库信息
 <environment id="mydev">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <!--数据库的驱动类名-->
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <!--连接数据库的url字符串-->
                <property name="url" value="jdbc:mysql://localhost:3306/springdb"/>
                <!--访问数据库的用户名-->
                <property name="username" value="root"/>
                <!--密码-->
                <property name="password" value="123456"/>
            </dataSource>
2. mapper文件的位置
   <mappers>
        <mapper resource="com/bjpowernode/dao/StudentDao.xml"/>
        <!--<mapper resource="com/bjpowernode/dao/SchoolDao.xml" />-->
    </mappers>


==============================================================
通过以上的说明，我们需要让spring创建以下对象
1.独立的连接池类的对象， 使用阿里的druid连接池
2.SqlSessionFactory对象
3.创建出dao对象

需要学习就是上面三个对象的创建语法，使用xml的bean标签。


连接池：多个连接Connection对象的集合， List<Connection>  connlist : connList就是连接池

通常使用Connection访问数据库
Connection conn =DriverManger.getConnection(url,username,password);
Statemenet stmt = conn.createStatement(sql);
stmt.executeQuery();
conn.close();


使用连接池
在程序启动的时候，先创建一些Connection
Connection c1 = ...
Connection c2 = ...
Connection c3 = ...
List<Connection>  connlist = new ArrayLits();
connList.add(c1);
connList.add(c2);
connList.add(c3);

Connection conn = connList.get(0);
Statemenet stmt = conn.createStatement(sql);
stmt.executeQuery();
把使用过的connection放回到连接池
connList.add(conn);


Connection conn1 = connList.get(1);
Statemenet stmt = conn1.createStatement(sql);
stmt.executeQuery();
把使用过的connection放回到连接池
connList.add(conn1);

==================================================================
spring的事务处理
回答问题
1.什么是事务
  讲mysql的时候，提出了事务。 事务是指一组sql语句的集合， 集合中有多条sql语句
  可能是insert ， update ，select ，delete， 我们希望这些多个sql语句都能成功，
  或者都失败， 这些sql语句的执行是一致的，作为一个整体执行。


2.在什么时候想到使用事务
  当我的操作，涉及得到多个表，或者是多个sql语句的insert，update，delete。需要保证
  这些语句都是成功才能完成我的功能，或者都失败，保证操作是符合要求的。


  在java代码中写程序，控制事务，此时事务应该放在那里呢？ 
     service类的业务方法上，因为业务方法会调用多个dao方法，执行多个sql语句



3.通常使用JDBC访问数据库， 还是mybatis访问数据库怎么处理事务
   jdbc访问数据库，处理事务  Connection conn ; conn.commit(); conn.rollback();
	mybatis访问数据库，处理事务， SqlSession.commit();  SqlSession.rollback();
	hibernate访问数据库，处理事务， Session.commit(); Session.rollback();


4.3问题中事务的处理方式，有什么不足
  1)不同的数据库访问技术，处理事务的对象，方法不同，
    需要了解不同数据库访问技术使用事务的原理
  2)掌握多种数据库中事务的处理逻辑。什么时候提交事务，什么时候回顾事务
  3)处理事务的多种方法。

  总结： 就是多种数据库的访问技术，有不同的事务处理的机制，对象，方法。



5.怎么解决不足
  spring提供一种处理事务的统一模型， 能使用统一步骤，方式完成多种不同数据库访问技术的事务处理。

  使用spring的事务处理机制，可以完成mybatis访问数据库的事务处理
  使用spring的事务处理机制，可以完成hibernate访问数据库的事务处理。



6.处理事务，需要怎么做，做什么
  spring处理事务的模型，使用的步骤都是固定的。把事务使用的信息提供给spring就可以了

  1）事务内部提交，回滚事务，使用的事务管理器对象，代替你完成commit，rollback
     事务管理器是一个接口和他的众多实现类。
	  接口：PlatformTransactionManager ，定义了事务重要方法 commit ，rollback
	  实现类：spring把每一种数据库访问技术对应的事务处理类都创建好了。
	           mybatis访问数据库---spring创建好的是DataSourceTransactionManager
				  hibernate访问数据库----spring创建的是HibernateTransactionManager

     怎么使用：你需要告诉spring 你用是那种数据库的访问技术，怎么告诉spring呢？
	  声明数据库访问技术对于的事务管理器实现类， 在spring的配置文件中使用<bean>声明就可以了
	  例如，你要使用mybatis访问数据库，你应该在xml配置文件中
	  <bean id=“xxx" class="...DataSourceTransactionManager"> 


  2）你的业务方法需要什么样的事务，说明需要事务的类型。
     说明方法需要的事务：
	    1）事务的隔离级别：有4个值。
		DEFAULT：采用 DB 默认的事务隔离级别。MySql 的默认为 REPEATABLE_READ； Oracle默认为 READ_COMMITTED。
		➢ READ_UNCOMMITTED：读未提交。未解决任何并发问题。
		➢ READ_COMMITTED：读已提交。解决脏读，存在不可重复读与幻读。
		➢ REPEATABLE_READ：可重复读。解决脏读、不可重复读，存在幻读
		➢ SERIALIZABLE：串行化。不存在并发问题。

    	  2) 事务的超时时间： 表示一个方法最长的执行时间，如果方法执行时超过了时间，事务就回滚。
		  单位是秒， 整数值， 默认是 -1. 

	   3）事务的传播行为 ： 控制业务方法是不是有事务的， 是什么样的事务的。
		    7个传播行为，表示你的业务方法调用时，事务在方法之间是如果使用的。

			PROPAGATION_REQUIRED ：（默认值）指定方法必须在事务内执行，若当前事务存在就加入当前事务，若当前没有事务，就创建新事务。
			PROPAGATION_REQUIRES_NEW ：总是新建一个事务，若存在当前事务，就将当前事务挂起，直到新事物执行完毕。
			PROPAGATION_SUPPORTS ：指定的方法支持当前事务，但若当前没有事务，也可以以非事务的方式执行。（例如：查询）
			以上三个需要掌握的

			PROPAGATION_MANDATORY
			PROPAGATION_NESTED
			PROPAGATION_NEVER
			PROPAGATION_NOT_SUPPORTED

  3）事务提交事务，回滚事务的时机
     1）当你的业务方法，执行成功，没有异常抛出，当方法执行完毕，spring在方法执行后提交事务。事务管理器commit
	 
	  2）当你的业务方法抛出运行时异常或ERROR， spring执行回滚，调用事务管理器的rollback
	     运行时异常的定义： RuntimeException  和他的子类都是运行时异常， 例如NullPointException , NumberFormatException
	  
	  3) 当你的业务方法抛出非运行时异常， 主要是受查异常时，提交事务
        受查异常：在你写代码中，必须处理的异常。例如IOException, SQLException


总结spring的事务
  1.管理事务的是 事务管理和他的实现类
  2.spring的事务是一个统一模型
     1）指定要使用的事务管理器实现类，使用<bean>
	  2）指定哪些类，哪些方法需要加入事务的功能
	  3）指定方法需要的隔离级别，传播行为，超时


	  你需要告诉spring，你的项目中类信息，方法的名称，方法的事务传播行为。


spring框架中提供的事务处理方案
1.适合中小项目使用的， 注解方案。
  spring框架自己用aop实现给业务方法增加事务的功能， 使用@Transactional注解增加事务。
  @Transactional注解是spring框架自己注解，放在public方法的上面，表示当前方法具有事务。
  可以给注解的属性赋值，表示具体的隔离级别，传播行为，异常信息等等

  使用@Transactional的步骤：
  1.需要声明事务管理器对象
    <bean id="xx" class="DataSourceTransactionManager">

  2.开启事务注解驱动， 告诉spring框架，我要使用注解的方式管理事务。
    spring使用aop机制，创建@Transactional所在的类代理对象，给方法加入事务的功能。
    spring给业务方法加入事务：
	    在你的业务方法执行之前，先开启事务，在业务方法之后提交或回滚事务，使用aop的环绕通知
       
		 @Around("你要增加的事务功能的业务方法名称")
		 Object myAround(){
           开启事务，spring给你开启
			  try{
			     buy(1001,10);
				  spring的事务管理器.commit();
			  }catch(Exception e){
             spring的事务管理器.rollback();
			  }
			 
		 }

  3.在你的方法的上面加入@Trancational


2.适合大型项目，有很多的类，方法，需要大量的配置事务，使用aspectj框架功能，在spring配置文件中
  声明类，方法需要的事务。这种方式业务方法和事务配置完全分离。

  实现步骤： 都是在xml配置文件中实现。 
   1)要使用的是aspectj框架，需要加入依赖
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-aspects</artifactId>
		<version>5.2.5.RELEASE</version>
	</dependency>

	2）声明事务管理器对象
	 
    <bean id="xx" class="DataSourceTransactionManager">

	
	3) 声明方法需要的事务类型（配置方法的事务属性【隔离级别，传播行为，超时】）

	4) 配置aop：指定哪些哪类要创建代理。


================================================================================
第六章： web项目中怎么使用容器对象。

1.做的是javase项目有main方法的，执行代码是执行main方法的，
  在main里面创建的容器对象 
  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

2.web项目是在tomcat服务器上运行的。 tomcat一起动，项目一直运行的。


需求：
web项目中容器对象只需要创建一次，  把容器对象放入到全局作用域ServletContext中。

怎么实现：
   使用监听器 当全局作用域对象被创建时 创建容器 存入ServletContext

	监听器作用：
	1）创建容器对象，执行 ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	2）把容器对象放入到ServletContext， ServletContext.setAttribute(key,ctx)

	监听器可以自己创建，也可以使用框架中提供好的ContextLoaderListener


	 private WebApplicationContext context;
	 public interface WebApplicationContext extends ApplicationContext


	 ApplicationContext:javase项目中使用的容器对象
    WebApplicationContext：web项目中的使用的容器对象

    把创建的容器对象，放入到全局作用域
	 key： WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE
	       WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE
	 value：this.context

	 servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, this.context);


	 作业要求：
	  1. 使用ajax请求方式：获取服务器端定义的 还款方式， 获取最长的还款期数
	  2. 点击保存，把计算结果，保存到数据库，使用mybatis
     3. 整个项目使用 servlet ，spring + mybatis
