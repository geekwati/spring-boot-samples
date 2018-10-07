
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
    /*Get method is used to retrieve resource from server. It doesn't change state of resource in any way.
     * that's why it is safe method. And it should be idempotent means get method should return same state of resource 
     * when we make multiple request of that call untill another api (post or put) change the staate of resource*/
    public String getMethod() {
    	return "Http Get Method";
    }
    
    @RequestMapping(value = "postmethod", method = RequestMethod.POST)
    public void postMethod(@RequestBody String str) {
    	System.out.println("Post Method = "+ str);
    }
    
    @RequestMapping(value= "putmethod", method = RequestMethod.PUT)
    //put method is used for update
    public String putMethod() {
    	return "Put Http Method";
    }
    
    @RequestMapping(value = "deletemethod", method = RequestMethod.DELETE)
    public Boolean deleteMethod() {
    	return true;
    }
}