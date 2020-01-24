/*
 * Copyright 2020 Tenkiv, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package physikal

import kotlinx.serialization.*
import kotlinx.serialization.modules.*

val physikalSerializationModule = SerializersModule {

    polymorphic(Quantity::class) {
        KelvinQuantity::class with KelvinQuantity.serializer()
        CelsiusQuantity::class with CelsiusQuantity.serializer()
    }

    polymorphic(PhysicalUnit::class) {
        Kelvin::class with Kelvin.serializer()
        Celsius::class with Celsius.serializer()
    }

}

@Suppress("UNCHECKED_CAST")
fun <QT : Quantity<QT>> QuantitySerializer() : PolymorphicSerializer<Quantity<QT>> =
    PolymorphicSerializer(Quantity::class) as PolymorphicSerializer<Quantity<QT>>

@Suppress("UNCHECKED_CAST")
fun <QT : Quantity<QT>> PhysicalUnitSerializer() : PolymorphicSerializer<PhysicalUnit<QT>> =
    PolymorphicSerializer(PhysicalUnit::class) as PolymorphicSerializer<PhysicalUnit<QT>>