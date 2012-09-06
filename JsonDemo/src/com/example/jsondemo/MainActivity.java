package com.example.jsondemo;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.support.v4.app.NavUtils;

public class MainActivity extends ListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/** Hashmap for ListView **/
		ArrayList<HashMap<String, String>> reportList = new ArrayList<HashMap<String, String>>();

		/** Parser JSON data **/
		String reports = " "
				+ "{"
				+ "   \"reports\": ["
				+ "       {"
				+ "               \"id\": \"1\","
				+ "               \"name\": \"Report 11\","
				+ "               \"description\": \"Report 1 description\"        "
				+ "       },"
				+ "       {"
				+ "               \"id\": \"2\","
				+ "               \"name\": \"Report 22\","
				+ "               \"description\": \"Report 2 description\"    "
				+ "       }" + " ]" + "}		";
		try {
			/** Mockup data **/
//			JSONObject json = new JSONObject( reports );
			
			/** Get data from Internet **/
			JSONObject json = new JSONObject(DataUtil.getDataFromURL());			
			
			
			JSONArray jsonArray = json.getJSONArray("reports");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String id = jsonObject.getString("id");
				String name = jsonObject.getString("name");
				String description = jsonObject.getString("description");

				/** Add data to hashmap **/
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("name", name);
				map.put("id", id);
				reportList.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		/** Update data in ListView **/
		ListAdapter adapter = new SimpleAdapter(this, reportList,
				R.layout.list_report, new String[] { "name", "id" }, new int[] {
						R.id.name, R.id.id });
		setListAdapter(adapter);

	}
}
