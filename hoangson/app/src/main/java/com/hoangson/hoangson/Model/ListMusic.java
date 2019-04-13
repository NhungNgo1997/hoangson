package com.hoangson.hoangson.Model;

import java.io.Serializable;

public class ListMusic implements Serializable {
    int id;
    private String namemusic,namesinger;
    private int link;

    public ListMusic(int id, String namemusic, String namesinger, int link) {
        this.id = id;
        this.namemusic = namemusic;
        this.namesinger = namesinger;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public String getNamemusic() {
        return namemusic;
    }

    public void setNamemusic(String namemusic) {
        this.namemusic = namemusic;
    }

    public String getNamesinger() {
        return namesinger;
    }

    public void setNamesinger(String namesinger) {
        this.namesinger = namesinger;
    }

    public int getLink() {
        return link;
    }

    public void setLink(int link) {
        this.link = link;
    }
}
