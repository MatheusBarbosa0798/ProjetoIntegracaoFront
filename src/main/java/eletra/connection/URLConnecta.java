package main.java.eletra.connection;

import main.java.eletra.model.Meters;
import java.lang.reflect.Type;
import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class URLConnecta {

	private static final String GET_URL = "http://localhost:8080/api/meters";

	public static ArrayList<Meters> sendGET() throws IOException {
		ResteasyClient client = new ResteasyClientBuilder().build();
		 
		//GET
		ResteasyWebTarget getDummy = client.target(GET_URL);
		Response getDummyResponse = getDummy.request().get();
		String response = getDummyResponse.readEntity(String.class);
       
		Type listType = new TypeToken<ArrayList<Meters>>(){}.getType();
		ArrayList<Meters> meterList = new Gson().fromJson(response, listType);
       
		getDummyResponse.close(); 
		
        return meterList;
	}
}