/**
 * 交易系统扣款子模块
 * <pre>
 * 运用工厂模式、策略模式和门面模式
 * 功能如下：
 *      扣款子模块中主要包括两部分：
 *       1）IC卡类和交易信息类
 *           其中IC卡中包括两种金额：固定金额和自由金额；交易信息类负责记录每一笔交易。
 *       2）扣款策略类
 *       扣款策略有以下两种：
 *           a. IC卡固定金额 = IC卡现有固定金额-交易金额/2
 *              IC卡自由金额 = IC卡自由金额-交易金额/2
 *           b. 全部消费从IC卡自由金额中扣除
 * 类图实现：
 *       主要涉及如下几个角色：
 *       1.IC卡类和交易类
 *       2.扣款策略接口
 *       3.扣款策略的封装类
 *       4.策略枚举类
 *       5.策略工厂
 *       6.扣款模块封装
 *       7.场景类
 * </pre>
 *
 *
 * @author dranawhite 2017/11/1
 * @version 1.0
 */

package com.dranawhite.pattern.complex.deduction;