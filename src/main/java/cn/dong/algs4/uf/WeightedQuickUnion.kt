package cn.dong.algs4.uf

/**
 * @author dong on 2018/08/04.
 */
class WeightedQuickUnion(n: Int) : UnionFind {
    private var count = n
    private val parent = IntArray(count, { it }) // parent[i] = parent of i
    private val treeSize = IntArray(count, { 1 }) // treeSize[i] = number of nodes in the subtree rooted at i

    override fun count(): Int {
        return count
    }

    override fun find(p: Int): Int {
        var root = p
        while (root != parent[root]) {
            root = parent[root]
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
        if (treeSize[pRoot] <= treeSize[qRoot]) {
            connectTree(pRoot, qRoot)
        } else {
            connectTree(qRoot, pRoot)
        }

        count--
    }

    private fun connectTree(sourceRoot: Int, targetRoot: Int) {
        parent[sourceRoot] = targetRoot
        treeSize[targetRoot] += treeSize[sourceRoot]
    }

}