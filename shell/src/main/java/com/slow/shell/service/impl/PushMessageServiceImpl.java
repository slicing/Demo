package com.slow.shell.service.impl;

import com.slow.shell.config.WechatAccountConfig;
import com.slow.shell.dto.OrderDto;
import com.slow.shell.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Slicing
 * @date 2018/12/10 20:04
 */
@Service
@Slf4j
public class PushMessageServiceImpl implements PushMessageService {

	@Autowired
	private WxMpService wxMpService;
	@Autowired
	private WechatAccountConfig config;
	@Override
	public void orderStatus(OrderDto orderDto) {
		WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
		templateMessage.setTemplateId(config.getTemplateId().get("orderStatus"));
		templateMessage.setToUser(orderDto.getOrderId());
		List<WxMpTemplateData> data = Arrays.asList(
				new WxMpTemplateData("first","亲，请记得收货"),
				new WxMpTemplateData("keyword1","微信点餐"),
				new WxMpTemplateData("keyword2","188688812456"),
				new WxMpTemplateData("keyword3",orderDto.getOrderId()),
				new WxMpTemplateData("keyword4",orderDto.getOrderStatusEnum().getMsg()),
				new WxMpTemplateData("keyword5","￥" + orderDto.getOrderAmount()),
				new WxMpTemplateData("remark","欢迎再次光临！")
				);
		templateMessage.setData(data);
		try {
			wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
		}catch (WxErrorException e){
			log.error("【微信模板消息】发送失败，{}",e);
		}

	}
}
