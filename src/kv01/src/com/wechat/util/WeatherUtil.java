package com.wechat.util;

import java.util.List;

import com.google.gson.Gson;
import com.wechat.dto.weather.WeatherData;
import com.wechat.dto.weather.WeatherDto;
import com.wechat.dto.weather.WeatherInfo;

/**
 * 百度天气预报
 * @类名	weatherutil.java
 */
public class WeatherUtil {

	private static final String URL = "http://api.map.baidu.com/telematics/v3/weather?location=CITY&output=json&ak=KEY";
	private static final String KEY = "8r49aUUBvq15d9fNcEzpUMX7";
	
	public static void main(String[] args) {
		String s = getWeather("西安");
		System.out.println(s);
	}
	
	/**
	 * 天气API
	 * @param city
	 * @return
	 */
	public static String getWeather(String city){
		if (StringUtil.isEmpty(city)){
			return null;
		}
		city = HttpUtil.urlEncodeUTF8(city);
		String json = HttpUtil.httpGet(URL.replace("CITY", city).replace("KEY", KEY));
		
		WeatherDto dto = new Gson().fromJson(json, WeatherDto.class);
		if (dto == null){
			return null;
		}
		StringBuffer buffer = new StringBuffer();
		List<WeatherInfo> results = dto.getResults();
		if (results != null && results.size() > 0){
			buffer.append("天气预报查询").append("\n\n");
			WeatherInfo result = results.get(0);
			if (result != null){
				buffer.append("城市：").append(result.getCurrentCity()).append("\n");
				buffer.append("pm2.5：").append(result.getPm25()).append("\n");
				
				List<WeatherData> weather_data = result.getWeather_data();
				if (weather_data != null && weather_data.size() > 0){
					for (WeatherData data : weather_data) {
						buffer.append("【").append(data.getDate()).append("】").append("\n");
						buffer.append("天气：").append(data.getWeather()).append("\n");
						buffer.append("风力：").append(data.getWind()).append("\n");
						buffer.append("温度：").append(data.getTemperature()).append("\n");
					}
				}
			}
		}
		return buffer.toString();
	}
}
