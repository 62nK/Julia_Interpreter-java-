package Parse_Tree;

public class Node_Block {

    // Parent
    private String parent_block;

    // Children
    private String statement;
    private Node_Block child_node_block;

    // Variables
    private boolean syntax_error;

    public Node_Block(){}
    public Node_Block(String parent_block){
        this.parent_block = parent_block.trim();
        statement = this.parent_block.substring(0, this.parent_block.indexOf("\n"));
        String child_block = this.parent_block.substring(this.parent_block.indexOf("\n"));
        if(!child_block.isEmpty())
            expand(child_block);
        else
            child_node_block = null;
    }

    private void expand(String child_block){
        child_node_block = new Node_Block(child_block);
    }
}
