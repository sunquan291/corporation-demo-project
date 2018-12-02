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

import com.google.common.base.MoreObjects;
import java.util.BitSet;
import java.util.Objects;

/**
 * Represents the implementation of device.
 *
 * <p>
 * valueLeafFlags identify the leafs whose value are explicitly set
 * Applicable in protocol edit and query operation.
 * </p>
 *
 * <p>
 * selectLeafFlags identify the leafs to be selected, in a query operation.
 * </p>
 *
 * <p>
 * Operation type specify the node specific operation in protocols like NETCONF.
 * Applicable in protocol edit operation, not applicable in query operation.
 * </p>
 */
public class DeviceOpParam implements Device {
    protected long manufacturer;
    protected BitSet valueLeafFlags = new BitSet();
    protected OnosYangOpType yangDeviceOpType;
    protected boolean isSubTreeFiltered;
    protected BitSet selectLeafFlags = new BitSet();

    @Override
    public long manufacturer() {
        return manufacturer;
    }

    @Override
    public BitSet valueLeafFlags() {
        return valueLeafFlags;
    }

    @Override
    public OnosYangOpType yangDeviceOpType() {
        return yangDeviceOpType;
    }
    /**
     * Returns the attribute isSubTreeFiltered.
     *
     * @return isSubTreeFiltered value of isSubTreeFiltered
     */
    public boolean isSubTreeFiltered() {
        return isSubTreeFiltered;
    }

    @Override
    public BitSet selectLeafFlags() {
        return selectLeafFlags;
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, valueLeafFlags, yangDeviceOpType, isSubTreeFiltered, selectLeafFlags);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeviceOpParam) {
            DeviceOpParam other = (DeviceOpParam) obj;
            return
                Objects.equals(manufacturer, other.manufacturer) &&
                Objects.equals(valueLeafFlags, other.valueLeafFlags) &&
                Objects
                .equals(yangDeviceOpType,
                 other.yangDeviceOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(selectLeafFlags, other.selectLeafFlags);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("manufacturer", manufacturer)
            .add("valueLeafFlags", valueLeafFlags)
            .add("yangDeviceOpType", yangDeviceOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("selectLeafFlags", selectLeafFlags)
            .toString();
    }
    /**
     * Creates an instance of device.
     *
     * @param builderObject value of builder object of device
     */
    protected DeviceOpParam(DeviceBuilder builderObject) {
        manufacturer = builderObject.manufacturer();
        valueLeafFlags = builderObject.valueLeafFlags();
        yangDeviceOpType = builderObject.yangDeviceOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        selectLeafFlags = builderObject.selectLeafFlags();
    }

    /**
     * Checks if the passed Device maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DeviceOpParam processSubtreeFiltering(Device appInstance, boolean isSelectAllSchemaChild) {
        DeviceBuilder subTreeFilteringResultBuilder = new DeviceBuilder();
        BitSet isAnySelectOrContainmentNode = new BitSet();
        if (!processLeafSubtreeFiltering(appInstance, subTreeFilteringResultBuilder, isAnySelectOrContainmentNode,
                    isSelectAllSchemaChild)) {
            return null;
        }
        if (!isSelectAllSchemaChild && !isAnySelectOrContainmentNode.get(0)) {
            return processSubtreeFiltering(appInstance, true);
        }
        return (DeviceOpParam) subTreeFilteringResultBuilder.buildForFilter();
    }

     private boolean processLeafSubtreeFiltering(Device appInstance, DeviceBuilder subTreeFilteringResultBuilder,
                BitSet isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        if (valueLeafFlags.get(LeafIdentifier.MANUFACTURER.getLeafIndex())) {
            if (appInstance.manufacturer() != manufacturer()) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.MANUFACTURER)) {
                    subTreeFilteringResultBuilder.manufacturer(manufacturer());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.manufacturer(appInstance.manufacturer());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.MANUFACTURER.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.manufacturer(appInstance.manufacturer());
        }

        return true;
    }

    /**
     * Creates an instance of deviceOpParam.
     */
    protected DeviceOpParam() {
    }

    /**
     * Returns the attribute deviceBuilder.
     *
     * @return deviceBuilder
     */
    public static DeviceBuilder builder() {
        return new DeviceBuilder();
    }

    @Override
    public boolean isLeafValueSet(LeafIdentifier leaf) {
        return valueLeafFlags.get(leaf.getLeafIndex());
    }

    @Override
    public boolean isSelectLeaf(LeafIdentifier leaf) {
        return selectLeafFlags.get(leaf.getLeafIndex());
    }

    /**
     * Represents the builder implementation of device.
     */
    public static class DeviceBuilder implements Device.DeviceBuilder {
        protected long manufacturer;
        protected BitSet valueLeafFlags = new BitSet();
        protected OnosYangOpType yangDeviceOpType;
        protected boolean isSubTreeFiltered;
        protected BitSet selectLeafFlags = new BitSet();



        @Override
        public long manufacturer() {
            return manufacturer;
        }

        @Override
        public BitSet valueLeafFlags() {
            return valueLeafFlags;
        }

        @Override
        public OnosYangOpType yangDeviceOpType() {
            return yangDeviceOpType;
        }
        /**
         * Returns the attribute isSubTreeFiltered.
         *
         * @return isSubTreeFiltered value of isSubTreeFiltered
         */
        public boolean isSubTreeFiltered() {
            return isSubTreeFiltered;
        }

        @Override
        public BitSet selectLeafFlags() {
            return selectLeafFlags;
        }

        @Override
        public DeviceBuilder manufacturer(long manufacturer) {
            valueLeafFlags.set(LeafIdentifier.MANUFACTURER.getLeafIndex());
            this.manufacturer = manufacturer;
            return this;
        }

        @Override
        public DeviceBuilder yangDeviceOpType(OnosYangOpType yangDeviceOpType) {
            this.yangDeviceOpType = yangDeviceOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public DeviceBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public DeviceBuilder selectLeaf(LeafIdentifier leaf) {
            selectLeafFlags.set(leaf.getLeafIndex());
            return this;
        }
        @Override
        public Device build() {
            return new DeviceOpParam(this);
        }

        /**
         * Builds object of device.
         *
         * @return device
         */
        public Device buildForFilter() {
            isSubTreeFiltered = true;
            return new DeviceOpParam(this);
        }
        /**
         * Creates an instance of deviceBuilder.
         */
        public DeviceBuilder() {
        }

    }
}
