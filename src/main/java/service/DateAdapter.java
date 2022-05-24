package service;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDateTime;

public class DateAdapter extends XmlAdapter<String, LocalDateTime> {

    @Override
    public LocalDateTime unmarshal(String v){
        return LocalDateTime.parse(v);
    }

    @Override
    public String marshal(LocalDateTime v){
        return v.toString();
    }
}
