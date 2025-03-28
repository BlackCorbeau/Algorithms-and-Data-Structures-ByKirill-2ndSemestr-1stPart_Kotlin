package org.exampl.ITable

abstract class ITable<T>() {
    public fun insert(Tval : T) {};
    public fun insert(Tkey: T, Tval: T) {};
    public fun eraise(Tkey: T) {};
    public fun find(Tkey: T) {};
}