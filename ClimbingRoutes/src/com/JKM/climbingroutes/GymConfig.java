package com.JKM.climbingroutes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GymConfig {
/*	public static String[][] gymName =
		{
			{//北部
				"STONE",
				"內湖",
				"市民",
				"北投",
				"Y17"
			}			
		 ,
			{//中部
				"B+",
				"番薯藤"
			}
		 ,
			{//南部
				"成大",
				"崑山",
				"壽中"
			}				
		};	
		*/
		
	public static List<? extends Map<String, ?>> getData() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("area", "北部");
		map.put("gymName", "Stone");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("area", "北部");
		map.put("gymName", "內湖");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("area", "北部");
		map.put("gymName", "北投");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("area", "北部");
		map.put("gymName", "市民");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("area", "北部");
		map.put("gymName", "Y17");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("area", "北部");
		map.put("gymName", "清大");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);


		map = new HashMap<String, Object>();
		map.put("area", "中部");
		map.put("gymName", "B+");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("area", "南部");
		map.put("gymName", "崑山");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("area", "南部");
		map.put("gymName", "成大");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("area", "南部");
		map.put("gymName", "壽中");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);

		
		
		return list;
	}

}
