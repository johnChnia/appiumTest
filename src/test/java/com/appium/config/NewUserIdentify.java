	package com.appium.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import com.appium.utils.DBUtil;

public class NewUserIdentify {
	public static final OkHttpClient client = new OkHttpClient();
	Properties prop = new Properties();
	String sqlForGetToken = null;
	String authenticationToken = null;
	String xProductCode = null;
	String url = null;
	String filePath = null;
	String host = null;

	public NewUserIdentify() {
		try {
			prop.load(new FileInputStream("config.properties"));
			sqlForGetToken = prop.getProperty("sqlForGetToken");
			xProductCode = prop.getProperty("X-Product-Code");
			url = prop.getProperty("identify_url");
			filePath = prop.getProperty("FILE_PATH");
			host = prop.getProperty("host");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取登录token
	 * 
	 * @param mobile
	 * @return
	 */
	public String getUserToken(String mobile) {
		try {
			DBUtil.getConnection("postgres");
			authenticationToken = (String) DBUtil.queryMap(sqlForGetToken,
					mobile).get("authentication_token");
			return authenticationToken;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void identifyPost(String mobile, String docType) throws Exception {
		System.out.println("***********" + " 开始活体检测啦 " + "***********");
		System.out.println("***********" + "类型 :::: " + docType + " ***********");

		authenticationToken = getUserToken(mobile);
		File file = new File(filePath);
		MultipartBody.Builder builder = new MultipartBody.Builder()
				.setType(MultipartBody.FORM);
		builder.addPart(Headers.of("Content-Disposition",
				"form-data; name=\"resource\";filename=\"autoTest.jpg\""),
				RequestBody.create(MediaType.parse("image/png"), file));
		builder.addFormDataPart("doc_type", docType);
		RequestBody body = builder.build();
		Request request = new Request.Builder().url(url).post(body)
				.addHeader("x-user-token", authenticationToken)
				.addHeader("x-user-mobile", mobile)
				.addHeader("host", host)
				.addHeader("x-product-code", xProductCode).build();
		try {
			Response response = client.newCall(request).execute();
			if (!response.isSuccessful())
				throw new Exception("Unexpected code " + response);
			System.out.println("result :::: \n" + response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {
		String mobile = "18612347788";
		NewUserIdentify n = new NewUserIdentify();
		System.out.println(n.getUserToken(mobile));
//		n.identifyPost(mobile, "bank_card_transaction_flow_proof");
		n.identifyPost(mobile, n.prop.getProperty("docType_face_recognition"));
		n.identifyPost(mobile, n.prop.getProperty("docType_id_handheld"));
		n.identifyPost(mobile, n.prop.getProperty("docType_id_front"));
		n.identifyPost(mobile, n.prop.getProperty("docType_id_back"));
		n.identifyPost(mobile, n.prop.getProperty("docType_employment"));

	}
}
