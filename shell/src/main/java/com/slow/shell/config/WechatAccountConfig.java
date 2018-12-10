package com.slow.shell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Slicing
 * @date 2018/12/5 21:36
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {
	/*公共平台ID*/
	private String mpAppId;
	/*公共平台密钥*/
	private String mpAppSecret;
	/*开放平台ID*/
	private String openAppId;
	/*开放平台密钥*/
	private String openAppSecret;
	/*商户ID*/
	private String mchId;
	/*商户秘钥*/
	private String mchKey;
	/*商户证书路径*/
	private String keyPath;

	/*微信支付异步通知地址*/
	private String notifyUrl;
	/*微信模板id*/
	private Map<String,String> templateId;
}
