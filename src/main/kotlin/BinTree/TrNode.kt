package org.exampl.BinTree

class TrNode<T>() {
    private var _value: T? = null;
    private var _left: TrNode<T>? = null;
    private var _right: TrNode<T>? = null;

    public var value: T?
        get() = _value;
        set(value) { _value = value; };

    public var left: TrNode<T>?
        get() = _left;
        set(left) {_left = left};

    public var right: TrNode<T>?
        get() = _right;
        set(right) { _right = right };

}