package com.slow.shell.config;

import org.apache.catalina.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author Slicing
 * @date 2018/12/10 20:58
 */
@Component
public class WebSocketConfig {
	@Bean
	public ServerEndpointExporter serverEndpointExporter(){
		return new ServerEndpointExporter();
	}
}
