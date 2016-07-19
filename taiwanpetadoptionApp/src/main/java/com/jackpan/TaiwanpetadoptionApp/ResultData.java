package com.jackpan.TaiwanpetadoptionApp;

public class ResultData implements Comparable<ResultData> {

	String animal_id;// = jsonObject.getString("animal_id");//		動物的流水編號	
	String animal_subid;//= jsonObject.getString("animal_subid");//動物的區域編號
	String animal_area_pkid;// = jsonObject.getString("animal_area_pkid");//動物所屬縣市代碼
	String animal_shelter_pkid;// = jsonObject.getString("animal_shelter_pkid");	//動物所屬收容所代碼
	String animal_place;// = jsonObject.getString("animal_place");//	動物的實際所在地		
	String animal_kind;//= jsonObject.getString("animal_kind");//動物的類型
	String animal_bodytype;// = jsonObject.getString("animal_bodytype");//動物體型	
	String album_file;// = jsonObject.getString("album_file");	//
	String animal_sex;// = jsonObject.getString("animal_sex");	//動物性別		
	String animal_colour;//= jsonObject.getString("animal_colour");//動物毛色
	String animal_age;// = jsonObject.getString("animal_age");//動物年紀
	String animal_sterilization;// = jsonObject.getString("animal_sterilization");	//是否絕育
	String animal_bacterin;// = jsonObject.getString("animal_bacterin");	//是否施打狂犬病疫苗	
	String animal_foundplace;// = jsonObject.getString("animal_foundplace");	//動物尋獲地
	String animal_status;// = jsonObject.getString("animal_status");	//動物狀態
	String animal_remark;// = jsonObject.getString("animal_remark");//	資料備註
	String animal_opendate;// = jsonObject.getString("animal_opendate");//	開放認養時間(起)
	String animal_closeddate;// = jsonObject.getString("animal_closeddate");	//開放認養時間(迄)
	String animal_update;// = jsonObject.getString("animal_update");	//動物資料異動時間
	String animal_createtime;// = jsonObject.getString("animal_bacterin");	//動物資料建立時間
	String shelter_name;// = jsonObject.getString("shelter_name");	//動物所屬收容所名稱
//	public  long startTime;

//	long startTime() {
//		return MyApi.getTime(animal_opendate);
//	}

	@Override
	public int compareTo(ResultData another) {
		return another.animal_opendate.compareToIgnoreCase(animal_opendate);
	}
}
