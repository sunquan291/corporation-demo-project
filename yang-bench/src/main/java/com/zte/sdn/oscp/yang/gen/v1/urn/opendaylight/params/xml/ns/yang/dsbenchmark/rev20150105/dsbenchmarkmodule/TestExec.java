package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.OuterList;
import com.zte.sdn.oscp.persistence.annotations.Table;
import java.util.Set;

@Table
public interface TestExec {

    Set<OuterList> getOuterList();

    //OuterList getFromOuterList(String key);
    OuterList getFromOuterList(Integer id);
    String getParentPath();


    void  setOuterList(Set<OuterList> outerList);

    void setParentPath(String parentPath);


    void addToOuterList(OuterList addTo);



    void removeFromOuterList(Integer id);

}

