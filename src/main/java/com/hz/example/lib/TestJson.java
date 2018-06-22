package com.hz.example.lib;

import com.hz.example.pojo.Emp;
import org.json.JSONException;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class TestJson {
	public static void main(String[] args) throws JSONException {
		
		String str = (String) getObj();
		
		JSONObject json1 = JSONObject.parseObject(str);
		String name1 = (String) json1.get("name");
		System.out.println(name1);

		net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(str);
		String name = (String) json.get("name");
		System.out.println(name);
		
		org.json.JSONObject json2 = new org.json.JSONObject();
		json2.put("name", "tom");
		json2.put("age", "18");
		System.out.println(json2);
		
		Gson gson = new Gson();
		Emp emp = gson.fromJson(str, Emp.class);
		System.out.println(emp.getName());
		String json3 = gson.toJson(emp);
		System.out.println(json3);
		
		JsonObject json4 = new JsonObject();
		json4.addProperty("name", "tom");
		json4.addProperty("age", "18");
		System.out.println(json4);
		
		JSONPObject jsonp = new JSONPObject();
		jsonp.setFunction("show");
		jsonp.addParameter(str);
		System.out.println(jsonp);
		
	}
	
	
	static Object getObj(){
		String s1 = "{name:\"tom\",age:\"18\"}";
		return s1;
	}
	
}

class c1{
	
