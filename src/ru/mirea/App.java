package ru.mirea;

import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class App extends JFrame {
  private static final int WINDOW_WIDTH = 1000;
  private static final int WINDOW_HEIGHT = 600;

  private static final Font textFont = new Font("Free Mono", Font.PLAIN, 18);
//  private static String textColor = "Black";

  /**
   * Создаёт окно приложения
   */
  public App() {
    super("Super Text Editor");

    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    setLayout(null);

    JMenuBar menuBar = new JMenuBar();

    /* Пункты меню */
    JMenu fontOption = new JMenu("Family");
    JMenu fontColor = new JMenu("Color");

    /* Шрифты, которые можно выбрать */
    JMenuItem family1 = new JMenuItem("Free Mono");
    JMenuItem family2 = new JMenuItem("Ubuntu Mono");
    JMenuItem family3 = new JMenuItem("Liberation Serif");

    /* Различные цвета текста */
    JMenuItem color1 = new JMenuItem("Red");
    JMenuItem color2 = new JMenuItem("Blue");
    JMenuItem color3 = new JMenuItem("Black");

    /* Текстовое поле */
    JTextArea textArea = new JTextArea();

    /* Полоса прокрутки для текстового поля */
    JScrollPane scrollBar = new JScrollPane(textArea);

    /* Расположение меню и его размеры */
    menuBar.setBounds(0, 0, WINDOW_WIDTH, 28);

    /* Выбор шрифта для пунктов меню */
    fontOption.setFont(new Font("Free Mono", Font.BOLD, 15));
    fontColor.setFont(new Font("Free Mono", Font.BOLD, 15));

    /* Расположение текстового поля и его размеры, и ещё установка шрифта */
    textArea.setFont(textFont);
    scrollBar.setBounds(0, menuBar.getHeight(), WINDOW_WIDTH, WINDOW_HEIGHT - menuBar.getHeight());

    fontOption.add(family1);
    fontOption.add(family2);
    fontOption.add(family3);

    fontColor.add(color1);
    fontColor.add(color2);
    fontColor.add(color3);

    menuBar.add(fontOption);
    menuBar.add(fontColor);

    add(menuBar);
    add(scrollBar);
  }

  /**
   * Запускает приложение
   * @param args      аргументы командной строки
   */
  public static void main(String[] args) {
    App window = new App();

    window.setVisible(true);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}
