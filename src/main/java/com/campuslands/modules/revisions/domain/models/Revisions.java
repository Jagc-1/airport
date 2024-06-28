package com.campuslands.modules.revisions.domain.models;

public class Revisions {

    int id;
    String revision_date;
    int id_plane;

    public Revisions(int id, String revision_date, int id_plane) {
        this.id = id;
        this.revision_date = revision_date;
        this.id_plane = id_plane;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRevision_date() {
        return revision_date;
    }

    public void setRevision_date(String revision_date) {
        this.revision_date = revision_date;
    }

    public int getId_plane() {
        return id_plane;
    }

    public void setId_plane(int id_plane) {
        this.id_plane = id_plane;
    }

}
