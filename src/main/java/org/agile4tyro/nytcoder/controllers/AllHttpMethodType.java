
package org.agile4tyro.nytcoder.controllers;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllHttpMethodType {
	
	
    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }
    
    @RequestMapping(value ="getmethod", method = RequestMethod.GET)
    public String getMethod() {
    	return "Http Get Method";
    }
    
    @RequestMapping(value = "postmethod", method = RequestMethod.POST)
    public void postMethod(@RequestBody String str) {
    	System.out.println("Post Method = "+ str);
    }
    
    @RequestMapping(value= "putmethod", method = RequestMethod.PUT)
    //public String putMethod(@RequestBody Long number) {
    public String putMethod() {
    	return "Put Http Method";
    }
    
    @RequestMapping(value = "deletemethod", method = RequestMethod.DELETE)
    public Boolean deleteMethod() {
    	return true;
    }
}