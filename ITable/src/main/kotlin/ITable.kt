package org.exampl

abstract class ITable<T>() {
    public open fun insert(Tval : T): T {return Tval};
    public open fun insert(Tkey: T, Tval: T): T {return Tval};
    public open fun eraise(Tkey: T): T {return Tkey};
    public open fun find(Tkey: T): T {return Tkey};
}