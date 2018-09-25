package Parser;

import Parse_Tree.Node_Program;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Parser {

    // Objects
    private Node_Program program_node;
    private String filename;
    private String program;

    // Constructor
    public Parser(String filename){
        this.filename = filename;
    }

    // Methods
    public void parse(){
        try{ program = new String(Files.readAllBytes(Paths.get(filename)));}
        catch (IOException e){ System.out.println(e.toString()); }
    }
    public void build_parse_tree(){
        program_node = new Node_Program(program);
    }
    public void print_parsed_program(){
        System.out.println("#######################");
        System.out.printf("The program \"%s\" parsed is:\n", filename);
        System.out.println(program);
        System.out.println("#######################");
        program_node.display_node();
    }
}
