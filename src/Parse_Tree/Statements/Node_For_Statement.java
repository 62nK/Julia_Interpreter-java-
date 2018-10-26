package Parse_Tree.Statements;

import Parse_Tree.Node_Iter;
import Parse_Tree.Tokens.Lexemes;
import Parse_Tree.Node_Block;
import Parse_Tree.Tokens.Lexical_Analyzer;

public class Node_For_Statement {

    // Parent
    private String for_statement;

    // Children
    private Node_Block child_node_block;
    private Node_Iter child_node_iter;

    // Variables
    private String child_for;
    private String child_id;
    private String child_block;
    private String child_equal;
    private String child_iter;
    private String child_end;
    private boolean syntax_error;

    public Node_For_Statement(){}
    public Node_For_Statement(String for_statement){
        syntax_error = false;
        this.for_statement = for_statement.trim();

        // Identify Children
        if(!for_error()){
            child_for = this.for_statement.substring(0, this.for_statement.indexOf(" ")).trim();
            child_id = this.for_statement.substring(this.for_statement.indexOf(" "), this.for_statement.indexOf("=")).trim();
            child_equal = Lexemes.assignment_operator;
            child_iter = this.for_statement.substring(this.for_statement.indexOf(" "), this.for_statement.indexOf("\n")).trim();
            child_block = this.for_statement.substring(this.for_statement.indexOf("\n"), this.for_statement.length()-3).trim();
            child_end = this.for_statement.substring(this.for_statement.length()-3).trim();
            syntax_error();
        }
        else
            syntax_error = true;

        if(!syntax_error)
            expand();
    }

    private boolean syntax_error(){
        syntax_error = id_error() || iter_error() || block_error() || end_error();
        return syntax_error;
    }
    private boolean for_error() {
        if (!this.for_statement.contains("for") || !this.for_statement.contains(Lexemes.assignment_operator))
            return true;
        return false;
    }
    private boolean id_error(){
        Lexical_Analyzer id_analyzer = new Lexical_Analyzer(child_id);
        if(id_analyzer.get_type().equals("id"))
            return true;
        return false;
    }
    private boolean iter_error(){
        return false;
    }
    private boolean block_error() { return false; }
    private boolean end_error() {
        if(!child_end.equals("end"))
            return true;
        return false;
    }

    // Create children
    private void expand(){
        child_node_block = new Node_Block(child_block);
        child_node_iter = new Node_Iter(child_iter);
    }

    // Output
    public void display_node(){

    }
    private void display_error(){
        if(!syntax_error());

        else {

        }
    }
}
