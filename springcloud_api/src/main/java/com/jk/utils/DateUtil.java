/** 
 * <pre>项目名称:test 
 * 文件名称:DateUtil.java 
 * 包名:com.jk.ldl.utils 
 * 创建日期:2018年7月13日下午10:13:52 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


/** 
 * <pre>项目名称：test    
 * 类名称：DateUtil    
 * 类描述：    
 * 创建人：吕德龙  
 * 创建时间：2018年7月13日 下午10:13:53    
 * 修改人：吕德龙 
 * 修改时间：2018年7月13日 下午10:13:53    
 * 修改备注：       
 * @version </pre>    
 */
public class DateUtil {
	public static String dataString(Date date,String formatter) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		if(formatter != null) {
			simpleDateFormat = new SimpleDateFormat(formatter);
		}else {
			simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		}
		
		String format = simpleDateFormat.format(date);
		return format;
	}

}
