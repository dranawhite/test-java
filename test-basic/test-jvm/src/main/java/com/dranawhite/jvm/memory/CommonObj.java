package com.dranawhite.jvm.memory;

/**
 * 内存中的对象大小
 * <pre>
 *    Java对象的内存布局：对象头(Header)、实例数据(Instance Data)和对齐填充(Padding);
 *    虚拟机的对象头包括两部分信息：
 *    (1)存储对象自身的运行时数据，如hashCode、GC分代年龄、锁状态标志、线程持有的锁、偏向线程ID、偏向时间戳等；
 *       这部分数据长度在32位和64位虚拟机(未开启指针压缩)中分别是4B和8B，官方称为"Mark Word"；
 *    (2)类型指针(kclass)，即对象指向它的类元数据的指针，虚拟机通过这个指针来确定这个对象时哪个类的实例；
 *       如果对象时java数组，对象头中必须还有一块用于记录数组长度的数据，因为虚拟机可以通过普通java对象的元数据信息
 *    确定java对象的大小，但是从数组元数据中却无法确定数组的大小；
 *
 *    对象在32位系统上占用8B，64位系统上占16B，无论32位系统还是64位系统，对象都采用8字节对齐。
 *    Java在64位模式下开启指针压缩，比起32位模式下，头部会大4B(Mark区域变为8B，kclass被压缩)，如果没有开启指针压缩，
 * 头部会大8B(Mark和kclass都是8B)；
 * </pre>
 *
 * @author dranawhite 2017/8/4
 * @version 1.0
 */
class CommonObj {

}
