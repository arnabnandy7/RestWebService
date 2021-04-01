package com.webServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/TestService")
public class testServiceServlet {
	@GET
	@Path("/sample")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HashMap<Integer, String>> getText() {
		List<HashMap<Integer, String>> strList = new ArrayList<HashMap<Integer, String>>();
		HashMap<Integer, String> strMap = new HashMap<Integer, String>();
		strMap.put(1, "hi");
		strMap.put(2, "this");
		strMap.put(3, "is");
		strMap.put(4, "my");
		strMap.put(5, "first");
		strMap.put(6, "REST");
		strMap.put(7, "service");
		strList.add(strMap);
		strMap = new HashMap<Integer, String>();
		strMap.put(1, "testing");
		strMap.put(2, "is");
		strMap.put(3, "successful");
		strMap.put(4, "with");
		strMap.put(5, "multiple");
		strMap.put(6, "hashmap");
		strMap.put(7, "entries");
		//strMap.put(8, "entries");
		strList.add(strMap);
		return strList;
	}
	
	@GET
	@Path("/sample1")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getText1() {
		List<String> strList = new ArrayList<String>();
		strList.add("hi this is my first REST service");
		return strList;
	}



	@OPTIONS
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	public String getSupportedOperations() {
		return "<operations>GET, PUT, POST, DELETE</operations>";
	}

}
