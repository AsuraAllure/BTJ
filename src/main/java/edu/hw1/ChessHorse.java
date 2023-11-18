package edu.hw1;

public class ChessHorse {
    private final int[][] table;

    ChessHorse(int[][] chessTable) {
        this.table = chessTable;
    }

    private boolean attack(int i, int j) {
        final int LEFT_BORDER = 0;
        final int RIGHT_BORDER = 7;
        if (i < LEFT_BORDER || i > RIGHT_BORDER || j < LEFT_BORDER || j > RIGHT_BORDER) {
            return false;
        }
        return table[i][j] == 1;
    }

    public boolean knightBoardCapture() {
        final int sizeTable = 8;
        for (int row = 0; row < sizeTable; row++) {
            for (int col = 0; col < sizeTable; col++) {
                if (table[row][col] == 1) {
                    if (
                        attack(col - 2, row - 1)
                            || attack(col - 2, row + 1)
                            || attack(col - 1, row - 2)
                            || attack(col - 1, row + 2)
                            || attack(col + 2, row - 1)
                            || attack(col + 2, row + 1)
                            || attack(col + 1, row - 2)
                            || attack(col + 1, row + 2)
                    ) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
