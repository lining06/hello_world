package org.lining.test.design.factory.abstractFactory.factory;

import org.lining.test.design.factory.abstractFactory.api.AbstractRunInterface;
import org.lining.test.design.factory.abstractFactory.api.AbstractWalkInterface;

/**
 * https://blog.csdn.net/u012156116/article/details/80857255
 优点：
 1. 抽象工厂模式最大的好处是易于交换产品系列，由于具体工厂类，例如 IFactory factory=new OracleFactory(); 在一个应用中只需要在初始化的时候出现一次，这就使得改变一个应用的具体工厂变得非常容易，它只需要改变具体工厂即可使用不同的产品配置。不管是任何人的设计都无法去完全防止需求的更改，或者项目的维护，那么我们的理想便是让改动变得最小、最容易，例如我现在要更改以上代码的数据库访问时，只需要更改具体的工厂即可。

 2. 抽象工厂模式的另一个好处就是它让具体的创建实例过程与客户端分离，客户端是通过它们的抽象接口操作实例，产品实现类的具体类名也被具体的工厂实现类分离，不会出现在客户端代码中。就像我们上面的例子，客户端只认识IUser和ILogin，至于它是MySQl里的表还是Oracle里的表就不知道了。

 缺点：
 1. 如果你的需求来自增加功能，比如增加Login表，就有点太烦了。首先需要增加 ILogin，mysqlLogin,oracleLogin。 然后我们还要去修改工厂类： sqlFactory， mysqlFactory， oracleFactory 才可以实现，需要修改三个类，实在是有点麻烦。

 2. 还有就是，客户端程序肯定不止一个，每次都需要声明sqlFactory factory=new MysqlFactory()， 如果有100个调用数据库的类，就需要更改100次sqlFactory factory=new oracleFactory()。
 */
public interface MoveFactory {

    AbstractRunInterface createRun();

    AbstractWalkInterface createWalk();
}
