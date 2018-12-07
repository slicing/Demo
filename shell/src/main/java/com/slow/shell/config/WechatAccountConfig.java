package com.slow.shell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Slicing
 * @date 2018/12/5 21:36
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {
	private String mpAppId;
	private String mpAppSecret;
	/*商户ID*/
	private String mchId;
	/*商户秘钥*/
	private String mchKey;
	/*商户证书路径*/
	private String keyPath;

	/*微信支付异步通知地址*/
	private String notifyUrl;
}
