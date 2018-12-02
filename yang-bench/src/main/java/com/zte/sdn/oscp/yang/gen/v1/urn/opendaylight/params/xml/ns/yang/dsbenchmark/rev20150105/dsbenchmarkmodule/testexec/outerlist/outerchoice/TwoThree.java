package com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.outerlist.outerchoice;

import com.zte.sdn.oscp.persistence.annotations.Table;

import com.zte.sdn.oscp.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.dsbenchmark.rev20150105.dsbenchmarkmodule.testexec.outerlist.OuterChoice;

    //interface-declare.txt
@Table
public interface TwoThree extends OuterChoice {

    String getTwo();

    String getThree();

    String getParentPath();


    /**
     *
     * @param two 
    */
    void setTwo(String two);

    /**
     *
     * @param three 
    */
    void setThree(String three);

    void setParentPath(String parentPath);


}

