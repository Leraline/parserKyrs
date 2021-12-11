import org.jsoup.select.Elements;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Display {

    public static final int GRAPHIC_HIGH = 48;
    public static final int GRAPHIC_WIDTH = 164;
    private static final int LENGTH = 8;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Top8 crypto coins");

        JButton button = new JButton("Parsing");
        button.setBounds(1000, 20, 85, 20);
        frame.add(button, BorderLayout.NORTH);
        String[] columnNames = {"Icon", "Name", "Price", "Graph"};
        DefaultTableModel tm = new DefaultTableModel(initCrypto(), columnNames);
        JTable table = new JTable(tm);
        table.getColumnModel().getColumn(3).setPreferredWidth(((ImageIcon) tm.getValueAt(0, 3)).getIconWidth());
        table.setRowHeight(((ImageIcon) tm.getValueAt(0, 0)).getIconHeight());
        frame.add(table, BorderLayout.CENTER);

        frame.pack();
        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private static Object[][] initCrypto() {
        Object[][] data = new Object[LENGTH][4];

        Elements prices = CoinParser.getCoinPrice(CoinParser.getPage());
        Elements names = CoinParser.getCoinName(CoinParser.getPage());
        Elements icons = CoinParser.getCoinLinkImages(CoinParser.getPage());
        Elements graphs = CoinParser.getCoinWeeklyGraphic(CoinParser.getPage());
        for (int i = 0; i < LENGTH; i++) {
            data[i][0] = Downloader.downloadImage(icons.get(i).attr("src"));
            data[i][1] = names.get(i).text();
            data[i][2] = prices.get(i).text();
            data[i][3] = Downloader.downloadImage(graphs.get(i).attr("src"));
        }
        return data;
    }

}
