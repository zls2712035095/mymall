package com.zls.api.common;

import com.baidu.aip.face.AipFace;

/**
 * 单例加载百度SDK
 *
 */
public class AIFactoryUtil {
	private static AipFace aipFace;

	public static AipFace getAipFace(){
		if(aipFace==null){
			synchronized (AipFace.class) {
				if(aipFace==null){
					aipFace = new AipFace(AIConstant.BD_FACE_APPID, AIConstant.BD_FACE_APIKEY, AIConstant.BD_FACE_SECRETKEY);
				}
			}
		}
		return aipFace;
	}

}
