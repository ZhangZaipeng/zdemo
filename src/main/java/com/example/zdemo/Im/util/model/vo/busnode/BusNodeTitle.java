/**
 * 
 */
package com.example.zdemo.Im.util.model.vo.busnode;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 业务节点数据标题实体类
 * 
 * @ClassName: BusNodeConts
 * @author huangzg 2017年1月13日 上午10:12:49
 */
public class BusNodeTitle {

	/** 业务节点消息数据 */
	@JSONField(name = "Data")
	private Object data;

	public BusNodeTitle() {
		super();
	}

	public BusNodeTitle(Object data) {
		super();
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "BusNodeTitle [data=" + data + "]";
	}

}
