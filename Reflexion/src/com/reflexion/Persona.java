package com.reflexion;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Persona {
	
	private String name;
	private int age;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	public Persona() {
		super();
	}
	@Override
	public String toString() {
		return "Persona [name=" + name + ", age=" + age + "]";
	}
	

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void givenObject_whenGetsFieldNamesAtRuntime_thenCorrect() {
		Object person = new Persona();
		Field[] fields = person.getClass().getDeclaredFields();
		List<String> actualFieldNames = getFieldNames(fields);
		assertTrue(Arrays.asList("name", "age").containsAll(actualFieldNames));
		
		Method[] methods = person.getClass().getMethods();
		List<String> actualMethodNames = getMethodNames(methods);
		assertTrue(Arrays.asList("getName", "getAge").contains(actualMethodNames));
	}
	
	private static List<String> getFieldNames(Field[] fields) {
	    List<String> fieldNames = new ArrayList<>();
	    for (Field field : fields) {
	        fieldNames.add(field.getName());
	    }
	    System.out.println(fieldNames);
	    return fieldNames;
	}
	
	
	
	private static List<String> getMethodNames(Method[] methods) {
	    List<String> methodNames = new ArrayList<>();
	    for (Method method : methods) {
	        methodNames.add(method.getName().toString());
	    }
	    System.out.println(methodNames);
	    return methodNames;
	}

}
