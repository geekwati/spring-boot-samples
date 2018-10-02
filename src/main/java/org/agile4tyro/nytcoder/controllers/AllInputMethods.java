package org.agile4tyro.nytcoder.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AllInputMethods {

	@RequestMapping(value = "requestBodyAsInput", method = RequestMethod.POST)
	public String  bodyInput(@RequestBody String str) {
		return "@RequestBody type input is only applicable with Http Post method. \n& Here body = " +str;
	}
	
	@RequestMapping(value = "requestHeaderAsInput", method = RequestMethod.GET)
	public String reqHeaderInput(@RequestHeader(value = "name", required = true) String name ) {
		return "@RequestHeader type input is applicable for all Http methods. \n& Here header = " + name;
	}
	
	@RequestMapping(value = "requestParamAsInput", method = RequestMethod.GET)
	public String reqParamInput(@RequestParam(value = "param1") Long param1,
			@RequestParam(value = "param2") Long param2) {
		/*@RequestParam is used to accessing the query parameter that are separated from uri by '?'
		and parameters are separated by '&' from each other
		http://localhost:8080/requestParamAsInput?param1=10&param2=20*/
		return "@ReuestParam with Url mostly in Get method. Parameter param1 = " + param1+ " & param2 = " + param2;
	}
	
	@RequestMapping(value = "pathVariableAsInput/{id}", method = RequestMethod.GET)
	public String pathVariableInput(@PathVariable(value = "id") String id) {
		/*@PathVariable is used handle the path variable of the request
		 * @PathVariable identifies the pattern in the uri for the incoming request
		 * http://localhost:8080/pathVariableAsInput/10*/
		return "@PathVariable with Uri. PathVariable value = " + id;
	}
	
	
	
}
