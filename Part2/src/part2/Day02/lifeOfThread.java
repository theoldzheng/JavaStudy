package part2.Day02;

/**
 * 线程的生命周期
 *
 * 总的来说可以分为三个主要部分 两个首末部分
 * 按照次序来说为  新建  就绪  阻塞   执行   结束（死亡）
 *
 * 新建 调用start方法 线程进入就绪状态、当CPU执行权分配到该线程上时，该线程进入执行状态
 * 因为 时间片到、sleep、等待同步锁、join、wait 等方法 可以导致线程阻塞，
 * 当上述方法执行完毕 线程继续回到就绪状态等待被分配CPU执行权限
 *
 * 当线程执行完毕、调用stop、出现error或者Exception且没处理 都会线程走向结束（死亡）
 *
 */
public class lifeOfThread {
}