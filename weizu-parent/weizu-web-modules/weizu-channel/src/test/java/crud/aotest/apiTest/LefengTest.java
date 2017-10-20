package crud.aotest.apiTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weizu.web.foundation.MD5;
import com.weizu.web.foundation.SHA1;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class LefengTest {
	
	@Test
	public void md5EncodeTest(){
		String encodeStr = SHA1.getSha1("userNamewxtxmobile13964888095orderMeal10timeStamp1472085581key550e8400-e29b-41d4-a716-446655440000", MD5.LOWERCASE);
		System.out.println("f8a72ff31cee0bb4b9fa88dfec87ff1df9e853c8".equals(encodeStr));
	}
}
