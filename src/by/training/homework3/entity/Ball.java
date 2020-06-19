package by.training.homework3.entity;

public class Ball {
    private Color color;
    private Size size;
    private double weight;

    public Ball(Color color, Size size, double weight) {
        this.color = color;
        this.size = size;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Ball ball = (Ball) object;

        return Double.compare(ball.weight, weight) == 0 &&
                ball.color == color &&
                ball.size == size;
    }

    @Override
    public int hashCode() {
        return (int) (31 * weight + color.hashCode() + size.hashCode());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nInformation about ball: ");
        sb.append("color: ").append(color);
        sb.append(", size: ").append(size);
        sb.append(", weight: ").append(weight);
        return sb.toString();
    }

    public enum Color {
        RED("Red"),
        ORANGE("Orange"),
        BLUE("Blue"),
        BLACK("Black"),
        WHITE("White"),
        GREY("Grey"),
        GREEN("Green");

        private final String colorName;

        Color(String colorName) {
            this.colorName = colorName;
        }

        public String getColorName() {
            return colorName;
        }
    }

    public enum Size {
        SMALL(20),
        MEDIUM(30),
        LARGE(40),
        HUGE(55);

        private final int volume;

        Size(int volume) {
            this.volume = volume;
        }

        public int getVolume() {
            return volume;
        }
    }
}
