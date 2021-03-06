package DesignTest;

public class MainTest {
    /**
     * main方法是一个静态的方法
     * main作为一个程序的入口
     * main也可以作为我们与控制台交互的方式
     * <p>
     * 代码块儿：用来初始化类或者对象
     * 如果要修饰代码块的话  只能用static
     * <p>
     *     构造器比静态代码快执行晚
     *     非静态代码块比构造器早
     *     顺序：静态代码块、非静态代码块、构造器 （由父及子 静态先行）
     * 静态代码块 会随着类的加载而执行
     * 静态代码块儿内只能调用静态的属性、方法不能调用非静态的结构
     * <p>
     * 非静态代码块 随着对象的创建而调用执行
     * 创建一次 执行一次
     *非静态的代码块儿可以调用静态的属性、方法和非静态的属性和方法
     * 静态代码块的执行顺序优先于非静态
     *
     * 对属性的赋值 顺序
     * 1.默认初始化
     * 2.显式初始化/在代码块儿中赋值
     * 3.构造器初始化
     * 4.通过对象“。” 进行初始化
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("hello world");


    }

    static {
        System.out.println("静态代码快");
    }

    {
        System.out.println("非静态代码快");
    }

}