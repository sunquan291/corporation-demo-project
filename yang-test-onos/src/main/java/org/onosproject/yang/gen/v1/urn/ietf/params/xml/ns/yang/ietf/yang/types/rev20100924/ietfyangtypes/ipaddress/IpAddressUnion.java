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

package org.onosproject.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.yang.types.rev20100924.ietfyangtypes.ipaddress;

import org.onosproject.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.yang.types.rev20100924.ietfyangtypes.Ipv4Address;
import java.util.Objects;
import java.util.BitSet;

/**
 * Represents the implementation of ipAddressUnion.
 */
public final class IpAddressUnion {
    private Ipv4Address ipv4Address;
    private BitSet setValue = new BitSet();

    /**
     * Creates an instance of ipAddressUnion.
     */
    private IpAddressUnion() {
    }

    /**
     * Creates an instance of ipv4Address.
     *
     * @param ipv4Address value of ipv4Address
     */
    public IpAddressUnion(Ipv4Address ipv4Address) {
        setValue.set(0);
        this.ipv4Address = ipv4Address;
    }

    /**
     * Returns the object of ipAddressUnion for type ipv4Address.
     *
     * @param value value of ipAddressUnion for type ipv4Address
     * @return ipAddressUnion for type ipv4Address
     */
    public static IpAddressUnion of(Ipv4Address value) {
        return new IpAddressUnion(value);
    }

    /**
     * Returns the attribute ipv4Address.
     *
     * @return ipv4Address value of ipv4Address
     */
    public Ipv4Address ipv4Address() {
        return ipv4Address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipv4Address);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IpAddressUnion) {
            IpAddressUnion other = (IpAddressUnion) obj;
            return
                Objects.equals(ipv4Address, other.ipv4Address);
        }
        return false;
    }

    @Override
    public String toString() {
        if (setValue.get(0)) {
            return ipv4Address.toString();
        }
        return null;
    }
    /**
     * Returns the object of ipAddressUnion fromString input String ipAddressUnion.
     *
     * @param valInString value of input String
     * @return ipAddressUnion
     */
    public static IpAddressUnion fromString(String valInString) {
        try {
            Ipv4Address tmpVal = Ipv4Address.fromString(valInString);
            return of(tmpVal);
        } catch (Exception e) {
            throw new IllegalArgumentException("not a valid input element");
        }
    }
}
