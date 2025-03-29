package org.exampl

class BinTree<U: Comparable<U>>(){
    private var _root: TrNode<U>?= null;

    var root: TrNode<U>?
        get() = _root;
        set(node) {_root = node; }

}