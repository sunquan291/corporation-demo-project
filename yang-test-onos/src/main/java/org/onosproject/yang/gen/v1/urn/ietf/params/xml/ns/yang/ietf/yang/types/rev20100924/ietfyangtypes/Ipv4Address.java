/*
 * Copyright 2017-present Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.onosproject.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.yang.types.rev20100924.ietfyangtypes;

import java.util.Objects;

/**
 * Represents the implementation of ipv4Address.
 */
public final class Ipv4Address {

    private String string;

    /**
     * Creates an instance of ipv4Address.
     */
    private Ipv4Address() {
    }

    /**
     * Creates an instance of string.
     *
     * @param string value of string
     */
    public Ipv4Address(String string) {
        this.string = string;
    }

    /**
     * Returns the object of ipv4Address for type string.
     *
     * @param value value of ipv4Address for type string
     * @return ipv4Address for type string
     */
    public static Ipv4Address of(String value) {
        return new Ipv4Address(value);
    }

    /**
     * Returns the attribute string.
     *
     * @return string value of string
     */
    public String string() {
        return string;
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Ipv4Address) {
            Ipv4Address other = (Ipv4Address) obj;
            return
                Objects.equals(string, other.string);
        }
        return false;
    }

    @Override
    public String toString() {
        return string;
    }
    /**
     * Returns the object of ipv4Address fromString input String ipv4Address.
     *
     * @param valInString value of input String
     * @return ipv4Address
     */
    public static Ipv4Address fromString(String valInString) {
        try {
            String tmpVal = (valInString);
            return of(tmpVal);
        } catch (Exception e) {
            throw new IllegalArgumentException("not a valid input element");
        }
    }
}
