package leetcode.`339-nested-list-weight-sum`

class NestedInteger {
    private var value: Int?
    private var list: MutableList<NestedInteger>?

    /**
     * Constructor initializes an empty nested list.
     */
    constructor() {
        value = null
        list = mutableListOf()
    }

    /**
     * Constructor initializes a single integer.
     */
    constructor(value: Int) {
        this.value = value
        list = null
    }

    /**
     * @return true if this is a single integer.
     */
    fun isInteger(): Boolean {
        return value != null
    }

    /**
     * @return value if it is a single integer.
     */
    fun getInteger(): Int? {
        return value
    }

    /**
     * Make it single integer and set the value.
     */
    fun setInteger(value: Int) {
        this.value = value
        list = null
    }

    /**
     * Make it nested list and add a nested integer.
     */
    fun add(ni: NestedInteger) {
        value = null
        if (list == null) {
            list = mutableListOf()
        }
        list!! += ni
    }

    /**
     * @return list if it is a list.
     */
    fun getList(): List<NestedInteger>? {
        return list
    }
}
