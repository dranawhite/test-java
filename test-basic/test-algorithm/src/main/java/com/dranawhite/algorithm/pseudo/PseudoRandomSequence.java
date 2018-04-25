package com.dranawhite.algorithm.pseudo;

/**
 * 伪随机序列
 *
 * @author liangyq
 * @version [1.0, 2018/4/24 10:52]
 */
public class PseudoRandomSequence {

	/**
	 * 平方取中法
	 * <pre>
	 *     输入一个4位十进制，平方后，补足8位，取中间4位输出
	 * </pre>
	 *
	 * @param rand 初始值
	 *
	 * @return 随机数
	 */
	public int getMiddleSquare(int rand) {
		rand = rand * rand;
		return rand / 100 % 10000;
	}

}
