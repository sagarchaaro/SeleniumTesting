package junitScripts;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class JunitParametersDemo {
	public String userName, password;
	
	public JunitParametersDemo(String userName, String password) {
		this.userName=userName;
		this.password=password;
	}
	
	@Test
	public void login() {
		System.out.println("UserName is:"+userName);
		System.out.println("Password is: "+password);
	}
	
	@Parameters
	public static Collection<Object[]> parameter(){
		Object[][] pData=new Object[2][2];
		pData[0][0]="Admin";
		pData[0][1]="admin";
		pData[1][0]="admin123";
		pData[1][1]="admin456";
		
		return Arrays.asList(pData);
	}
}
