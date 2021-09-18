package ru.mirea;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class App extends JFrame {
  private static final int WINDOW_WIDTH = 1000;
  private static final int WINDOW_HEIGHT = 600;

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
    JMenuItem[] families = {
      new JMenuItem("Free Mono"),
      new JMenuItem("Ubuntu Mono"),
      new JMenuItem("Liberation Serif")
    };

    /* Различные цвета текста */
    JMenuItem[] colors = {
      new JMenuItem("Red"),
      new JMenuItem("Blue"),
      new JMenuItem("Black")
    };

    /* Текстовое поле */
    JTextArea textArea = new JTextArea();

    /* Полоса прокрутки для текстового поля */
    JScrollPane scrollBar = new JScrollPane(textArea);

    /* Расположение меню и его размеры */
    menuBar.setBounds(0, 0, WINDOW_WIDTH, 28);

    /* Выбор шрифта для пунктов меню */
    fontOption.setFont(new Font("Free Mono", Font.BOLD, 15));
    fontColor.setFont(new Font("Free Mono", Font.BOLD, 15));

    /* Установка шрифта, переноса слов */
    textArea.setFont(new Font("Free Mono", Font.PLAIN, 18));
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);

    /* Расположение и размеры текстового поля */
    scrollBar.setBounds(0, menuBar.getHeight(), WINDOW_WIDTH, WINDOW_HEIGHT - menuBar.getHeight());

    /* Возможность сменить шрифт */
    for (JMenuItem item : families) {
      /* Выполнение действия при нажатии на пункт меню */
      item.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          String fontName = item.getText();       // название шрифта
          textArea.setFont(new Font(fontName, Font.PLAIN, 18));
        }
      });

      fontOption.add(item);
    }

    /* Возможность сменить цвет текста */
    for (JMenuItem item : colors) {
      /* Выполнение действия при нажатии на пункт меню */
      item.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          String fontName = item.getText();       // название шрифта
          textArea.setFont(new Font(fontName, Font.PLAIN, 18));
        }
      });

      fontOption.add(item);
    }

    /* Возможность сменить цвет текста */
    for (JMenuItem item : colors) {
      item.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          String color = item.getText();
          Color colorToSet;

          if (color.equals("Red")) {
            colorToSet = Color.RED;
          }
          else if (color.equals("Blue")) {
            colorToSet = Color.BLUE;
          }
          else {
            colorToSet = Color.BLACK;
          }

          textArea.setForeground(colorToSet);
        }
      });

      fontColor.add(item);
    }

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
