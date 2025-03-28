package org.exampl

class TrNode<U: Comparable<U>>() {
    private var _value: U? = null;
    private var _left: TrNode<U>? = null;
    private var _right: TrNode<U>? = null;

    public var value: U?
        get() = _value;
        set(value) { _value = value; };

    public var left: TrNode<U>?
        get() = _left;
        set(left) {_left = left};

    public var right: TrNode<U>?
        get() = _right;
        set(right) { _right = right };

    constructor(v: U?, l: TrNode<U>?, r: TrNode<U>?) : this() {
        _value = v;
        _right = r;
        _left = l;
    }

    constructor(node: TrNode<U>?): this() {
        if (node != null) {
            _value = node.value;
            _left = node.left;
            _right = node.right;
        }
    }

    constructor(v:U?): this() {
        _value = v;
        _right = null;
        _left = null;
    }
}