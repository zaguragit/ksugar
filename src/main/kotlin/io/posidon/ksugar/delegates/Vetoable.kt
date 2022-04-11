package io.posidon.ksugar.delegates

import kotlin.properties.Delegates
import kotlin.properties.ObservableProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

inline fun <T : Any?> Delegates.vetoable(crossinline onChange: (property: KProperty<*>, oldValue: T?, newValue: T?) -> Boolean): ReadWriteProperty<Any?, T?> =
    vetoable(null, onChange)


inline fun <T> Delegates.vetoable(initialValue: T, crossinline onChange: (oldValue: T, newValue: T) -> Boolean): ReadWriteProperty<Any?, T> =
    vetoable(initialValue) { _, old, new -> onChange(old, new) }

inline fun <T : Any?> Delegates.vetoable(crossinline onChange: (oldValue: T?, newValue: T?) -> Boolean): ReadWriteProperty<Any?, T?> =
    vetoable { _, old, new -> onChange(old, new) }


inline fun <T> Delegates.vetoable(initialValue: T, crossinline onChange: (value: T) -> Boolean): ReadWriteProperty<Any?, T> =
    vetoable(initialValue) { _, _, new -> onChange(new) }

inline fun <T : Any?> Delegates.vetoable(crossinline onChange: (value: T?) -> Boolean): ReadWriteProperty<Any?, T?> =
    vetoable { _, _, new -> onChange(new) }


inline fun <T> Delegates.vetoable(initialValue: T, crossinline onChange: () -> Boolean): ReadWriteProperty<Any?, T> =
    vetoable(initialValue) { _, _, _ -> onChange() }

inline fun <T : Any?> Delegates.vetoable(crossinline onChange: () -> Boolean): ReadWriteProperty<Any?, T?> =
    vetoable { _, _, _ -> onChange() }