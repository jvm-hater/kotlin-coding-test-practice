data class Node<T>(
    var data: T,
    var left: Node<T>? = null,
    var right: Node<T>? = null
)

class Tree {

    var root: Node<String>? = null

    fun add(data: String, left: String, right: String) {
        if(root == null){
            if(data != ".") root = Node(data)
            if(left != ".") root!!.left = Node(left)
            if(right != ".") root!!.right = Node(right)
            return
        }

        search(root!!,data,left,right)
    }

    private fun search(searchNode: Node<String>, data: String, left: String, right: String) {
        if(searchNode.data == data) {
            if(left != ".") searchNode.left = Node(left)
            if(right != ".") searchNode.right = Node(right)
            return
        }

        if(searchNode.left != null) search(searchNode.left!!,data,left,right)
        if(searchNode.right != null) search(searchNode.right!!,data,left,right)
    }

    fun preOrder(root: Node<String>) {
        print(root.data)
        if(root.left != null) preOrder(root.left!!)
        if(root.right != null) preOrder(root.right!!)
    }

    fun inOrder(root: Node<String>) {
        if(root.left != null) inOrder(root.left!!)
        print(root.data)
        if(root.right != null) inOrder(root.right!!)
    }

    fun postOrder(root: Node<String>){
        if(root.left != null) postOrder(root.left!!)
        if(root.right != null) postOrder(root.right!!)
        print(root.data)
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val tree =Tree()

    repeat(n) {
        val inputs = br.readLine().split(" ")
        tree.add(inputs[0], inputs[1], inputs[2])
    }

    tree.preOrder(tree.root!!)
    println()
    tree.inOrder(tree.root!!)
    println()
    tree.postOrder(tree.root!!)
}
