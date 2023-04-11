package com.shinhan.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class SessionListener implements HttpSessionListener {
	int total_user; // 리스너는 서버 실행 시 생성되니까!

    public SessionListener() {
        System.out.println("SessionListener 생성자");
    }

	
    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println("Browser가 이 서버에 접속함!");
         total_user++;
         System.out.println(total_user + "번째 Browser가 접속!");
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	// 서버에서 세션을 지우려면 invalidate를 해야 함 -> 웹사이트 쿠키 세션 지운다고 되지 않아!
    	System.out.println("Browser가 이 서버에서 나감.. (접속 해제)");
    	total_user--;
    }
	
}
