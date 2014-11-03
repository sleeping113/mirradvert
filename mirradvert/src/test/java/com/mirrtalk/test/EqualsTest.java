package com.mirrtalk.test;

/** 
 * @author wangliming 
 * @date 2014-3-15 上午9:58:13
 * @version 1.0
 */
public class EqualsTest {

	public static void main(String[] args) {
		
		//"=="判断两个基本数据类型的值是否相等
		int a = 10, b = 10;
		System.out.println(a + "==" + b + ":" + (a == b));
		//"=="判断两个对象的引用地址是否一样，由于Integer采用了自动装箱技术
		//当数据值在【-128,127】之间返回的是同一个值
		Integer c = 100, d = 100, e = 200, f = 200;
		Integer g = new Integer(1);
		Integer h = new Integer(1);
		System.out.println(c + "==" + d + ":" + (c == d));
		System.out.println(e + "==" + f + ":" + (e == f));
		//因g和h是两个不同的对象，故应返回false
		System.out.println(g + "==" + h + ":" + (g == h));
		
		//"equals"判断两个对象是否相等
		Object obj = new Object();
		Object obj2 = new Object();
		//因obj和obj2是两个不同的对象故返回false(Object类的equals方法内部调用的"==")
		System.out.println(obj + " equals " + obj2 + " " + obj.equals(obj2));
        String s = "abc", s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");
        //因String重写了Object的equals方法，故返回true
        System.out.println(s + " equals " + s2 + " " + s.equals(s2));
        System.out.println(s3 + " equals " + s4 + " " + s3.equals(s4));
        System.out.println(s3 + "的hashCode为：" + s3.hashCode());
	}
}
