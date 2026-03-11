package projectbeta;

public class World {

    public static final int SIZE_X = 64;
    public static final int SIZE_Y = 64;
    public static final int SIZE_Z = 64;

    private int[][][] blocks = new int[SIZE_X][SIZE_Y][SIZE_Z];

    public World() {
        generate();
    }

    private void generate() {

        for (int x = 0; x < SIZE_X; x++) {
            for (int z = 0; z < SIZE_Z; z++) {
                for (int y = 0; y < SIZE_Y; y++) {

                    if (y == SIZE_Y - 1) {
                        blocks[x][y][z] = Block.GRASS_STONE;
                    } else {
                        blocks[x][y][z] = Block.STONE;
                    }

                }
            }
        }

    }

    public int getBlock(int x, int y, int z) {
        return blocks[x][y][z];
    }

}