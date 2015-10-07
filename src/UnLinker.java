import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnLinker {
    String clean(String text) {
        String pattern = "((http://)|(http://www\\.)|(www\\.))" + //前缀
                "([a-zA-Z0-9]?\\.?)*" + //域名
                "((\\.com)|(\\.org)|(\\.edu)|(\\.info)|(\\.tv))"; //后缀
        Pattern compile = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = compile.matcher(text);
        int count = 0;
        while (matcher.find()) {
            text = text.replaceFirst(matcher.group(0), "OMIT" + (++count));
        }
        return text;
    }
 
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("UnLinker.in"));
        String text;
        UnLinker ul = new UnLinker();
        while (in.hasNextLine()) {
            text = in.nextLine();
            System.out.println(ul.clean(text));
        }
        in.close();
    }
}