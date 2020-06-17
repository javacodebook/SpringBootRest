/*
 * How Rest Controller works internally ?
 * 
 *  Start :-  The moment we call SpringBoot Main Application we are calling  SpringApplication.run(String...) method
 *  
 *  Creating Application Context (AnnotationConfigServletWebServerApplicationContext) :- There we will initialize the ApplicationContext  then later we will go for refresh the event on application context .
 *  
 *  Calling Application Context life cycle  Refresh Method :-  Later it calls the refresh method in  AnnotationConfigServletWebServerApplicationContext(ServletWebServerApplicationContext).refresh() line: 143	
 *  
 *  Initiating All request mapping :- Now , It will start initiating the mapping of all requests in RequestMappingHandlerMapping(AbstractHandlerMethodMapping<T>).initHandlerMethods() line: 217	
 *  
 *  Scanning the Beans :-  we will get the all annotated beans from  getCandidateBeanNames methods in RequestMappingHandlerMapping   from RequestMappingHandlerMapping filed
 *    
 *  Processing all the Beans :- its time to process all beans  processCandidateBean  from RequestMappingHandlerMapping
 *
 * Register mapping :- we will register which  request is mapping which method RequestMappingHandlerMapping.registerHandlerMethod(Object, Method, RequestMappingInfo) line: 378	
 *
 * Where we will store this mapping  :- this.mappingRegistry.register RequestMappingHandlerMapping(AbstractHandlerMethodMapping<T>).registerHandlerMethod(Object, Method, T) line: 318	

*  Register the mapping  :- AbstractHandlerMethodMapping$MappingRegistry.register(T, Object, Method) line: 614	

 * Adding the mapping to nameLookup  :- addMappingName  AbstractHandlerMethodMapping$MappingRegistry.addMappingName(String, HandlerMethod) line: 652	

*    --------------------------------------------- End ---------------------------------------
*  
*  
*  How request will be mapped to method to invoke ?
*  
*  
*  lookupHandlerMethod :- RequestMappingHandlerMapping(AbstractHandlerMethodMapping<T>).lookupHandlerMethod(String, HttpServletRequest) line: 385	

 */

package com.learnjava.springboot.restservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(path = "/healthcheck")
	public String healthCheck() {
		return "ok";
	}

}
