package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.outerlist.outerchoice;

import com.zte.sdn.oscp.persistence.annotations.Table;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.outerlist.OuterChoice;

    //interface-declare.txt
@Table
public interface One extends OuterChoice {

    String getOne();

    String getParentPath();


    /**
     *
     * @param one 
    */
    void setOne(String one);

    void setParentPath(String parentPath);


}

