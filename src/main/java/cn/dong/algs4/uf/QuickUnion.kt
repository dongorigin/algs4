package cn.dong.algs4.uf

/**
 * @author dong on 2018/08/04.
 */
class QuickUnion(n: Int) : UnionFind {
    private var count = n
    private val ids = IntArray(count, { it })

    override fun count(): Int {
        return count
    }

    override fun find(p: Int): Int {
        var root = p
        while (root != ids[root]) {
            root = ids[root]
        }
        return root
    }

    override fun connected(p: Int, q: Int): Boolean {
        return find(p) == find(q)
    }

    override fun union(p: Int, q: Int) {
        val pRoot = find(p)
        val qRoot = find(q)

        if (pRoot == qRoot) {
            return
        }

        ids[qRoot] = pRoot
        count--
    }
}