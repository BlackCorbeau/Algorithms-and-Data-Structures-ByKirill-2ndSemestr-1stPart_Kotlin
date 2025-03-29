package org.exampl

class BinTree<U: Comparable<U>>(){
    private var _root: TrNode<U>?= null;

    var root: TrNode<U>?
        get() = _root;
        set(node) {_root = node; }

    constructor(root: TrNode<U>?): this(){
        this.root = root;
    }

    constructor(tr: BinTree<U>) : this(){
        root = tr.root;
    }

    private fun _insert(root: TrNode<U>?, _val: U): TrNode<U> {
        if (root == null) {
            return TrNode<U>(_val);
        }
        when{
            _val > root.value!! -> root.right = _insert(root.right, _val)
            _val < root.value!! -> root.left = _insert(root.left, _val)
        }
        return root;
    }

    public fun insert(value: U) { root = _insert(_root, value) }
}