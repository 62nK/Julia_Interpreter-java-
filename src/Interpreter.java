import Parser.Parser;

public class Interpreter {
    public static void main(String[] args) {

        // Objects
        String filename;
        String path;
        Parser parser_instance;

        // Object initialization
        filename = "program2.txt";
        path = "src/Input/";
        parser_instance = new Parser(path+filename);

        parser_instance.parse();
        parser_instance.build_parse_tree();
        parser_instance.print_parsed_program();
    }
}
