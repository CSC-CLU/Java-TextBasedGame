import ANSI_Escape_Code_Creator.ANSI_Escape_Code_Creator;
import static ANSI_Escape_Code_Creator.ANSI_Escape_Code_Creator_Static.*;

/**
 * Testing app for graphical features
 * @author erich (sudo-Eric)
 */
public class GraphicsTestApp {
    static int SCREEN_WIDTH = 80;
    static int SCREEN_HEIGHT = 25;

    static String MAIN_DISPLAY = new ANSI_Escape_Code_Creator(){{
        cursor_invisible();
        erase_display().cursor_position(1,1).SGR_clear().SGR_bold().append("╔══════╤══════╤══════╤");
        for (int i = 0; i < SCREEN_WIDTH-23; i++)
            append('═');
        append("╗\n").append('║').SGR_set_foreground_color("Red").append("HP:")
                .SGR_default_foreground_color().cursor_forward(3)
                .append('│').SGR_set_foreground_color("Blue").append("MP:")
                .SGR_default_foreground_color().cursor_forward(3)
                .append('│').SGR_set_foreground_color("Green").append("ST:")
                .SGR_default_foreground_color().cursor_forward(3)
                .append('│').cursor_forward(SCREEN_WIDTH-23).append("║\n")
                .append("╟──────┴──────┴──────┤").cursor_forward(SCREEN_WIDTH-23).append("║\n");
        for (int i = 0; i < SCREEN_HEIGHT - 8; i++)
            append('║').cursor_forward(20).append('│').cursor_forward(SCREEN_WIDTH-23).append("║\n");
        append('║').cursor_forward(20).append("├");
        for (int i = 0; i < SCREEN_WIDTH-23; i++)
            append('─');
        append("╢\n");
        for (int i = 0; i < 3; i++)
            append('║').cursor_forward(20).append('│').cursor_forward(SCREEN_WIDTH-23).append("║\n");
        append("╚════════════════════╧");
        for (int i = 0; i < SCREEN_WIDTH-23; i++)
            append('═');
        append("╝\n").SGR_clear();
    }}.toString();

    static String INVENTORY_DISPLAY = new ANSI_Escape_Code_Creator(){{
        int col = 5;
        int row = 3;
        cursor_invisible().cursor_position(++row,col).SGR_clear().SGR_bold()
                .append("╔════════════════════════════════════════════════════════╤═════════════╗").cursor_position(++row,col)
                .append("║                        Inventory                       │").SGR_set_foreground_color("Yellow")
                .append("Gold:").SGR_default_foreground_color().append("        ║").cursor_position(++row,col)
                .append("╟──────────────────┬──────────────────┬──────────────────┤").SGR_set_foreground_color("Yellow").append('$')
                .SGR_default_foreground_color().append("            ║").cursor_position(++row,col)
                .append("║                  │                  │                  ├─────────────╢").cursor_position(++row,col)
                .append("║                  │                  │                  │Description: ║").cursor_position(++row,col)
                .append("║                  │                  │                  │The health   ║").cursor_position(++row,col)
                .append("║                  │                  │                  │potion will  ║").cursor_position(++row,col)
                .append("║                  │                  │                  │heal the     ║").cursor_position(++row,col)
                .append("║                  │                  │                  │player 10HP. ║").cursor_position(++row,col)
                .append("║                  │                  │                  │             ║").cursor_position(++row,col)
                .append("║                  │                  │                  │             ║").cursor_position(++row,col)
                .append("║                  │                  │                  │             ║").cursor_position(++row,col)
                .append("║                  │                  │                  │             ║").cursor_position(++row,col)
                .append("║                  │                  │                  │             ║").cursor_position(++row,col)
                .append("║                  │                  │                  │             ║").cursor_position(++row,col)
                .append("║                  │                  │                  │             ║").cursor_position(++row,col)
                .append("║                  │                  │                  ├─────────────╢").cursor_position(++row,col)
                .append("║                  │                  │                  │Page:        ║").cursor_position(++row,col)
                .append("╚══════════════════╧══════════════════╧══════════════════╧═════════════╝");
    }}.toString();

