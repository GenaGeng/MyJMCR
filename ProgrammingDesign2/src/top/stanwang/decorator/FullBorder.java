package top.stanwang.decorator;

public class FullBorder extends Border {

    protected FullBorder(Display display) {
        super(display);
    }

    @Override
    public int getColumns() {
        return display.getColumns() + 2;
    }

    @Override
    public int getRows() {
        return display.getRows() + 2;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return '+' + getLine(display.getColumns(), '-') + "+";
        } else if (row == display.getRows() + 1) {
            return '+' + getLine(display.getColumns(), '-') + "+";
        } else {
            return "|" + display.getRowText(row-1) + "|";
        }
    }

    private String getLine(int count, char ch) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append('-');
        }
        return buf.toString();
    }
}
