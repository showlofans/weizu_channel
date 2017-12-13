package crud.aotest.apiTest;

public interface BaseAPITest {
	/**
	 * @description: 解析打印json字符串和结果
	 * @param resultStr
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月11日 上午11:06:57
	 */
	void paraseBalanceJson(String resultStr);
	
	/**
	 * @description: 测试余额接口
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月11日 上午11:07:21
	 */
	void testGetBalance();
	
	/**
	 * @description: 测试平台接口是否有用,测试加密算法是否正确
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月11日 上午11:53:30
	 */
	void testAPI();
}
