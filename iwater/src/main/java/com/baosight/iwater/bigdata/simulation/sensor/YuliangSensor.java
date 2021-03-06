package com.baosight.iwater.bigdata.simulation.sensor;

import org.apache.log4j.Logger;

import com.baosight.iwater.bigdata.IUserData;
import com.baosight.iwater.bigdata.simulation.IEnvironment;
import com.baosight.iwater.bigdata.simulation.RTU;
import com.baosight.iwater.bigdata.userdata.YuliangData;

public class YuliangSensor extends AbstractWaterSensor{
	private static Logger logger = Logger.getLogger(YuliangSensor.class);
	private RTU rtu;

	public YuliangSensor(IEnvironment env) {
		super(env);
		// TODO Auto-generated constructor stub
	}
	
	public YuliangSensor(IEnvironment env,RTU rtu) {
		super(env);
		this.rtu = rtu;
		// TODO Auto-generated constructor stub
	}

	@Override
	public IUserData getData() {
		double value = this.getEnvironment().getStatus();
		
		//测试数据
		if(this.rtu!=null){
			String vstr = String.valueOf(value);
			value = Double.parseDouble(vstr);
		}
		logger.debug("取得天空'"+this.getEnvironment().getName()+"'的雨量值为："+value);
		return new YuliangData(value);
	}

}