    public static void main(String[] args) throws InterruptedException {
        try {
            erase_display();
            erase_display(3);

            System.out.print(MAIN_DISPLAY);

            cursor_visible();

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            renderHealth(0);
            renderMana(0);
            renderStamina(0);

            renderDescriptionText("This is an example of some text being displayed on the screen. " +
                    "This text is a single string in the program, but has been split into " +
                    "multiple lines to be able to fit onto the screen.\n\n" +
                    "The text renderer will also interoperate newline characters as a command " +
                    "to continue rendering on the next line.");

            renderMenuList(new String[]{
                    "Attack goblin", "Flee goblin", "Inventory", "Map", "Spell book", "Menu",
                    "Test of a menu item that wraps around to the next line",
                    "Test of the line after"});

//        for (int i = 0; i < 101; i++) {
//            renderHealth(i);
//            renderMana(i);
//            renderStamina(i);
//            Thread.sleep(50);
//        }

            renderDescriptionText("The text renderer will also clear the text rendering area when new text is " +
                    "rendered so that multiple messages do not overlap.\n\nThis should make it trivial to display " +
                    "new messages and description text to this area.");

            renderMenuList(new String[]{
                    "Attack chest", "Inspect chest", "Open chest", "Inventory", "Map", "Spell book", "Menu",
                    "Test of a menu item that wraps around to the next line",
                    "Test of the line after"});

            DummyItemClass[] inventory = {
                    new DummyItemClass("Health Potion", "The health potion will restore the player 10HP.", 1, 10),
                    new DummyItemClass("Mana Potion", "The mana potion will restore the player 10MP.", 1, 10),
                    new DummyItemClass("Stamina Potion", "The stamina potion will restore the player 10ST.", 1, 10),
                    new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(),
                    new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(),
                    new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(),
                    new DummyItemClass("Second Page Itm", "Item that begins the second page.", 1, 1),
                    new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(),
                    new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(),
                    new DummyItemClass(), new DummyItemClass(), new DummyItemClass(), new DummyItemClass(),
                    new DummyItemClass("Third Page Itm", "Item that begins the third page/", 1, 1),
                    new DummyItemClass(), new DummyItemClass(), new DummyItemClass()};
            renderInventory(inventory, 0);
//        for (int i = 0; i < inventory.length; i++) {
//            renderInventory(inventory, i);
//            Thread.sleep(200);
//        }


            cursor_position(SCREEN_HEIGHT + 1, 1);
        } catch (Exception e) {
            cursor_position(SCREEN_HEIGHT + 2, 1);
            throw e;
        }
    }

    private static void renderDescriptionText(String text) {
        renderTextBlock(2, 23, SCREEN_HEIGHT - 5, SCREEN_WIDTH-1, text);
    }

    private static void renderMenuList(String[] items) {
        final int width = 17;
        int height = SCREEN_HEIGHT - 4;
        int line = 4;
        ANSI_Escape_Code_Creator gen = new ANSI_Escape_Code_Creator();
        for (int i = 0; i < items.length; i++) {
            String item = items[i];
            int lastChar = 0;
            int lastSpace = 0;
            final int numberLine = line;
            for (int j = 0; j < item.length(); j++) {
                renderText(gen, line, 2, 3, "");
                if (j - lastChar >= width || item.charAt(j) == '\n') {
                    if (item.charAt(j) == '\n')
                        lastSpace = j;
                    renderText(gen, line, 5, width, item.substring(lastChar, lastSpace));
                    lastChar = lastSpace + 1;
                    line++;
                } else if (item.charAt(j) == ' ') {
                    lastSpace = j;
                }
            }
            if (item.length() != lastChar) {
                renderText(gen, line, 2, 3, "");
                renderText(gen, line, 5, width, item.substring(lastChar));
                line++;
            }
            renderText(gen, numberLine, 2, 3, String.format("%2d.", i+1));
        }
        for (int i = line; i < height + 4; i++) {
            renderText(gen, i, 2, width + 3, "");
        }
        System.out.print(gen);
    }

    private static void renderTextBlock(int startRow, int startCol, int endRow, int endCol, String text) {
        int width = endCol - startCol + 1;
        int lastChar = 0;
        int lastSpace = 0;
        int line = startRow;
        ANSI_Escape_Code_Creator gen = new ANSI_Escape_Code_Creator();
        for (int i = 0; i < text.length(); i++) {
            if (i - lastChar >= width || text.charAt(i) == '\n') {
                if (text.charAt(i) == '\n')
                    lastSpace = i;
                renderText(gen, line, startCol, width, text.substring(lastChar, lastSpace));
                lastChar = lastSpace + 1;
                line++;
            } else if (text.charAt(i) == ' ') {
                lastSpace = i;
            }
        }
        if (text.length() != lastChar) {
            renderText(gen, line, startCol, width, text.substring(lastChar));
            line++;
        }
        for (int i = line; i < endRow + 1; i++) {
            renderText(gen, i, startCol, width, "");
        }
        System.out.print(gen);
    }

