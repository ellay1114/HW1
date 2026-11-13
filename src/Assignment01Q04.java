
import java.util.Arrays;

public class Assignment01Q04 {

    private enum Direction {
        RIGHT('R'),
        LEFT('L');

        private final char code;

        Direction(char code) {
            this.code = code;
        }

        public static Direction fromChar(char c) {
            for (Direction dir : values()) {
                if (dir.code == c) {
                    return dir;
                }
            }
            return null;
        }

        public Direction getOpposite() {
            return this == RIGHT ? LEFT : RIGHT;
        }
    }

    private static int getNewValIndex(int arrayLength, int index, int move, Direction dir) {
        int newValIndex = (dir == Direction.RIGHT) ? index + move : index - move;

        newValIndex = newValIndex % arrayLength;
        if (newValIndex < 0) {
            newValIndex += arrayLength;
        }

        return newValIndex;
    }

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        // Validate the input
        Direction dir = Direction.fromChar(direction);
        if (dir == null) {
            return array;
        }

        // Handle reverse direction
        if (move < 0) {
            move = -move;
            dir = dir.getOpposite();
        }

        // Implement the shifting on the original array
        final int[] backupArray = array.clone();
        for (int i = 0; i < array.length; i++) {
            array[getNewValIndex(array.length, i, move, dir)] = backupArray[i];
        }

        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
                shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}
