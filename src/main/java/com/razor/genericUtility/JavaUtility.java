package com.razor.genericUtility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
/**
 * This class is used to generate random numbers, decode, encode, get currentDate, addOrSubDate 
 * @author Vishwanath-Naik
 *
 */
public class JavaUtility {
	/**
	 * 
	 * @param boundryValue
	 * @return
	 */
	public int getRandomNumber(int boundryValue) {
		return new Random().nextInt(boundryValue);		
	}
	/**
	 * This method is used to decode the credentials
	 * @param s
	 * @return
	 */
	public String decode(String propertyData)
	{
		return new String (Base64.getDecoder().decode(propertyData.getBytes()));
	}
	/**
	 * this method is used to encode the credentials
	 * @param s
	 * @return
	 */
	public String encode(String propertyData)
	{
		return new String(Base64.getEncoder().encode(propertyData.getBytes()));
	}
	/**
	 * 
	 * @return 
	 */
	public String getCurrentDate() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_HH_mm_sss");
		return sdf.format(new Date());
	}
	/**
	 * 
	 * @param pattern
	 * @return
	 */
	public String getCurrentDate(String pattern) {
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}
	/**
	 * 
	 * @param days
	 * @return
	 */
	public String getCurrentDate(int days) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy");
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		return sdf.format(cal.getTime());
	}
	/**
	 * 
	 * @param date
	 * @param days
	 * @return
	 * @throws ParseException
	 */
	public String addOrSubtractDate(String date, int days) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy");
		Calendar cal=Calendar.getInstance();
		cal.setTime(sdf.parse(date));
		cal.add(Calendar.DAY_OF_MONTH, days);
		return sdf.format(cal.getTime());
	}
}
