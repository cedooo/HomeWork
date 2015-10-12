# UML

标签（空格分隔）： 设计模式 

---
- 设计模式
    - 创建型
        - 简单工厂
        - 工厂方法

```flow 
sm=>start: 简单工厂
oc=>operation: + “开闭原则”
f=>end: 工厂方法

sm->oc->f
```  

## 简单工厂
### 类图
    角色：
        Factory
        Product
        ConcreteProduct
![class](http://design-patterns.readthedocs.org/zh_CN/latest/_images/SimpleFactory.jpg)
### 时序图
![seq](http://design-patterns.readthedocs.org/zh_CN/latest/_images/seq_SimpleFactory.jpg)

## 工厂方法
### 类图
    角色：
        Factory
        ConcreteFactory
        Product
        ConcreteProduct
![class](http://design-patterns.readthedocs.org/zh_CN/latest/_images/FactoryMethod.jpg)
### 时序图
![seq](http://design-patterns.readthedocs.org/zh_CN/latest/_images/seq_FactoryMethod.jpg)




