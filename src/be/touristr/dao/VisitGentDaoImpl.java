package be.touristr.dao;

import be.touristr.dto.SpotContact;
import be.touristr.dto.VisitGentSpot;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 23/03/13
 * Time: 11:20
 * To change this template use File | Settings | File Templates.
 */
public class VisitGentDaoImpl implements VisitGentDao {

    private String readVisitGentSpots() {
        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://datatank.gent.be/Toerisme/VisitGentSpots.json");
        try {
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
            } else {
               // Log.e(VisitGentDaoImpl.class.toString(), "Failed to download file");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    @Override
    public List<VisitGentSpot> getAllVisitGentSpots() throws JSONException {
        List<VisitGentSpot> spots = new ArrayList<VisitGentSpot>();

        JSONArray jsonArray = new JSONObject(readVisitGentSpots()).getJSONArray("VisitGentSpots");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            spots.add(mapVisitGentSpot(jsonObject));
        }

        return spots;
    }

    private VisitGentSpot mapVisitGentSpot(JSONObject jsonObject) throws JSONException {
        VisitGentSpot visitGentSpot = new VisitGentSpot();

        visitGentSpot.setId(jsonObject.getInt("id"));
        visitGentSpot.setName(jsonObject.getString("title"));
        visitGentSpot.setSubTitle(jsonObject.getString("subtitle"));
        visitGentSpot.setSummary(jsonObject.getString("summary"));

        visitGentSpot.setThumbs(mapListOfStrings(jsonObject.getJSONArray("thumbs")));
        visitGentSpot.setCategories(mapListOfStrings(jsonObject.getJSONArray("category")));

        try {
            visitGentSpot.setContact(mapContact(jsonObject.getJSONArray("contact").getJSONObject(0)));
        } catch(Exception e) {

        }

        return visitGentSpot;
    }

    private SpotContact mapContact(JSONObject contact) throws JSONException {
        SpotContact spotContact = new SpotContact();

        spotContact.setName(contact.getString("contact"));
        spotContact.setStreet(contact.getString("street"));
        spotContact.setCity(contact.getString("city"));
        spotContact.setNumber(contact.getString("number"));
        spotContact.setPersonName(contact.getString("name"));

        return spotContact;
    }

    private List<String> mapListOfStrings(JSONArray jsonArray) throws JSONException {
        List<String> strings = new ArrayList<String>();

        for(int i = 0; i < jsonArray.length(); i++) {
            strings.add(jsonArray.getString(i));
        }

        return strings;
    }
}
