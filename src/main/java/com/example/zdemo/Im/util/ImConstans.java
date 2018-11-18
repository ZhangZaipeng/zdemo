package com.example.zdemo.Im.util;

import org.springframework.beans.factory.annotation.Value;

/**
 * IM 公共常量
 * @ClassName: ImConstans
 * @author huangzg 2016年11月24日 上午10:53:41
 */
public class ImConstans {

	private static String SIG;

	private static String SDK_APPID;

	/** 导入IM用户相关资料 **/
	public final static String ACCOUNT_IMPORT = "https://console.tim.qq.com/v4/im_open_login_svc/account_import?usersig="+SIG+"&identifier=admin&sdkappid="+SDK_APPID+"&random=0123456789&contenttype=json";
	
	/** 添加好友 **/
	public final static String FRIEND_IMPORT = "https://console.tim.qq.com/v4/sns/friend_import?usersig="+SIG+"&identifier=admin&sdkappid="+SDK_APPID+"&random=0123456789&contenttype=json";
	
	/** 添加黑名单　*/
	public final static String ADD_BLACK = "https://console.tim.qq.com/v4/sns/black_list_add?usersig="+SIG+"&identifier=admin&sdkappid="+SDK_APPID+"&random=0123456789&contenttype=json";
	
	/** 删除黑名单　*/
	public final static String DEL_BLACK = "https://console.tim.qq.com/v4/sns/black_list_delete?usersig="+SIG+"&identifier=admin&sdkappid="+SDK_APPID+"&random=0123456789&contenttype=json";
	
	/** 拉取好友列表 **/
	public final static String FRIEND_GET_ALL = "https://console.tim.qq.com/v4/sns/friend_get_all?usersig="+SIG+"&identifier=admin&sdkappid="+SDK_APPID+"&random=0123456789&contenttype=json";

	/** 发送消息 **/
	public final static String SEND_MSG = "https://console.tim.qq.com/v4/openim/sendmsg?usersig="+SIG+"&identifier=admin&sdkappid="+SDK_APPID+"&random=0123456789&contenttype=json";
	
	/** 发送群消息 **/
	public final static String SEND_GROUP_MSG = "https://console.tim.qq.com/v4/group_open_http_svc/send_group_msg?usersig="+SIG+"&identifier=admin&sdkappid="+SDK_APPID+"&random=0123456789&contenttype=json";

	/** 获取个人资料 **/
	public final static String PORTRAIT_GET = "https://console.tim.qq.com/v4/profile/portrait_get?usersig="+SIG+"&identifier=admin&sdkappid="+SDK_APPID+"&random=0123456789&contenttype=json";
	
	/** 设置个人资料 **/
	public final static String PORTRAIT_SET = "https://console.tim.qq.com/v4/profile/portrait_set?usersig="+SIG+"&identifier=admin&sdkappid="+SDK_APPID+"&random=0123456789&contenttype=json";
	
	/** 拉取个人资料 **/
	public final static String ACCOUNT_GET = "https://console.tim.qq.com/v4/profile/portrait_get?usersig="+SIG+"&identifier=admin&sdkappid="+SDK_APPID+"&random=99999999&contenttype=json";
	
	public final static String SUC_ = "OK";
	
	public final static String FAIL_ = "FAIL";
	
	public static final String DATA = "conts";
	
	public static final String PAGE_NO = "pageNo";
	
	public static final String PAGE_SIZE = "pageSize";
	
	public static final String TOTAL = "total";
	
	public static final String PAGES = "pages";
	
	public static final int PAGESIZE = 20;

	@Value("${SIG}")
	public static void setSIG(String SIG) {
		ImConstans.SIG = SIG;
	}

	@Value("${SDK_APPID}")
	public static void setSdkAppid(String sdkAppid) {
		SDK_APPID = sdkAppid;
	}
}
