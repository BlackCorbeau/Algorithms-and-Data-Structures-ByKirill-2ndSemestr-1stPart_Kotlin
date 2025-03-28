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

    constructor(v: T?, l: TrNode<T>?, r: TrNode<T>?) : this() {
        _value = v;
        _right = r;
        _left = l;
    }

    constructor(node: TrNode<T>?): this() {
        if (node != null) {
            _value = node.value;
            _left = node.left;
            _right = node.right;
        }
    }
}