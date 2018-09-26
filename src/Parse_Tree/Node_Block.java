package Parse_Tree;

public class Node_Block {

    // Parent
    private String parent_block;

    // Children
    private String statement;
    private Node_Block child_node_block;

    // Variables
    private String child_block;
    private boolean syntax_error;

    public Node_Block(){}
    public Node_Block(String parent_block){
        // Store block string
        this.parent_block = parent_block.trim();

        // identify children
        if(this.parent_block.contains("\n")) {
            statement = this.parent_block.substring(0, this.parent_block.indexOf("\n")).trim();
            child_block = this.parent_block.substring(this.parent_block.indexOf("\n")+1).trim();
            expand(child_block);
        }
        else {
            statement = parent_block;
            child_node_block = null;
        }
    }

    private void expand(String expansion){
        child_node_block = new Node_Block(expansion);
    }

    // Output
    public void display_node(){
        System.out.println("Block node, children:");
        System.out.printf("\tstatement: \'%s\'\n", statement);
        if(child_block != null)
            System.out.printf("\tblock: \'%s\'\n", child_block);

        if(child_node_block != null)
            child_node_block.display_node();

    }
}
