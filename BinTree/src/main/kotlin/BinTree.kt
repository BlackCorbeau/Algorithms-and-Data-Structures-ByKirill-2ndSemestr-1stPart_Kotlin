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

    private fun _find(root: TrNode<U>?, _val: U): TrNode<U>? {
        root ?: return null
        return when {
            _val == root.value -> root
            _val > root.value!! -> _find(root.right, _val) // Без модификации дерева
            else -> _find(root.left, _val)
        }
    }

    public fun find(value: U): TrNode<U>? {
         return _find(root, value);
    }

    private fun _erase(root: TrNode<U>?, value: U): TrNode<U>? {
        root ?: return null

        when {
            value < root.value!! -> {
                root.left = _erase(root.left, value)
            }
            value > root.value!! -> {
                root.right = _erase(root.right, value)
            }
            else -> { // Нашли узел для удаления
                // Случай 1: Узел без детей или с одним ребенком
                if (root.left == null) return root.right
                if (root.right == null) return root.left

                // Случай 3: Узел с двумя детьми
                // Находим минимальное значение в правом поддереве (преемника)
                root.value = minValue(root.right!!)
                // Удаляем преемника
                root.right = _erase(root.right, root.value!!)
            }
        }
        return root
    }

    // Вспомогательная функция для нахождения минимального значения в поддереве
    private fun minValue(node: TrNode<U>): U {
        var current = node
        while (current.left != null) {
            current = current.left!!
        }
        return current.value!!
    }

    public fun erase(value: U) {
        root = _erase(_root, value)
    }
}