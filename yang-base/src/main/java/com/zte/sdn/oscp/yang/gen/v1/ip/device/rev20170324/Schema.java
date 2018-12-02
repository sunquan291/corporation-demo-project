package com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20170324;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * Created by 10184538 on 2017/10/18.
 */
public class Schema {
    private String identifier;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @XmlRootElement(name = "ABC")
    public static final class NetconfState {

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
}
