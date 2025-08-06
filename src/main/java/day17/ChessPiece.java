package day17;

public enum ChessPiece {
    // Король
    KING_WHITE(100, "♔"),
    KING_BLACK(100, "♚"),
    // Ферзь
    QUEEN_WHITE(9, "♕"),
    QUEEN_BLACK(9, "♛"),
    // Ладья
    ROOK_WHITE(5, "♖"),
    ROOK_BLACK(5, "♜"),
    // Слон
    BISHOP_WHITE(3.5, "♗"),
    BISHOP_BLACK(3.5, "♝"),
    // Конь
    KNIGHT_WHITE(3, "♘"),
    KNIGHT_BLACK(3, "♞"),
    // Пешка
    PAWN_WHITE(1, "♙"),
    PAWN_BLACK(1, "♟"),

    EMPTY(-1, "◻")
    ;

    private final double value;
    private final String symbol;

    ChessPiece(double value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public double getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }
}
