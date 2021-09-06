package org.alex.data;

public class Advertisement {
    private final String URL;

    public Advertisement(String url) {
        this.URL = url;
    }

    public String getURL() {
        return URL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Advertisement that = (Advertisement) o;

        return URL != null ? URL.equals(that.URL) : that.URL == null;
    }

    @Override
    public int hashCode() {
        return URL != null ? URL.hashCode() : 0;
    }
}
