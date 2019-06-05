package com.dambarbahadurpun.android.androidringtonetest;

import java.io.Serializable;

public class RingtoneItem implements Serializable {

    private String title;
    private String uri;

    public RingtoneItem(String title, String uri) {
        this.title = title;
        this.uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public String getUri() {
        return uri;
    }
}
