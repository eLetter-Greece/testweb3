/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afdemp.org;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import javax.servlet.http.Cookie;

/**
 *
 * @author George.Pasparakis
 */
public class Login extends AbstractController {
    private StaticClass sc;
    
    public Login() {
        
    }
    
    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        //throw new UnsupportedOperationException("Not yet implemented");
        System.out.println(request.getParameter("name"));
        if(request.getParameter("name") != null) {
            System.out.println("logged in"); 
            sc = new StaticClass();
            sc.setUserId(1);
            sc.setJsessionid(getCookie2(request.getCookies()));
            ModelAndView mv = new ModelAndView("admin");
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("login");
            return mv;
        }
    }
    
    private String getCookie() throws IOException {
        CookieManager cookieManager = new CookieManager();
	cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
	CookieHandler.setDefault(cookieManager);
		
	//creates url for the given string 
	URL url = null;
	try {
            url = new URL("http://localhost:8084/testweb3/login.html");
            //open's a connection with the url specified and returns URLConnection object
                URLConnection  urlConnection = url.openConnection(); 
		// get's the contents from this url specifies
		urlConnection.getContent(); 
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}			
	//returns the cookie store(bunch of cookies)
	CookieStore cookieStore = cookieManager.getCookieStore();
	//getting cookies which returns in the form of List of type HttpCookie
	List<HttpCookie> listOfcookies = cookieStore.getCookies();
	String jsid = "JSESSIONID";
	for(HttpCookie httpCookie: listOfcookies){
            if(httpCookie.getName().equals(jsid)) return httpCookie.getValue();
			//System.out.println("Cookie Name : "+httpCookie.getName()+" Cookie Value : "+httpCookie.getValue());
            }
        return "";
    }
    
    private String getCookie2(Cookie[] cookies) {
	String jsid = "JSESSIONID";
	for(Cookie cookie : cookies){
            if(cookie.getName().equals(jsid)) return cookie.getValue();
			//System.out.println("Cookie Name : "+httpCookie.getName()+" Cookie Value : "+httpCookie.getValue());
            }
        return "";
    }
}
