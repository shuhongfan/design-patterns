

<center><h1>Spring源码分析案例总结</h1></center>
# 方法论

## 1、基本点

- 1、看文档注释、方法注释
- 2、翻译方法名、变量名；自解释模式
- 3、注意类结构；



## 2、Spring套路点

- 1、AbstractBeanDefinition 看看何时给容器中注入了什么组件

- 2、BeanFactory让初始化完，监控里面多了哪些后置处理器

- 3、分析后置处理器什么时候调用，做了什么功能

  >  以上所有的前提，理解**容器刷新12大步**与**getBean流程**，防止混乱
  >
  >  1、工厂后置处理器执行
  >
  >  2、bean后置处理器执行&bean的生命周期（后置处理器+InitializingBean）



1、这个新功能一般都是由 **bean的生命周期**机制增强出来的；

2、这个功能加入了哪些组件，这些组件在生命周期期间做了什么？







# 一、循环引用





# 二、AOP

## 1、引入依赖

```groovy
    compile(project(":spring-aspects"))  //引入aop&切面模块
```



## 2、编写测试

### 1、配置类

```java
@EnableAspectJAutoProxy  //开启基于注解的aop
@Configuration
public class AopOpenConfig {




}
```





### 2、测试

```java
//切面
@Component  //切面也是容器中的组件
@Aspect //说明这是切面
public class LogAspect {

	public LogAspect(){
		System.out.println("LogAspect...");
	}

	//前置通知
	@Before("execution(* com.atguigu.spring.aop.HelloService.sayHello(..))")
	public void logStart(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		System.out.println("logStart()==>"+name+"....【args: "+ Arrays.asList(joinPoint.getArgs()) +"】");
	}

	//返回通知
	@AfterReturning(value = "execution(* com.atguigu.spring.aop.HelloService.sayHello(..))",returning = "result")
	public void logReturn(JoinPoint joinPoint,Object result){
		String name = joinPoint.getSignature().getName();
		System.out.println("logReturn()==>"+name+"....【args: "+ Arrays.asList(joinPoint.getArgs()) +"】【result: "+result+"】");
	}


	//后置通知
	@After("execution(* com.atguigu.spring.aop.HelloService.sayHello(..))")
	public void logEnd(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		System.out.println("logEnd()==>"+name+"....【args: "+ Arrays.asList(joinPoint.getArgs()) +"】");
	}


	//异常
	@AfterThrowing(value = "execution(* com.atguigu.spring.aop.HelloService.sayHello(..))",throwing = "e")
	public void logError(JoinPoint joinPoint,Exception e){
		String name = joinPoint.getSignature().getName();
		System.out.println("logError()==>"+name+"....【args: "+ Arrays.asList(joinPoint.getArgs()) +"】【exception: "+e+"】");
	}
}

```



```java
//业务类
@Component
public class HelloService {

	public HelloService(){
		System.out.println("....");
	}

	public String sayHello(String name){
		String result = "你好："+name;
		System.out.println(result);
		int length = name.length();
		return result + "---" + length;
	}
}
```



切面里面的所有通知方法会在目标方法的前后进行回调



## 3、原理

### 1、AOP给容器中添加了什么组件

> 1、AbstractBeanDefinition的构造器打断点，就能知道容器中的bean定义信息，Spring也可能在底层直接new对象注册进去。最好给refresh()十二大步的最后一步打上断点，在debug控制台看有哪些没见过的组件。单独分析他们即可



> 2、每一个功能的开启，要么写配置，要么注解。@EnableXXX 开启 xxx功能的注解。这个注解很重要。



```java
@Import(AspectJAutoProxyRegistrar.class)
public @interface EnableAspectJAutoProxy { }
```



- 给容器中利用AspectJAutoProxyRegistrar（实现了ImportBeanDefinitionRegistrar）；





> 给容器中导入了 **AnnotationAwareAspectJAutoProxyCreator**

### 2、这个组件做了什么功能（AnnotationAwareAspectJAutoProxyCreator）

他是BeanPostProcessor

1、追踪getBean的整个流程，看什么时候 AnnotationAwareAspectJAutoProxyCreator 执行

2、AnnotationAwareAspectJAutoProxyCreator 直接打断点

> AnnotationAwareAspectJAutoProxyCreator   第一次运行的时候分析组装好了切面、增强器（通知方法）的所有信息；







# 三、事件机制

## 1、原理

### 1、事件机制给容器中添加了什么组件