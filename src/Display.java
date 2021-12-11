import com.sun.javafx.binding.StringFormatter;
import org.jsoup.select.Elements;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Display {

    public static final int GRAPHIC_HIGH = 48;
    public static final int GRAPHIC_WIDTH = 164;


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

        Elements prices = CoinParser.getCoinPrice(CoinParser.getPager());
        Elements names = CoinParser.getCoinName(CoinParser.getPager());
        Elements icons = CoinParser.getCoinLinkImages(CoinParser.getPager());
        Elements graphs = CoinParser.getCoinWeeklyGraphic(CoinParser.getPager());
        System.out.println(" "+ prices.size() +" "+ names.size() +" "+ icons.size() +" "+ graphs.size() );
        if(prices.size() != names.size() || prices.size() != icons.size() ||prices.size() != graphs.size()){
            return new Object[][] {{}};
        }
        Object[][] data = new Object[prices.size()][4];
        for (int i = 0; i < prices.size(); i++) {
            data[i][0] = Downloader.downloadImage(icons.get(i).attr("src"));
            data[i][1] = names.get(i).text();
            data[i][2] = prices.get(i).text();
            data[i][3] = Downloader.downloadImage(graphs.get(i).attr("src"));
        }
        return data;
    }

}
