package com.demo.buoys.BuoysDemoo.pojo.iws;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.demo.buoys.BuoysDemoo.db.entity.Buoy;

@XmlRootElement(name = "responseBuoyList")
public class ResponseBuoyList {

    private List<BuoyDataPojo> list;

    public List<BuoyDataPojo> getList() {
        return list;
    }

    public void setList(List<BuoyDataPojo> list) {
        this.list = list;
    }

}
