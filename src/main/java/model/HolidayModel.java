package model;

import com.google.gson.annotations.SerializedName;

public class HolidayModel {

    private String date;
    private String name;
    private String link;
    private String type;
    private String description;
    @SerializedName("type_code")
    private String typeCode;

    public HolidayModel() {
    }

    public HolidayModel(String date, String name, String link, String type, String description, String typeCode) {
        this.date = date;
        this.name = name;
        this.link = link;
        this.type = type;
        this.description = description;
        this.typeCode = typeCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    @Override
    public String toString() {
        return "date = "+date+"\n" +
                "name = "+name+"\n" +
                "link = "+link+"\n" +
                "type = "+type+"\n" +
                "description = "+description+"\n" +
                "typeCode = "+typeCode;
    }
}
