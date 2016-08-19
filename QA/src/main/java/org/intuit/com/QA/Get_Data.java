package org.intuit.com.QA;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class Get_Data {
	
	public void get()
	
	{
		try{ 
			CloseableHttpClient httpclient = null;
			HttpPost postRequest = null;
			HttpGet getRequest = null;
			StringEntity input = null;
			HttpResponse response = null;
			HttpEntity entity = null;
	    	JSONObject jsonObject = null;
			CredentialsProvider provider = new BasicCredentialsProvider();
			//replace with your username and password
			UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("username", "password");
			provider.setCredentials(AuthScope.ANY, credentials);
			httpclient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
			 
			
			//httpclient = HttpClients.createDefault();
	    	
	    	//replace with your server url
			getRequest = new HttpGet("https://qacomplete.smartbear.com/rest-api/service/api/v1/projects?offset=0&limit=25");
			response = httpclient.execute(getRequest);
			entity = response.getEntity();
			String str1 = EntityUtils.toString(entity);
			jsonObject = new JSONObject(str1);
			jsonObject = jsonObject.getJSONObject("metadata");
	    	jsonObject = jsonObject.getJSONObject("result_set");
	    	System.out.println(jsonObject.getString("count"));
	    	
		}
		catch(Exception e){}
	}}