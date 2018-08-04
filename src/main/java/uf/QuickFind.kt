package uf

/**
 * @author dong on 2018/08/04.
 */
class QuickFind(n: Int) : UnionFind {
    private var count = n
    private val ids = IntArray(count, { it })

    override fun count(): Int {
        return count
    }

    override fun find(p: Int): Int {
        return ids[p]
    }

    override fun connected(p: Int, q: Int): Boolean {
        return find(p) == find(q)
    }

    override fun union(p: Int, q: Int) {
        val pId = find(p)
        val qId = find(q)

        if (pId == qId) {
            return
        }

        ids.forEachIndexed { index, i ->
            if (i == pId) {
                ids[index] = qId
            }
        }
        count--
    }
}
