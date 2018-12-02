package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.outerlist.InnerList;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.outerlist.outerchoice.TwoThree;
import com.zte.sdn.oscp.persistence.annotations.Table;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.outerlist.outerchoice.One;
import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.outerlist.OuterChoice;
import java.util.Set;

@Table
public interface OuterList {

    Integer getId();

    One getOne();

    TwoThree getTwoThree();

    Set<InnerList> getInnerList();

    //InnerList getFromInnerList(String key);
    InnerList getFromInnerList(Integer name);
    String getParentPath();


    /**
     *
     * @param id 
    */
    void setId(Integer id);

    void setOne(One One);

    void setTwoThree(TwoThree TwoThree);

    void  setInnerList(Set<InnerList> innerList);

    void setParentPath(String parentPath);


    void addToInnerList(InnerList addTo);



    void removeFromInnerList(Integer name);

}

