package EX3;
/*
 *
 * @author Danilo Sambugaro created on 12/11/2019 inside the package - EX3
 *
 */

public class MultiMatTask implements Runnable {
    private Integer[][] mat_a;
    private Integer[][] mat_b;
    private Integer[][] mat_result;
    private Integer line;
    private Integer column;
    private Integer size;


    public MultiMatTask(Integer[][] mat_a, Integer[][] mat_b, Integer[][] mat_result, Integer line, Integer column, Integer size) {
        this.mat_a = mat_a;
        this.mat_b = mat_b;
        this.mat_result = mat_result;
        this.line = line;
        this.column = column;
        this.size = size;
    }


    @Override
    public void run() {
        for (int k = 0; k < size; k++) {
            mat_result[line][column] += mat_a[line][k] * mat_b[k][column];
        }
    }
}
