package com.smartelligynt.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Axis {

	private String interval;

	@JsonProperty("attr")
    private Attribute attr;

    public String getInterval ()
    {
        return interval;
    }

    public void setInterval (String interval)
    {
        this.interval = interval;
    }

    public Attribute getAttr ()
    {
        return attr;
    }

    public void setAttr (Attribute attr)
    {
        this.attr = attr;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [interval = "+interval+", attr = "+attr+"]";
    }
}
