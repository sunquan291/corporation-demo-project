package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.outerlist;

import com.zte.sdn.oscp.persistence.annotations.Table;

@Table
public interface InnerList {

    Integer getName();

    String getValue();

    String getParentPath();


    /**
     *
     * @param name 
    */
    void setName(Integer name);

    /**
     *
     * @param value 
    */
    void setValue(String value);

    void setParentPath(String parentPath);


}

