package com.slow.shell.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Slicing
 * @date 2018/12/10 21:00
 */
@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {
	private Session session;
	private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();
	@OnOpen
	public void opOpen(Session session){
		this.session = session;
		webSockets.add(this);
		log.info("【webSocket消息】 有新的连接，总数：{}",webSockets.size());
	}

	@OnClose
	public void onClose(){
		webSockets.remove(this);
		log.info("【webSocket消息】 断开连接，总数：{}",webSockets.size());
	}

	@OnMessage
	public void onMessage(String message){
		log.info("【webSocket消息】 收到客户端发来的消息:{}",message );
	}

	public void sendMessage(String message){
		for (WebSocket webSocket : webSockets){
			log.info("【webSocket消息】 广播消息，message={}",message);
			try {
				webSocket.session.getBasicRemote().sendText(message);
			}catch (Exception e){
				e.printStackTrace();
			}

		}
	}
}
