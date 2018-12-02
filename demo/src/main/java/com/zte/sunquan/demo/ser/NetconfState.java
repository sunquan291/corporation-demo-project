/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package com.zte.sunquan.demo.ser;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.zte.sunquan.demo.Schema;
import com.zte.sunquan.demo.Schemas;

import javax.annotation.Nullable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement(name = "ABC")
public final class NetconfState {

    private Schemas schemas;

    public NetconfState() {
    }

    @XmlElementWrapper(name = "schemas")
    @XmlElement(name = "schema")
    public Collection<String> getSchemas() {
        return Collections2.transform(schemas.getSchema(),
                new Function<Schema, String>() {
                    @Nullable
                    @Override
                    public String apply(@Nullable final Schema input) {
                        return input.toString();
                    }
                });
    }
}
