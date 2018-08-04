package uf

/**
 * @author dong on 2018/08/04.
 */
class WeightedQuickUnion(n: Int) : UnionFind {
    private var count = n
    private val ids = IntArray(count, { it })
    private val treeHeights = IntArray(count, { 1 })

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

        // 小树连接到大树上
        if (treeHeights[pRoot] <= treeHeights[qRoot]) {
            // p connect q
            ids[pRoot] = qRoot
            treeHeights[qRoot] += treeHeights[pRoot]
        } else {
            // q connect p
            ids[qRoot] = pRoot
            treeHeights[pRoot] += treeHeights[qRoot]
        }

        count--
    }

}