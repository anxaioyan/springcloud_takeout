package com.jk.utils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.util.*;
 
/** 
 * <pre>项目名称：test    
 * 类名称：HttpClientUtil    
 * 类描述：    
 * 创建人：吕德龙  
 * 创建时间：2018年7月13日 下午10:26:21    
 * 修改人：吕德龙 
 * 修改时间：2018年7月13日 下午10:26:21    
 * 修改备注：       
 * @version </pre>    
 */
public class HttpClientUtil {
	static CloseableHttpClient client = null;
	static {
		client = HttpClients.createDefault();
}
	
	public static String get(String url,HashMap<String, Object> params){
		try {
			HttpGet httpGet = new HttpGet();
			Set<String> keySet = params.keySet();
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append(url).append("?t=").append(System.currentTimeMillis());
			for (String key : keySet) {
				stringBuffer.append("&").append(key).append("=").append(params.get(key));
			}
			httpGet.setURI(new URI(stringBuffer.toString()));
			CloseableHttpResponse execute = client.execute(httpGet);
			int statusCode = execute.getStatusLine().getStatusCode();
			if (200 != statusCode) {
				return "";
			}
			return EntityUtils.toString(execute.getEntity(), "utf-8");
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 
	 * 方法: post <br>
	 * 描述: post请求 <br>
	 * 作者: Teacher song<br>
	 * 时间: 2017年7月21日 下午3:20:31
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String post(String url,HashMap<String, Object> params) {
		try {
			HttpPost httpPost = new HttpPost();
			httpPost.setURI(new URI(url));
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			Set<String> keySet = params.keySet();
			for (String key : keySet) {
				NameValuePair e = new BasicNameValuePair(key, params.get(key).toString());
				parameters.add(e);
			}
			HttpEntity entity = new UrlEncodedFormEntity(parameters , "utf-8");
			httpPost.setEntity(entity );
			CloseableHttpResponse execute = client.execute(httpPost);
			int statusCode = execute.getStatusLine().getStatusCode();
			if (200 != statusCode) {
				return "";
			}
			return EntityUtils.toString(execute.getEntity(), "utf-8");
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public String createRandom(){
		String number = "";
		for(int i = 0;i<6;i++){
			number = number + (int) (Math.random() * 9);
		}
		return number;
	}
	
	public static String createRandom2(){
		String number = "";
		for(int i = 0;i<6;i++){
			number = number + (int) (Math.random() * 9);
		}
		System.out.println("number"+number);
		return number;
	}
	
	
	//这些都是写到controller中的
	public static void main(String[] args) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		//1.
		params.put("accountSid",CommonConst.ACCOUNT_SID);
		//2.模板id
		params.put("templateid", CommonConst.TEMPLATE_ID);
		//3.到时候写随机生成六位数字
		String createRandom = createRandom2();
		params.put("param", createRandom+","+5);
		//4.这里面是页面传过来的手机号
		params.put("to", "17610470297");
		//5.时间戳
		String timestamp = DateUtil.dataString(new Date(),null);
		params.put("timestamp", timestamp);
		//6.签名
		String md532 = Md5Util.getMd532(CommonConst.ACCOUNT_SID+CommonConst.AUTH_TOKEN+timestamp);
		params.put("sig", md532);
		String string = HttpClientUtil.post("https://api.miaodiyun.com/20150822/industrySMS/sendSMS", params);
		System.out.println("string"+string);
	}

}
