/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.jmeter.testelement.schema

import org.apache.jmeter.testelement.TestElement
import org.apache.jmeter.testelement.property.BooleanProperty
import org.apiguardian.api.API
import kotlin.reflect.KProperty

/**
 * Describes a [BooleanProperty]: name, default value, and provides accessors for properties.
 * Use [BaseTestElementSchema.boolean] or [BaseTestElementSchema.booleanDescriptor] for building the property descriptors.
 * @since 5.6
 */
@API(status = API.Status.EXPERIMENTAL, since = "5.6")
public data class BooleanPropertyDescriptor<in Schema : BaseTestElementSchema>(
    override val shortName: String,
    override val name: String,
    override val defaultValue: Boolean?,
) : PropertyDescriptor<Schema, Boolean> {
    private companion object {
        private const val serialVersionUID: Long = 1
    }

    public operator fun get(target: TestElement): Boolean =
        target[this]

    public operator fun set(target: TestElement, value: Boolean) {
        target[this] = value
    }

    @JvmSynthetic
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun getValue(testElement: TestElement, property: KProperty<*>): Boolean {
        return testElement[this]
    }

    @JvmSynthetic
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun setValue(testElement: TestElement, property: KProperty<*>, value: Boolean) {
        testElement[this] = value
    }
}