    private static void renderInventory(DummyItemClass[] items, int selected) {
        System.out.print(INVENTORY_DISPLAY);
        final long gold = 1234567890L; // Where does gold come from?
        renderGold(gold);
        ANSI_Escape_Code_Creator gen = new ANSI_Escape_Code_Creator();
        int pages = ((items.length - 1) / 21) + 1;
        int page = (selected / 21) + 1;
        int offset = (selected / 21) * 21;
        int length = items.length - offset;
        int i = offset;
        renderText(gen, 21, 68, 8, String.format("%8s", String.format("%d/%d", page, pages)));
        if (items.length == 0) {
            renderText(gen, 21, 68, 8, String.format("%8s", String.format("%d/%d", 0, 0)));
            System.out.print(gen);
            return;
        }
        for (int col = 0; col < ((length - 1) / 7) + 1 && col < 3; col++) {
            for (int row = 0; row < ((length - 1) % 7) + 1 || ((length - (col * 7)) / 7 != 0 && row < 7); row++) {
                DummyItemClass item = items[((col * 7) + row) + offset];
                boolean selectedItem = ((col * 7) + row == selected - offset);
                renderText(gen, 7 + (2 * row), 6 + (19 * col), 18, String.format("%2d.%s", ++i, item.name), selectedItem);
                renderText(gen, 8 + (2 * row), 14 + (19 * col), 10, String.format("x%4d/%4d", item.count, item.maxCount));
                if (selectedItem) {
                    renderTextBlock(8, 63, 19, 75, item.description);
                }
            }
        }
        System.out.print(gen);
    }

    private static void renderText(ANSI_Escape_Code_Creator gen, int row, int col, int width, String line) {
        renderText(gen, row, col, width, line, "White");
    }

    private static void renderText(ANSI_Escape_Code_Creator gen, int row, int col, int width, String line, String color) {
        renderText(gen, row, col, width, line, color, false);
    }

    private static void renderText(ANSI_Escape_Code_Creator gen, int row, int col, int width, String line, boolean inverted) {
        renderText(gen, row, col, width, line, "White", inverted);
    }

    private static void renderText(ANSI_Escape_Code_Creator gen, int row, int col, int width, String line, String color, boolean inverted) {
        gen.cursor_invisible().cursor_position(row, col).SGR_set_foreground_color(color);
        if (inverted)
            gen.SGR_invert();
        gen.append(line);
        if (inverted)
            gen.SGR_not_reversed();
        for (int j = line.length(); j < width; j++)
            gen.append(' ');
    }

    private static void renderNumber(int row, int col, int width, long number, String color, boolean alignRight) {
        ANSI_Escape_Code_Creator gen = new ANSI_Escape_Code_Creator()
                .cursor_invisible().cursor_position(row,col);
        String str = Long.toString(number);
        SGR_set_foreground_color(color, _4BIT_COLOR);
        if (alignRight)
            for (int i = 0; i < width - str.length(); i++)
                gen.append(' ');
        gen.append(str);
        if (!alignRight)
            for (int i = 0; i < width - str.length(); i++)
                gen.append(' ');
        gen.SGR_clear();
        System.out.print(gen);
    }

    private static void renderHealth(int health) {
        renderNumber(2, 5, 3, health, "Red", true);
    }

    private static void renderMana(int mana) {
        renderNumber(2, 12, 3, mana, "Blue", true);
    }

    private static void renderStamina(int stamina) {
        renderNumber(2, 19, 3, stamina, "Green", true);
    }

    private static void renderGold(long gold) {
        renderNumber(6, 64, 12, gold, "Yellow", true);
    }
}

/**
 * This is a placeholder class for the items class.
 * This is onl for testing and should not be used in the main game.
 */
class DummyItemClass {
    String name;
    String description;
    int count;
    int maxCount;

    DummyItemClass() {
        this.name = "Generic Item";
        this.description = "This is a generic item.";
        this.count = 1;
        this.maxCount = 1;
    }

    DummyItemClass(String name, String description, int count, int maxCount) {
        this.name = name;
        this.description = description;
        this.count = count;
        this.maxCount = maxCount;
    }

    @Override
    public String toString() {
        return this.name + "\t" + this.count + " / " + this.maxCount;
    }
}
