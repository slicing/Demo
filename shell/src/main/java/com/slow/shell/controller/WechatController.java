package com.slow.shell.controller;

import com.slow.shell.config.ProjectUrlConfig;
import com.slow.shell.enums.ResultEnum;
import com.slow.shell.exception.SellException;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;

/**
 * @author Slicing
 * @date 2018/12/5 20:29
 */
@Controller
@RequestMapping("/wechat")
public class WechatController {
	@Autowired
	private WxMpService wxMpService;
	@Autowired
	private WxMpService wxOpenService;
	@Autowired
	private ProjectUrlConfig projectUrlConfig;

	@GetMapping("/authorize")
	public String authorize(@RequestParam("returnUrl") String returnUrl) {
		String url = projectUrlConfig.getWechatMpAuthorize() + "";
		String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_USER_INFO, URLEncoder.encode(returnUrl));
		return redirectUrl;

	}

	@GetMapping("/userInfo")
	public String userInfo(@RequestParam("code") String code,
						   @RequestParam("code") String returnUrl) {
		WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
		try {
			wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
		} catch (WxErrorException e) {
			throw new SellException(ResultEnum.WX_MP_ERROR.getCode(), e.getError().getErrorMsg());
		}
		String openId = wxMpOAuth2AccessToken.getOpenId();
		return "redirect:" + returnUrl + "?openid=" + openId;
	}

	@GetMapping("/qrAuthorize")
	public String qrAuthorize(@RequestParam("returnUrl") String returnUrl){
		String url = projectUrlConfig.getWechatOpenAuthorize() + "";
		String redirectUrl = wxOpenService.oauth2buildAuthorizationUrl(url, WxConsts.QRCONNECT_SCOPE_SNSAPI_LOGIN, URLEncoder.encode(returnUrl));
		return redirectUrl;
	}

	@GetMapping("/qruserInfo")
	public String qrUserInfo(@RequestParam("code") String code,
						   @RequestParam("code") String returnUrl) {
		WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
		try {
			wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
		} catch (WxErrorException e) {
			throw new SellException(ResultEnum.WX_MP_ERROR.getCode(), e.getError().getErrorMsg());
		}
		String openId = wxMpOAuth2AccessToken.getOpenId();
		return "redirect:" + returnUrl + "?openid=" + openId;
	}
}
