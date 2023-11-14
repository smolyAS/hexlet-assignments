package exercise;

import java.util.Arrays;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        int rows = image.length;
        int columns = image[0].length;

// Создаем новый двумерный массив с двойными размерами
        String[][] enlargedImage = new String[2 * rows][2 * columns];

// Увеличиваем изображение по горизонтали и вертикали
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                enlargedImage[2 * i][2 * j] = image[i][j];
                enlargedImage[2 * i][2 * j + 1] = image[i][j];
                enlargedImage[2 * i + 1][2 * j] = image[i][j];
                enlargedImage[2 * i + 1][2 * j + 1] = image[i][j];
            }
        }

        return enlargedImage;
    }

    public static void main(String[] args) {
        String[][] image = {{"#", "#", "#"}, {"#", " ", "#"}, {"#", "#", "#"}};
        String[][] enlargedImage = enlargeArrayImage(image);

        for (String[] row : enlargedImage) {
            System.out.println(Arrays.toString(row));
        }
    }
}
// END
