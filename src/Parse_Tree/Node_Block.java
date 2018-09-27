package Parse_Tree;

import Parse_Tree.Statements.Node_Statement;

public class Node_Block {

    // Parent
    private String parent_block;

    // Children
    private Node_Statement child_node_statement;
    private Node_Block child_node_block;

    // Variables
    private String child_statement;
    private String child_block;
    private boolean syntax_error;

    public Node_Block(){}
    public Node_Block(String parent_block){
        // Store block string
        this.parent_block = parent_block.trim();

        // identify children
        if(this.parent_block.contains("\n")) {
            child_statement = this.parent_block.substring(0, this.parent_block.indexOf("\n")).trim();
            child_block = this.parent_block.substring(this.parent_block.indexOf("\n")+1).trim();
        }
        else {
            child_statement = parent_block;
            child_node_block = null;
        }
        expand();
    }

    // Methods

    // Syntax check
    private boolean syntax_error(){
        return syntax_error;
    }
    private boolean statement_error(){return false;}

    // Create children
    private void expand(){
        if(child_block !=null)
            child_node_block = new Node_Block(child_block);
        child_node_statement = new Node_Statement(child_statement);
    }
    
    // Output
    public void display_node(){
        System.out.println("Block node, children:");
        System.out.printf("\tstatement: \'%s\'\n", child_statement);
        if(child_block != null)
            System.out.printf("\tblock: \'%s\'\n", child_block);

        display_error();
        child_node_statement.display_node();
        if(child_node_block != null && !syntax_error)
            child_node_block.display_node();
    }
    private void display_error(){
        if(!syntax_error())
            System.out.println("No errors found in Program Node");
        else {
            if(statement_error()) {
                System.out.println("Error in statement");
                System.out.printf("\tstatement: \'%s\' where it\'s supposed to be \'function'\n", child_statement);
            }
        }
    }
}
