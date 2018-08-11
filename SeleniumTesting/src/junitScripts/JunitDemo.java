package junitScripts;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JunitDemo {
	@Ignore
	@Test
	public void abcd() {
		System.out.println("Hello World");
	}
	@Test
	public void xyzs() {
		System.out.println("Welcome to the JUnit programming");
	}
	@Before
	public void before() {
		System.out.println("Before Annotation");
	}
	
	@After
	public void after() {
		System.out.println("After Annotation");
	}
	@BeforeClass
	public static void beforeclass() {
		System.out.println("Before Class Annotation");
	}
	@AfterClass
	public static void afterclass() {
		System.out.println("After Class Annotation");
	}
	
	
}
