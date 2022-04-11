package io.posidon.ksugar.delegates

import kotlin.properties.Delegates
import kotlin.properties.ObservableProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

inline fun <T> Delegates.observable(crossinline onChange: (property: KProperty<*>, oldValue: T?, newValue: T?) -> Unit): ReadWriteProperty<Any?, T?> =
    observable(null, onChange)


inline fun <T> Delegates.observable(initialValue: T, crossinline onChange: (oldValue: T, newValue: T) -> Unit): ReadWriteProperty<Any?, T> =
    observable(initialValue) { _, old, new -> onChange(old, new) }

inline fun <T> Delegates.observable(crossinline onChange: (oldValue: T?, newValue: T?) -> Unit): ReadWriteProperty<Any?, T?> =
    observable { _, old, new -> onChange(old, new) }


inline fun <T> Delegates.observable(initialValue: T, crossinline onChange: (value: T) -> Unit): ReadWriteProperty<Any?, T> =
    observable(initialValue) { _, _, new -> onChange(new) }

inline fun <T> Delegates.observable(crossinline onChange: (value: T?) -> Unit): ReadWriteProperty<Any?, T?> =
    observable { _, _, new -> onChange(new) }


inline fun <T> Delegates.observable(initialValue: T, crossinline onChange: () -> Unit): ReadWriteProperty<Any?, T> =
    observable(initialValue) { _, _, _ -> onChange() }

inline fun <T> Delegates.observable(crossinline onChange: () -> Unit): ReadWriteProperty<Any?, T?> =
    observable { _, _, _ -> onChange() }

var a: String? by Delegates.observable(::b)

fun b() {

}