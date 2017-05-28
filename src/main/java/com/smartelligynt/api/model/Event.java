package com.smartelligynt.api.model;

public class Event
{
    private String eu;

    private String ev;

    private String en;

    private String et;

    public String getEu ()
    {
        return eu;
    }

    public void setEu (String eu)
    {
        this.eu = eu;
    }

    public String getEv ()
    {
        return ev;
    }

    public void setEv (String ev)
    {
        this.ev = ev;
    }

    public String getEn ()
    {
        return en;
    }

    public void setEn (String en)
    {
        this.en = en;
    }

    public String getEt ()
    {
        return et;
    }

    public void setEt (String et)
    {
        this.et = et;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [eu = "+eu+", ev = "+ev+", en = "+en+", et = "+et+"]";
    }
}

