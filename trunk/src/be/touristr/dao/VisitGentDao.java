package be.touristr.dao;

import be.touristr.dto.VisitGentSpot;
import org.json.JSONException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 23/03/13
 * Time: 11:20
 * To change this template use File | Settings | File Templates.
 */
public interface VisitGentDao {

    List<VisitGentSpot> getAllVisitGentSpots() throws JSONException;
}
