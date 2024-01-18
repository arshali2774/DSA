package CharacterArray.ReplaceWithSpace;

/**
 * ReplaceWithSpace
 */
public class ReplaceWithSpace {

    public static void main(String[] args) {
        char ch[] = "Hello@World@Fine".toCharArray();
        int i = 0;
        while (i < ch.length) {
            if (ch[i] == '@') {
                ch[i] = ' ';
            }
            i++;
        }
        System.out.println(new String(ch));
    }
}