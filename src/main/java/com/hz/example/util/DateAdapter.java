package com.hz.example.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import javax.xml.bind.annotation.adapters.XmlAdapter;
 
public class DateAdapter extends XmlAdapter<String, Date> {
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS");
 
    @Override
    public Date unmarshal(String val) throws Exception {
        if (val == null) {
            return null;
        }
        return df.parse(val);
    }
 
    @Override
    public String marshal(Date val) throws Exception {
        if (val == null) {
            return null;
        }
        return df.format(val);
    }
}