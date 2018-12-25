package top.stanwang.decorator;

public class UpDownBorder extends Border{

    char ch;
    protected UpDownBorder(Display display,char ch) {
        super(display);
        this.ch = ch;
    }

    @Override
    public int getColumns() {
        return display.getColumns();
    }

    @Override
    public int getRows() {
        return display.getRows()+2;
    }

    @Override
    public String getRowText(int row) {
        if (row ==0){
            return getLine(display.getColumns(),ch);
        } else if (row == display.getRows()+1){
            return getLine(display.getColumns(),ch);
        } else {
            return display.getRowText(row-1);
        }
    }

    private String getLine(int count, char ch) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }
}
