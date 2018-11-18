/**
 * 
 */
package com.example.zdemo.Im.util.model.vo;

/**
 * 消息类型
 * 
 * 1.Text （文字） ， msgType 1	（前）
 * 2.Image （图片），msgType 2	（前）
 * 3.Sound （语音消息），msgType 14
 * 4.Report（胎心解读，B超报告，乳腺报告，产检报告）, msgType 13 （前）
 * 5.RefuseProblem（医生拒绝咨询）msgType 12
 * 6.Remind（图文咨询，私人医生提醒消息）msgType 11 （前）
 * 7.Backout（回撤），msgType  
 * 8.SystemMsg 除以上消息以外的消息统一为系统消息 msgType 99
 */
public class MsgType {

	/** 文本消息 */
	public static final String TIMTEXTELEM = "TIMTextElem";

	/** 自定义消息 */
	public static final String TIMCUSTOMELEM = "TIMCustomElem";

	/** 语音消息 */
	public static final String TIMSOUNDELEM = "TIMSoundElem";

	/** 图片消息 */
	public static final String TIMIMAGEELEM = "TIMImageElem";
	
	public static String getStringType(short type){
		if (type == 1) {
			return "TIMTextElem";
		} else if (type == 2) {
			return "TIMImageElem";
		} else if (type == 14) {
			return "TIMSoundElem";
		} else {
			return "TIMCustomElem";
		}
	}

}
