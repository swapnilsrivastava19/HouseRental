package com.razor.genericUtility.Retry;

import java.lang.reflect.Constructor;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
/**
 * 
 * @author Vishwanath-Naik
 *
 */
public class SetTestParameter implements IAnnotationTransformer{
	/**
	 * 
	 * @param annotation
	 * @param testClass
	 * @param testConstructor
	 * @param occurringClass
	 */
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Class<?> occurringClass) {
		annotation.setRetryAnalyzer(RetryImplementation.class);
	}
}
