package org.intuit.com.QA;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import com.google.gson.Gson;

public class Add_Data {
	
	public void add()
	
	{
		try{ CloseableHttpClient httpclient = null;
    HttpPost postRequest = null;
    HttpGet getRequest = null;
    StringEntity input = null;
    HttpResponse response = null;
    HttpResponse responseget = null;
    HttpEntity entity = null;
JSONObject jsonObject = null;
    CredentialsProvider provider = new BasicCredentialsProvider();
    //replace the username, password
    UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("username", "password");
    provider.setCredentials(AuthScope.ANY, credentials);
    httpclient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
    testdata one= new testdata("ThroughJavacodeaddtest","New");
   //replace with your server URL and project id(98173)
    postRequest = new HttpPost("https://qacomplete.smartbear.com/rest-api/service/api/v1/projects/98173/tests");
    Gson  gson  = new Gson();
    StringEntity postingString = new StringEntity(gson.toJson(one));//gson.tojson() converts your pojo to json
    postRequest.setEntity(postingString);
    postRequest.setHeader("Content-type", "application/json");
    response = httpclient.execute(postRequest);
    StatusLine status = response.getStatusLine();
    System.out.println(status);} 
		catch(Exception e){}
		}
	}
	