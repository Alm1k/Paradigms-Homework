public class GenericTabulator implements Tabulator {
    @Override
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws Exception {
        switch (mode) {
            case "i":
            case "d":
            case "bi":
                System.err.println(String.format("Work in mode '%s'", mode));
                break;
            default:
                throw new IllegalModeException(mode);
        }

        return null;
    }

    private class IllegalModeException extends Exception {
        IllegalModeException(String mode) {
            super(String.format("Illegal mode '%s'", mode));
        }
    }
}