	public static void main(String[] args) {
		String json = "{\"info\":{\"url\":\"https://195.remoteble.com/c1/call.php\",\"content_type\":\"application/json; charset=utf-8\",\"http_code\":200,\"header_size\":412,\"request_size\":368,\"filetime\":-1,\"ssl_verify_result\":0,\"redirect_count\":0,\"total_time\":0.11879000000000001,\"namelookup_time\":0.032277,\"connect_time\":0.036393000000000002,\"pretransfer_time\":0.060740000000000002,\"size_upload\":230,\"size_download\":128,\"speed_download\":1077,\"speed_upload\":1936,\"download_content_length\":-1,\"upload_content_length\":230,\"starttransfer_time\":0.11869,\"redirect_time\":0,\"redirect_url\":\"\",\"primary_ip\":\"104.28.3.185\",\"certinfo\":[],\"primary_port\":443,\"local_ip\":\"172.18.0.3\",\"local_port\":58702},\"req\":{\"payload\":{\"function_id\":\"1\",\"region\":\"global\",\"profile_id\":\"0\",\"user_email\":\"SdQKoJinGRiLZIr8yv98JcGFgg2vbXnkyhrjYwFiokw=\",\"user_pwd\":\"AQBd/yrhak8SYrliKmK+drwllH0grPTB4e/o+jHKJDw=\",\"pa_key\":\"fttest00000001\",\"customer_code\":\"Fanten\",\"project_code\":\"fantentest1\"}},\"res\":{\"head\":{\"Date\":\"Fri, 12 May 2017 02\",\"Content-Type\":\"application/json; charset=utf-8\",\"Transfer-Encoding\":\"chunked\",\"Connection\":\"keep-alive\",\"Set-Cookie\":\"__cfduid=d752e3c98bdd3bf3872ec182da2fa2c1e1494557743; expires=Sat, 12-May-18 02\",\"X-Powered-By\":\"PHP/7.1.3\",\"Access-Control-Allow-Origin\":\"*\",\"Server\":\"cloudflare-nginx\",\"CF-RAY\":\"35da19c76c84332b-HKG\"},\"body\":{\"result_code\":1,\"result_des\":\"Request Processed\",\"result_data\":{\"region\":{\"0\":\"GLOBAL\",\"1\":\"ASIA\",\"2\":\"EU\",\"3\":\"JP\",\"4\":\"US\"}}},\"raw\":\"HTTP/1.1 200 OK\r\nDate: Fri, 12 May 2017 02:55:43 GMT\r\nContent-Type: application/json; charset=utf-8\r\nTransfer-Encoding: chunked\r\nConnection: keep-alive\r\nSet-Cookie: __cfduid=d752e3c98bdd3bf3872ec182da2fa2c1e1494557743; expires=Sat, 12-May-18 02:55:43 GMT; path=/; domain=.remoteble.com; HttpOnly\r\nX-Powered-By: PHP/7.1.3\r\nAccess-Control-Allow-Origin: *\r\nServer: cloudflare-nginx\r\nCF-RAY: 35da19c76c84332b-HKG\r\n\r\n{\"result_code\":1,\"result_des\":\"Request Processed\",\"result_data\":{\"region\":{\"0\":\"GLOBAL\",\"1\":\"ASIA\",\"2\":\"EU\",\"3\":\"JP\",\"4\":\"US\"}}}\"}}";
		
		int start = json.indexOf(",\"raw\":");
		
		json = json.substring(0,start)+"}}";
		System.out.println(json);
		
//		String json = "{\"info\":{\"url\":\"https://195.remoteble.com/c1/call.php\",\"content_type\":\"application/json; charset=utf-8\",\"http_code\":200,\"header_size\":412,\"request_size\":368,\"filetime\":-1,\"ssl_verify_result\":0,\"redirect_count\":0,\"total_time\":0.11879000000000001,\"namelookup_time\":0.032277,\"connect_time\":0.036393000000000002,\"pretransfer_time\":0.060740000000000002,\"size_upload\":230,\"size_download\":128,\"speed_download\":1077,\"speed_upload\":1936,\"download_content_length\":-1,\"upload_content_length\":230,\"starttransfer_time\":0.11869,\"redirect_time\":0,\"redirect_url\":\"\",\"primary_ip\":\"104.28.3.185\",\"certinfo\":[],\"primary_port\":443,\"local_ip\":\"172.18.0.3\",\"local_port\":58702},\"req\":{\"payload\":{\"function_id\":\"1\",\"region\":\"global\",\"profile_id\":\"0\",\"user_email\":\"SdQKoJinGRiLZIr8yv98JcGFgg2vbXnkyhrjYwFiokw=\",\"user_pwd\":\"AQBd/yrhak8SYrliKmK+drwllH0grPTB4e/o+jHKJDw=\",\"pa_key\":\"fttest00000001\",\"customer_code\":\"Fanten\",\"project_code\":\"fantentest1\"}},\"res\":{\"head\":{\"Date\":\"Fri, 12 May 2017 02\",\"Content-Type\":\"application/json; charset=utf-8\",\"Transfer-Encoding\":\"chunked\",\"Connection\":\"keep-alive\",\"Set-Cookie\":\"__cfduid=d752e3c98bdd3bf3872ec182da2fa2c1e1494557743; expires=Sat, 12-May-18 02\",\"X-Powered-By\":\"PHP/7.1.3\",\"Access-Control-Allow-Origin\":\"*\",\"Server\":\"cloudflare-nginx\",\"CF-RAY\":\"35da19c76c84332b-HKG\"},\"body\":{\"result_code\":1,\"result_des\":\"Request Processed\",\"result_data\":{\"region\":{\"0\":\"GLOBAL\",\"1\":\"ASIA\",\"2\":\"EU\",\"3\":\"JP\",\"4\":\"US\"}}}}}";
//		String json = "{\"info\":{\"url\":\"https://195.remoteble.com/c1/call.php\",\"content_type\":\"application/json; charset=utf-8\",\"http_code\":200,\"header_size\":412,\"request_size\":368,\"filetime\":-1,\"ssl_verify_result\":0,\"redirect_count\":0,\"total_time\":0.11879000000000001,\"namelookup_time\":0.032277,\"connect_time\":0.036393000000000002,\"pretransfer_time\":0.060740000000000002,\"size_upload\":230,\"size_download\":128,\"speed_download\":1077,\"speed_upload\":1936,\"download_content_length\":-1,\"upload_content_length\":230,\"starttransfer_time\":0.11869,\"redirect_time\":0,\"redirect_url\":\"\",\"primary_ip\":\"104.28.3.185\",\"certinfo\":[],\"primary_port\":443,\"local_ip\":\"172.18.0.3\",\"local_port\":58702}}";
//		String json = "{\"req\":{\"payload\":{\"function_id\":\"1\",\"region\":\"global\",\"profile_id\":\"0\",\"user_email\":\"SdQKoJinGRiLZIr8yv98JcGFgg2vbXnkyhrjYwFiokw=\",\"user_pwd\":\"AQBd/yrhak8SYrliKmK+drwllH0grPTB4e/o+jHKJDw=\",\"pa_key\":\"fttest00000001\",\"customer_code\":\"Fanten\",\"project_code\":\"fantentest1\"}},\"res\":{\"head\":{\"Date\":\"Fri, 12 May 2017 02\",\"Content-Type\":\"application/json; charset=utf-8\",\"Transfer-Encoding\":\"chunked\",\"Connection\":\"keep-alive\",\"Set-Cookie\":\"__cfduid=d752e3c98bdd3bf3872ec182da2fa2c1e1494557743; expires=Sat, 12-May-18 02\",\"X-Powered-By\":\"PHP/7.1.3\",\"Access-Control-Allow-Origin\":\"*\",\"Server\":\"cloudflare-nginx\",\"CF-RAY\":\"35da19c76c84332b-HKG\"},\"body\":{\"result_code\":1,\"result_des\":\"Request Processed\",\"result_data\":{\"region\":{\"0\":\"GLOBAL\",\"1\":\"ASIA\",\"2\":\"EU\",\"3\":\"JP\",\"4\":\"US\"}}}}}";
		
		
		JSONObject obj = JSONObject.parseObject(json);
//		System.out.println(obj);
		
		
		JSONObject res = obj.getJSONObject("res");
		JSONObject body = res.getJSONObject("body");
		
		System.out.println(body);
	}
}
