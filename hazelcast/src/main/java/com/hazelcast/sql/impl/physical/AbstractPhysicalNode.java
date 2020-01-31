/*
 * Copyright (c) 2008-2020, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.sql.impl.physical;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;

import java.io.IOException;

/**
 * Abstract physical node.
 */
public abstract class AbstractPhysicalNode implements PhysicalNode {
    /** ID. */
    protected int id;

    protected AbstractPhysicalNode() {
        // No-op.
    }

    protected AbstractPhysicalNode(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public final void writeData(ObjectDataOutput out) throws IOException {
        out.writeInt(id);

        writeData0(out);
    }

    @Override
    public final void readData(ObjectDataInput in) throws IOException {
        id = in.readInt();

        readData0(in);
    }

    protected void writeData0(ObjectDataOutput out) throws IOException {
        // No-op.
    }

    protected void readData0(ObjectDataInput in) throws IOException {
        // No-op.
    }
}