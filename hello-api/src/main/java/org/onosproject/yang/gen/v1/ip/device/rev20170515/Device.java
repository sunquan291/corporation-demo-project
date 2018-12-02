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

package org.onosproject.yang.gen.v1.ip.device.rev20170515;

import java.util.BitSet;

/**
 * Abstraction of an entity which represents the functionality of device.
 */
public interface Device {
    /**
     * Specify the node specific operation in protocols like NETCONF.
     * Applicable in protocol edit operation, not applicable in query operation
     */
    public static enum OnosYangOpType {
        MERGE,
        REPLACE,
        CREATE,
        DELETE,
        REMOVE,
        NONE
    }

    /**
     * Identify the leaf of Device.
     */
    public enum LeafIdentifier {
        /**
         * Represents manufacturer.
         */
        MANUFACTURER(1);

        private int leafIndex;

        public int getLeafIndex() {
            return leafIndex;
        }

        LeafIdentifier(int value) {
            this.leafIndex = value;
        }
    }

    /**
     * Returns the attribute manufacturer.
     *
     * @return manufacturer value of manufacturer
     */
    long manufacturer();

    /**
     * Returns the attribute valueLeafFlags.
     *
     * @return valueLeafFlags value of valueLeafFlags
     */
    BitSet valueLeafFlags();

    /**
     * Returns the attribute yangDeviceOpType.
     *
     * @return yangDeviceOpType value of yangDeviceOpType
     */
    OnosYangOpType yangDeviceOpType();

    /**
     * Returns the attribute selectLeafFlags.
     *
     * @return selectLeafFlags value of selectLeafFlags
     */
    BitSet selectLeafFlags();


    /**
     * Checks if the leaf value is set.
     *
     * @param leaf leaf whose value status needs to checked
     * @return result of leaf value set in object
     */
    boolean isLeafValueSet(LeafIdentifier leaf);

    /**
     * Checks if the leaf is set to be a selected leaf.
     *
     * @param leaf if leaf needs to be selected
     * @return result of leaf value set in object
     */
    boolean isSelectLeaf(LeafIdentifier leaf);

    /**
     * Builder for device.
     */
    interface DeviceBuilder {
        /**
         * Returns the attribute manufacturer.
         *
         * @return manufacturer value of manufacturer
         */
        long manufacturer();

        /**
         * Returns the attribute valueLeafFlags.
         *
         * @return valueLeafFlags value of valueLeafFlags
         */
        BitSet valueLeafFlags();

        /**
         * Returns the attribute yangDeviceOpType.
         *
         * @return yangDeviceOpType value of yangDeviceOpType
         */
        OnosYangOpType yangDeviceOpType();

        /**
         * Returns the attribute selectLeafFlags.
         *
         * @return selectLeafFlags value of selectLeafFlags
         */
        BitSet selectLeafFlags();

        /**
         * Returns the builder object of manufacturer.
         *
         * @param manufacturer value of manufacturer
         * @return manufacturer
         */
        DeviceBuilder manufacturer(long manufacturer);

        /**
         * Returns the builder object of yangDeviceOpType.
         *
         * @param yangDeviceOpType value of yangDeviceOpType
         * @return yangDeviceOpType
         */
        DeviceBuilder yangDeviceOpType(OnosYangOpType yangDeviceOpType);

        /**
         * Set a leaf to be selected.
         *
         * @param leaf leaf needs to be selected
         * @return builder object for select leaf
         */
        DeviceBuilder selectLeaf(LeafIdentifier leaf);

        /**
         * Builds object of device.
         *
         * @return device
         */
        Device build();
    }
}
