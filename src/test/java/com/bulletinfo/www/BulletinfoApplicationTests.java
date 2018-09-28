package com.bulletinfo.www;

import com.bulletinfo.www.utils.Encipher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BulletinfoApplicationTests {

	@Test
	public void contextLoads() {

		String s = "dsfd24jj";
		Object object = Encipher.Encode(s);
		System.out.println("EN:"+object);
		String ss = String.valueOf(object);
		object = Encipher.Decode(ss);
		System.out.println("DE:"+object);
	}

}
