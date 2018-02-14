package com.example.samim.json_recylerview_cardview.Item;

/**
 * Created by SAMIM on 2/13/2018.
 */

public class ListItem {
    private String name;
    private String team;
    private String imageUrl;

    public ListItem(String name, String team,String imgUrl) {
        this.name = name;
        this.team = team;
        this.imageUrl=imgUrl;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
