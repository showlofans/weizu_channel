package com.weizu.flowsys.core.aop;

import javax.annotation.Resource;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * �ڲ��Զ������������
 * @author ��ʤ��
 * @time 2016��5��11������10:02:15
 * @email 719348277@qq.com
 */
@Aspect
public class TransactionManager {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "sqlSessionTemplateASS")
	private SqlSessionTemplate sqlSessionTemplateASS;
	
	@Pointcut("@annotation(com.weizu.web.foundation.core.annotation.po.TraMethod)")
	public void transactionMethod(){}
	
	@Before("transactionMethod()")
	public void openTra(){
		System.out.println("ǰ��^^^������");
	}
	
	@AfterReturning("transactionMethod()")
	public void cmmintTra(){
		System.out.println("ǰ��^^^�����ύ");
	}
}
