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

}