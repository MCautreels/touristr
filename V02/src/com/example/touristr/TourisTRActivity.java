package com.example.touristr;

import java.util.List;

import org.json.JSONException;

import com.example.touristr.dao.VisitGentDaoImpl;
import com.example.touristr.dto.VisitGentSpot;

import android.app.Activity;
import android.os.Bundle;

public class TourisTRActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touris_tr);
        //VisitGentDaoImpl dao = new VisitGentDaoImpl();
        //try {
		//	List<VisitGentSpot> list = dao.getAllVisitGentSpots();
		//} catch (JSONException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
    }
    
}
