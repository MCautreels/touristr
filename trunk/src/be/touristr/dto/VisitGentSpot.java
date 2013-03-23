package be.touristr.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 23/03/13
 * Time: 11:26
 * To change this template use File | Settings | File Templates.
 */
public class VisitGentSpot {

    private Integer id;
    private String name;
    private String subTitle;
    private String summary;
    private List<String> categories;
    private List<String> thumbs;
    private SpotContact contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public void addCategory(String category) {
        if(this.categories == null) {
            this.categories = new ArrayList<String>();
        }
        this.categories.add(category);
    }

    public List<String> getThumbs() {
        return thumbs;
    }

    public void setThumbs(List<String> thumbs) {
        this.thumbs = thumbs;
    }

    public SpotContact getContact() {
        return contact;
    }

    public void setContact(SpotContact contact) {
        this.contact = contact;
    }
}
